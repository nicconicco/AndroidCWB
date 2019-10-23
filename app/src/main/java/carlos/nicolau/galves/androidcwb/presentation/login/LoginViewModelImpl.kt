package carlos.nicolau.galves.androidcwb.presentation.login

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import carlos.nicolau.galves.androidcwb.framework.di.AndroidCWBMvvm
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtils
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtilsImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.interators.GetUserUseCase
import carlos.nicolau.galves.core.utils.Callback
import kotlinx.coroutines.*

class LoginViewModelImpl(
    application: Application,
    db: AndroidCWBRoom,
    interactors: GetUserUseCase,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher,
    internetUtils: InternetUtils
) :
    AndroidCWBMvvm(
        application, db, interactors, mainDispacher, ioDispacher, internetUtils
    ), LoginViewModel.actions {

    private val _viewState by lazy { MutableLiveData<LoginViewModel.ViewState>() }
    val viewState: LiveData<LoginViewModel.ViewState> get() = _viewState

    private val uiScope = CoroutineScope(mainDispacher + job)
    private val ioScope = CoroutineScope(ioDispacher + job)

    override fun onClickBtnLogin(username: String, password: String) {

        _viewState.value = LoginViewModel.ViewState.isLoading(true)

        if (internetUtils.isNetworkAvailable()) {
            uiScope.launch {
                getUser(username, password)
            }
        } else {
            _viewState.value = LoginViewModel.ViewState.isLoading(false)
            _viewState.value = LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_INTERNET)
        }
    }

    private suspend fun getUser(username: String, password: String) {
        ioScope.async {
            return@async interactors.execute(
                username,
                password,
                object : Callback<User, ErrorType>() {
                    override fun onSuccess(user: User) {
                        saveInRoom(user)

                        _viewState.value = LoginViewModel.ViewState.isLoading(false)
                        _viewState.value = LoginViewModel.ViewState.goToHome

                    }

                    override fun onError(error: ErrorType) {
                        super.onError(error)
                        _viewState.value = LoginViewModel.ViewState.isLoading(false)
                        _viewState.value = LoginViewModel.ViewState.errorLogin(error)
                    }
                })
        }.await()
    }

    private fun saveInRoom(user: User) {
        uiScope.launch {
            saveInDB(user)
        }
    }

    private suspend fun saveInDB(user: User) {
        ioScope.async {
            return@async interactors.saveInDB(user
               )
        }.await()
    }
}