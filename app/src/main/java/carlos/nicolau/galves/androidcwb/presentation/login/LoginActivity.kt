package carlos.nicolau.galves.androidcwb.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpFactory
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.presentation.home.HomeActivity
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
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

//    private lateinit var loginViewModel: LoginViewModelImpl
    val loginViewModel: LoginViewModelImpl by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
    }

    private fun setupView() {

//        loginViewModel = ViewModelProviders.of(this, AndroidCWBMvpFactory)
//            .get(LoginViewModelImpl::class.java)

        login.setOnClickListener {
            loginViewModel.viewState.observe(this, Observer {
                when (it.isLoading) {
                    true -> showLoading()
                    false -> hideLoading()
                }

                when (it.goToHome) {
                    true -> goToHome()
                }

                when (it.errorLogin) {
                    LoginViewModel.ErroType.ERRO_404 -> {
                        errorLogin(LoginViewModel.ErroType.ERRO_404.value)
                    }
                    LoginViewModel.ErroType.ERRO_265 -> {
                        errorLogin(LoginViewModel.ErroType.ERRO_265.value)
                    }
                    LoginViewModel.ErroType.ERRO_INTERNET -> {
                        errorLogin(LoginViewModel.ErroType.ERRO_INTERNET.value)
                    }
                }
            })
            loginViewModel.onClickBtnLogin(username.text.toString(), password.text.toString())
        }
    }
}
