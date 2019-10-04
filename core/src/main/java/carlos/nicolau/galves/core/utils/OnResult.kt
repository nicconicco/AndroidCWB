package carlos.nicolau.galves.core.utils

interface OnResult<T, E> {
    fun onSuccess(result: T)
    fun onError(error: E)
}