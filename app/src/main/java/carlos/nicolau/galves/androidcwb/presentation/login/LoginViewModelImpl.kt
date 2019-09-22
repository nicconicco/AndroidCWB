package carlos.nicolau.galves.androidcwb.presentation.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvvm
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import kotlinx.coroutines.*
import java.lang.Exception
import java.net.ServerSocket


class LoginViewModelImpl(
    application: Application,
    db: AndroidCWBRoom,
    interactors: IGetUserUseCase,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher
) :
    AndroidCWBMvvm(
        application, db, interactors, mainDispacher, ioDispacher
    ), LoginViewModel.actions {

    private val _viewState = MutableLiveData<LoginViewModel.ViewState>()
    val viewState: LiveData<LoginViewModel.ViewState> get() = _viewState

    private val uiScope = CoroutineScope(mainDispacher + job)
    private val ioScope = CoroutineScope(ioDispacher + job)

    init {
        _viewState.value = LoginViewModel.ViewState()
    }

    override fun onClickBtnLogin(username: String, password: String) {

        _viewState.value = _viewState.value!!.copy(isLoading = true)

        uiScope.launch {
            getUser(username, password)
        }
    }

    private suspend fun getUser(username: String, password: String) {

        try {
            val user = ioScope.async {
                return@async interactors.execute(username, password)
            }.await()

            _viewState.value = _viewState.value!!.copy(isLoading = false)

            user?.let {
                _viewState.value = _viewState.value!!.copy(goToHome = true)
            } ?: run {
                _viewState.value =
                    _viewState.value!!.copy(errorLogin = LoginViewModel.ErroType.ERRO_INTERNET)
            }

        } catch (e: Exception) {

        }
    }
}