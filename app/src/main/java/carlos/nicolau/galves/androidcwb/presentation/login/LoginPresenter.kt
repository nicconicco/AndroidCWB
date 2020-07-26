package carlos.nicolau.galves.androidcwb.presentation.login

import carlos.nicolau.galves.utils.Contract

interface LoginPresenter {
    interface View: Contract.View {
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter: Contract.Presenter<View> {
        fun onClickButtonLogin(username: String, password: String)
    }
}