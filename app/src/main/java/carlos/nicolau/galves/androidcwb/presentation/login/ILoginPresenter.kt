package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.utils.Contract

interface ILoginPresenter {
    interface View: Contract.View {
        fun showLoading()
        fun hideLoading()
        fun goToHome()
        fun errorLogin()
    }

    interface Presenter: Contract.Presenter<View> {
        fun onClickBtnLogin(username: String, password: String)
    }
}