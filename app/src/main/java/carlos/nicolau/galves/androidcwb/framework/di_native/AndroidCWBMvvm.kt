package carlos.nicolau.galves.androidcwb.framework.di_native

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

open class AndroidCWBMvvm(
    application: Application,
    db: AndroidCWBRoom,
    val interactors: IGetUserUseCase,
    mainDispacher : CoroutineDispatcher,
    ioDispacher : CoroutineDispatcher
) :
    AndroidViewModel(application), CoroutineScope {

    protected val application: AndroidCWBApplication = getApplication()
    protected val db: AndroidCWBRoom = AndroidCWBRoom.getDatabase(application)

    val job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = (Dispatchers.Default + job)

    override fun onCleared() {
        job.cancel()
    }
}