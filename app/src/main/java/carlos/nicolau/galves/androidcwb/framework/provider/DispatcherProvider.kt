package carlos.nicolau.galves.androidcwb.framework.provider

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    fun io(): CoroutineDispatcher
    fun ui(): CoroutineDispatcher
}