package carlos.nicolau.galves.androidcwb.presentation.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import carlos.nicolau.galves.androidcwb.framework.di.AndroidCWBMvvm
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.interators.GetUserUseCase
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

    val _viewState by lazy {  MutableLiveData<LoginViewModel.ViewState>() }
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

        val user = ioScope.async {
            return@async interactors.execute(username, password)
        }.await()

        _viewState.value = LoginViewModel.ViewState.isLoading(false)

        user?.let {
            _viewState.value = LoginViewModel.ViewState.goToHome
        } ?: run {
            _viewState.value =
                LoginViewModel.ViewState.errorLogin(LoginViewModel.ErroType.ERRO_INTERNET)
        }
    }
}