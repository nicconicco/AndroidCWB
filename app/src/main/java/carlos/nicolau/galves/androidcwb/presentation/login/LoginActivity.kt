package carlos.nicolau.galves.androidcwb.presentation.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.core.interators.GetUserUseCase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginPresenter.View {

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.INVISIBLE
    }

    private lateinit var loginPresenterImpl: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
    }

    private fun setupView() {

        loginPresenterImpl = LoginPresenterImpl(GetUserUseCase())
        loginPresenterImpl.attach(this)

        login.setOnClickListener {
            loginPresenterImpl.onClickBtnLogin(username.text.toString(), password.text.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenterImpl.detach()
    }
}
