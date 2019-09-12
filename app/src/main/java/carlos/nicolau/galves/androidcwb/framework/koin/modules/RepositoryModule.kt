package carlos.nicolau.galves.androidcwb.framework.koin.modules

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        GetUserRepositoryImpl(
            get()
        )
    }
}