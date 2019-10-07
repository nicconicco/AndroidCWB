package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.core.errors.ErrorType

interface LoginViewModel {

    open class ViewState {
        data class isLoading(val load: Boolean) : ViewState()
        object goToHome : ViewState()
        data class errorLogin(val erroType: ErrorType = ErrorType.ERRO_404) : ViewState()
    }

    interface actions {
        fun onClickBtnLogin(username: String, password: String)
    }
}