package carlos.nicolau.galves.androidcwb.framework.di_native

import carlos.nicolau.galves.androidcwb.framework.provider.Interactors
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.utils.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher

object AndroidCWBMvpFactory {

    lateinit var dependencies: Interactors
    lateinit var io: CoroutineDispatcher
    lateinit var ui: CoroutineDispatcher
    lateinit var db: AndroidCWBRoom

    fun inject(db: AndroidCWBRoom, io: CoroutineDispatcher, ui: CoroutineDispatcher, dependencies: Interactors) {
        this.dependencies = dependencies
        this.io = io
        this.ui = ui
        this.db = db
    }

    fun provideAndroidCWBRoom() : AndroidCWBRoom {
        return db
    }

    fun provideIO() : CoroutineDispatcher {
        return io
    }

    fun provideUI() : CoroutineDispatcher {
        return ui
    }

//    fun <T : BasePresenter<T>?> create(modelClass: Class<T>): T {
//        if (AndroidCWBMvp::class.java.isAssignableFrom(modelClass)) {
//            return modelClass.getConstructor(
//                Interactors::class.java
//            )
//                .newInstance(
//                    dependencies,
//                    io,
//                    ui
//                )
//        } else {
//            throw IllegalStateException("MVP must extend AndroidCWBMvp")
//        }
//    }
}