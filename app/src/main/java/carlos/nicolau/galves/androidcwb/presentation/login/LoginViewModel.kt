package carlos.nicolau.galves.androidcwb.presentation.login


interface LoginViewModel {

    enum class ErroType(val value: String){
        ERRO_INTERNET("Sem internet"),
        ERRO_404("Erro 404"),
        ERRO_265("Erro consulte o código 265 do servidor")
    }

    data class ViewState(
        var isLoading: Boolean = false,
        var goToHome: Boolean = false,
        var errorLogin: ErroType = ErroType.ERRO_404
    )

    interface actions {
        fun onClickBtnLogin(username: String, password: String)
    }
}