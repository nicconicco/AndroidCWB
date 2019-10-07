package carlos.nicolau.galves.androidcwb.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.presentation.home.HomeActivity
import carlos.nicolau.galves.core.errors.ErrorType
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
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
                            it.erroType == ErrorType.ERRO_404 ->
                                errorLogin(ErrorType.ERRO_404.value)

                            it.erroType == ErrorType.ERRO_265 ->
                                errorLogin(ErrorType.ERRO_265.value)

                            it.erroType == ErrorType.ERRO_INTERNET ->
                                errorLogin(ErrorType.ERRO_INTERNET.value)

                            it.erroType == ErrorType.ERRO_USER_NOT_FOUND ->
                                errorLogin(ErrorType.ERRO_USER_NOT_FOUND.value)
                        }
                    }
                }
            })

            loginViewModel.onClickBtnLogin(username.text.toString(), password.text.toString())
        }
    }
}
