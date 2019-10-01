package carlos.nicolau.galves.androidcwb.framework

import android.app.Application
import carlos.nicolau.galves.androidcwb.framework.di.appModule
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
    }
}