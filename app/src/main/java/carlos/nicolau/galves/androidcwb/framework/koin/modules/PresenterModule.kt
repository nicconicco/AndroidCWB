package carlos.nicolau.galves.androidcwb.framework.koin.modules

import carlos.nicolau.galves.androidcwb.presentation.login.LoginPresenterImpl
import org.koin.dsl.module

val presenterModule = module {
    factory {
        LoginPresenterImpl(get())
    }
}