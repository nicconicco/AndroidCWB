package carlos.nicolau.galves.androidcwb.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

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
                            it.erroType == LoginViewModel.ErroType.ERRO_404 -> {
                                errorLogin(LoginViewModel.ErroType.ERRO_404.value)
                            }
                            it.erroType == LoginViewModel.ErroType.ERRO_265 -> {
                                errorLogin(LoginViewModel.ErroType.ERRO_265.value)
                            }
                            it.erroType == LoginViewModel.ErroType.ERRO_INTERNET -> {
                                errorLogin(LoginViewModel.ErroType.ERRO_INTERNET.value)
                            }
                        }
                    }
                }
            })
            loginViewModel.onClickBtnLogin(username.text.toString(), password.text.toString())
        }
    }
}
