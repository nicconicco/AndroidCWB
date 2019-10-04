package carlos.nicolau.galves.androidcwb.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.presentation.home.HomeActivity
import carlos.nicolau.galves.core.errors.ErroType
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    //region actions
    fun errorLogin(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    fun hideLoading() {
        loading.visibility = View.INVISIBLE
    }

    //endregion actions
    val loginViewModel: LoginViewModelImpl by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
    }

    private fun setupView() {
        login.setOnClickListener {
            loginViewModel.viewState.observe(this, Observer {
                when (it) {
                    is LoginViewModel.ViewState.isLoading -> {
                        when (it.load) {
                            true -> {
                                showLoading()
                            }
                            false -> {
                                hideLoading()
                            }
                        }
                    }

                    is LoginViewModel.ViewState.goToHome -> {
                        goToHome()
                    }

                    is LoginViewModel.ViewState.errorLogin -> {
                        when {
                            it.erroType == ErroType.ERRO_404 ->
                                errorLogin(ErroType.ERRO_404.value)

                            it.erroType == ErroType.ERRO_265 ->
                                errorLogin(ErroType.ERRO_265.value)

                            it.erroType == ErroType.ERRO_INTERNET ->
                                errorLogin(ErroType.ERRO_INTERNET.value)

                            it.erroType == ErroType.ERRO_USER_NOT_FOUND ->
                                errorLogin(ErroType.ERRO_USER_NOT_FOUND.value)
                        }
                    }
                }
            })

            loginViewModel.onClickBtnLogin(username.text.toString(), password.text.toString())
        }
    }
}
