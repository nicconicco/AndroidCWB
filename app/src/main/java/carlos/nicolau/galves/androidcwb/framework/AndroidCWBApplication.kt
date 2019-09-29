package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.di.appModule
import carlos.nicolau.galves.androidcwb.framework.di.injectInvoiceModulesDependencies
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidCWBApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
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
                GetUserDataSourceImpl(
                    AndroidCWBRoom.getDatabase(this)
                )
            )
        )
    }

}