package carlos.nicolau.galves.utils

interface onResult<T, F, R> {
    fun onSuccess(result: T) : R
    fun onError(error: F) : F
}