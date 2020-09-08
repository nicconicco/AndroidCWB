package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.core.interators.GetUserUseCase
import carlos.nicolau.galves.utils.BasePresenter

class LoginPresenterImpl(
    private val getUserUserCase: GetUserUseCase
)
    : BasePresenter<LoginPresenter.View>(), LoginPresenter.Presenter {

    override fun onClickButtonLogin(username: String, password: String) {
        mView?.showLoading()
        val user = getUserUserCase.execute(username, password)
        mView?.hideLoading()
    }
}