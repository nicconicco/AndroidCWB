package carlos.nicolau.galves.androidcwb.presentation.login

interface LoginViewModel {

    enum class ErroType(val value: String) {
        ERRO_INTERNET("Sem internet"),
        ERRO_404("Erro 404"),
        ERRO_265("Erro consulte o código 265 do servidor")
    }

    open class ViewState {
        data class isLoading(val load: Boolean) : ViewState()
        object goToHome : ViewState()
        data class errorLogin(val erroType: ErroType = ErroType.ERRO_404) : ViewState()
    }

    interface actions {
        fun onClickBtnLogin(username: String, password: String)
    }
}