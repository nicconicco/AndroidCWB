package carlos.nicolau.galves.androidcwb.framework.di_native

import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.utils.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher

object AndroidCWBMvpFactory {

    lateinit var dependencies: Interactors
    lateinit var io: CoroutineDispatcher
    lateinit var ui: CoroutineDispatcher

    fun inject(dependencies: Interactors, io: CoroutineDispatcher, ui: CoroutineDispatcher) {
        this.dependencies = dependencies
        this.io = io
        this.ui = ui
    }

    fun <T : BasePresenter<T>?> create(modelClass: Class<T>): T {
        if (AndroidCWBMvp::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                Interactors::class.java
            )
                .newInstance(
                    dependencies,
                    io,
                    ui
                )
        } else {
            throw IllegalStateException("MVP must extend AndroidCWBMvp")
        }
    }
}