package carlos.nicolau.galves.androidcwb.framework.di_native

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

object AndroidCWBMvpFactory : ViewModelProvider.Factory {

    lateinit var application: Application
    lateinit var db: AndroidCWBRoom
    lateinit var dependencies: Interactors
    lateinit var mainDispacher : MainCoroutineDispatcher
    lateinit var ioDispacher : CoroutineDispatcher

    fun inject(
        application: Application,
        db: AndroidCWBRoom,
        dependencies: Interactors,
        mainDispacher : MainCoroutineDispatcher,
        ioDispacher : CoroutineDispatcher

    ) {
        this.application = application
        this.db = db
        this.dependencies = dependencies
        this.mainDispacher = mainDispacher
        this.ioDispacher = ioDispacher
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (AndroidCWBMvvm::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                Application::class.java,
                AndroidCWBRoom::class.java,
                Interactors::class.java,
                MainCoroutineDispatcher::class.java,
                CoroutineDispatcher::class.java
            )
                .newInstance(
                    application,
                    db,
                    dependencies,
                    mainDispacher,
                    ioDispacher
                )
        } else {
            throw IllegalStateException("AndroidCWBMvvm must extend MvvmcViewModel")
        }
    }
}