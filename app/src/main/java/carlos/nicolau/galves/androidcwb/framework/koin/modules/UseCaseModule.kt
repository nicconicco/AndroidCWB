package carlos.nicolau.galves.androidcwb.framework.koin.modules

import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import org.koin.dsl.module

val userCaseModule = module {
    factory {
        GetUserUseCaseImpl(
            get()
        )
    }
}