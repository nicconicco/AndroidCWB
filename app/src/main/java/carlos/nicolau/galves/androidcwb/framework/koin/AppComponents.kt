package carlos.nicolau.galves.androidcwb.framework.koin

import carlos.nicolau.galves.androidcwb.framework.koin.modules.appModule
import carlos.nicolau.galves.androidcwb.framework.koin.modules.presenterModule
import carlos.nicolau.galves.androidcwb.framework.koin.modules.repositoryModule
import carlos.nicolau.galves.androidcwb.framework.koin.modules.userCaseModule

val appComponent = listOf(
    appModule,
    userCaseModule,
    presenterModule,
    repositoryModule
)