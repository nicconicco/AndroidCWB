package carlos.nicolau.galves.androidcwb.presentation.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpFactory
import carlos.nicolau.galves.androidcwb.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ILoginPresenter.View {

    //region ILoginPresenter.View
    override fun errorLogin() {
        Toast.makeText(this, "Login Fail", Toast.LENGTH_LONG).show()
    }

    override fun goToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.INVISIBLE
    }
    //endregion

    private lateinit var loginPresenterImpl: LoginPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupView()
    }

    private fun setupView() {

        loginPresenterImpl = LoginPresenterImpl(
            AndroidCWBMvpFactory.dependencies.getUser,
            AndroidCWBMvpFactory.ui,
            AndroidCWBMvpFactory.io
        )

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
