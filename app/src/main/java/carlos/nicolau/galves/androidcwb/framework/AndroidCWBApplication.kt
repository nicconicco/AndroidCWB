package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.database.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpFactory
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl

class AndroidCWBApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        injectDependencies()
    }

    private fun injectDependencies() {

        AndroidCWBMvpFactory.inject(
            Interactors(
                getUserUseCaseImpl()
            ),
            AppDispatcherProvider().io(),
            AppDispatcherProvider().ui()
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