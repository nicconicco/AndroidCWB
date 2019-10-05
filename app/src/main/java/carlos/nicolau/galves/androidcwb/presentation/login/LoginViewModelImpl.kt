package carlos.nicolau.galves.androidcwb.presentation.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import carlos.nicolau.galves.androidcwb.framework.di.AndroidCWBMvvm
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.interators.GetUserUseCase
import carlos.nicolau.galves.core.utils.Callback
import kotlinx.coroutines.*

class LoginViewModelImpl(
    application: Application,
    db: AndroidCWBRoom,
    interactors: GetUserUseCase,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher
) :
    AndroidCWBMvvm(
        application, db, interactors, mainDispacher, ioDispacher
    ), LoginViewModel.actions {

    private val _viewState by lazy { MutableLiveData<LoginViewModel.ViewState>() }
    val viewState: LiveData<LoginViewModel.ViewState> get() = _viewState

    private val uiScope = CoroutineScope(mainDispacher + job)
    private val ioScope = CoroutineScope(ioDispacher + job)

    override fun onClickBtnLogin(username: String, password: String) {

        _viewState.value = LoginViewModel.ViewState.isLoading(true)

        uiScope.launch {
            getUser(username, password)
        }
    }

    private suspend fun getUser(username: String, password: String) {
        ioScope.async {
            return@async interactors.execute(
                username,
                password,
                object : Callback<User, ErroType>() {
                override fun onSuccess(result: User) {
                    _viewState.value = LoginViewModel.ViewState.isLoading(false)
                    _viewState.value = LoginViewModel.ViewState.goToHome
                }

                override fun onError(error: ErroType) {
                    super.onError(error)
                    _viewState.value = LoginViewModel.ViewState.isLoading(false)
                    _viewState.value = LoginViewModel.ViewState.errorLogin(ErroType.ERRO_INTERNET)
                }
            })
        }.await()
    }
}