package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.appModule
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidCWBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        startKoin {
            androidLogger()
            androidContext(this@AndroidCWBApplication)
            modules(appModule)
        }

//        AndroidCWBMvpFactory.inject(
//            this,
//            AndroidCWBRoom.getDatabase(this),
//            Interactors(
//                getUserUseCaseImpl()
//            ),
//            AppDispatcherProvider().ui(),
//            AppDispatcherProvider().io()
//        )
    }

    private fun getUserUseCaseImpl(): GetUserUseCaseImpl {
        return GetUserUseCaseImpl(
            GetUserRepositoryImpl(
                GetUserDataSource(
                    AndroidCWBRoom.getDatabase(this)
                )
            )
        )
    }

}