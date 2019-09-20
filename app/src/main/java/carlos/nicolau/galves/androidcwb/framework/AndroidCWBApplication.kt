package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpFactory
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.provider.Interactors
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom.Companion.getDatabase
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl

class AndroidCWBApplication : Application() {

    companion object {
        var db: AndroidCWBRoom? = null
    }

    fun getDb(): AndroidCWBRoom {
        return db!!
    }

    override fun onCreate() {
        super.onCreate()
        db = getDatabase(this)

        injectDependencies()
    }

    private fun injectDependencies() {

        AndroidCWBMvpFactory.inject(
            getDb(),
            AppDispatcherProvider().io(),
            AppDispatcherProvider().ui(),
            Interactors(
                getUserUseCaseImpl()
            )
        )
    }

    private fun getUserUseCaseImpl(): GetUserUseCaseImpl {
        return GetUserUseCaseImpl(
            GetUserRepositoryImpl(
                GetUserDataSource(
                    getDb()
                )
            )
        )
    }
}