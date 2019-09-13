package carlos.nicolau.galves.utils

import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.SupervisorJob

abstract class BasePresenter<V : Contract.View> : Contract.Presenter<V> {

    val job = SupervisorJob()

    protected var mView: V? = null

    override fun attach(view: V) {
        this.mView = view
        view.getLifecycle()?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun detach() {

        if (job.isActive)
            job.cancel()

        this.mView = null
    }
}