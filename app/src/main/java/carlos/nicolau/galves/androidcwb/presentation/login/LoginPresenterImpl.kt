package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import carlos.nicolau.galves.utils.BasePresenter
import kotlinx.coroutines.*


class LoginPresenterImpl(
    private val getUserUseCase: IGetUserUseCase,
    mainDispacher : CoroutineDispatcher,
    ioDispacher : CoroutineDispatcher
) :
    BasePresenter<ILoginPresenter.View>(), ILoginPresenter.Presenter {

    private val uiScope = CoroutineScope(mainDispacher + job)
    val ioScope = CoroutineScope(ioDispacher + job)

    override fun onClickBtnLogin(username: String, password: String) {

        mView?.showLoading()

        uiScope.launch {
            getUser(username, password)
        }
    }

    private suspend fun getUser(username: String, password: String) {

        val userFromUseCase: User? = ioScope.async {
            return@async getUserUseCase.execute(username, password)
        }.await()

        mView?.hideLoading()

        userFromUseCase?.let {
            mView?.goToHome()
        } ?: run {
            mView?.errorLogin()
        }
    }
}