package carlos.nicolau.galves.androidcwb.framework.di_native

import carlos.nicolau.galves.androidcwb.framework.provider.Interactors
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.utils.BasePresenter
import kotlinx.coroutines.CoroutineDispatcher

object AndroidCWBMvpServiceLocator {
    lateinit var dependencies: Interactors
    lateinit var io: CoroutineDispatcher
    lateinit var ui: CoroutineDispatcher

    fun inject(io: CoroutineDispatcher, ui: CoroutineDispatcher, dependencies: Interactors) {
        this.dependencies = dependencies
        this.io = io
        this.ui = ui
    }
}