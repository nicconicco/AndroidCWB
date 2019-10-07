package carlos.nicolau.galves.androidcwb.framework.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtils
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtilsImpl
import carlos.nicolau.galves.core.interators.GetUserUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class AndroidCWBMvvm(
    application: Application,
    db: AndroidCWBRoom,
    val interactors: GetUserUseCase,
    mainDispacher: CoroutineDispatcher,
    ioDispacher: CoroutineDispatcher,
    internetUtils: InternetUtils
) :
    AndroidViewModel(application), CoroutineScope {

    val internetUtils = internetUtils

    val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}