package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.datasource.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.di_native.AndroidCWBMvpServiceLocator
import carlos.nicolau.galves.androidcwb.framework.provider.AppDispatcherProvider
import carlos.nicolau.galves.androidcwb.framework.provider.Interactors
import carlos.nicolau.galves.androidcwb.framework.repository.IRepository
import carlos.nicolau.galves.androidcwb.framework.repository.RepositoryImpl
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom.Companion.getDatabase
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
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
        AndroidCWBMvpServiceLocator.inject(
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
                    getRepository(
                        getDb()
                    ),
                    getMapper()
                )
            )
        )
    }

    private fun getMapper(): UserEntityMapper {
        return UserEntityMapper()
    }

    private fun getRepository(db: AndroidCWBRoom) : IRepository {
        return RepositoryImpl(db)
    }
}