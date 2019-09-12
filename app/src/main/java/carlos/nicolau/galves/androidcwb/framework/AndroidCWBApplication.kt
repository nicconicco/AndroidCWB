package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.database.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpFactory
import carlos.nicolau.galves.androidcwb.framework.koin.appComponent
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidCWBApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {

        AndroidCWBMvpFactory.inject(
            Interactors(
                getUserUseCaseImpl()
            )
        )
    }

    private fun getUserUseCaseImpl(): GetUserUseCaseImpl {
        return GetUserUseCaseImpl(
            GetUserRepositoryImpl(
                GetUserDataSource(
                )
            )
        )
    }
}