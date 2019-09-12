package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.core.interators.IGetUserUseCase
import carlos.nicolau.galves.utils.BasePresenter

class LoginPresenterImpl(private val getUserUseCase: IGetUserUseCase) :
    BasePresenter<ILoginPresenter.View>(), ILoginPresenter.Presenter {

    override fun onClickBtnLogin(username: String, password: String) {

        mView?.showLoading()

        val user = getUserUseCase.execute(username, password)

        mView?.hideLoading()

        if (user.didLogin) {
            mView?.goToHome()
        } else {
            mView?.errorLogin()
        }
    }
}