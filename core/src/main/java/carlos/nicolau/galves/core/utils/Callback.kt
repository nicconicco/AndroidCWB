package carlos.nicolau.galves.core.utils


open class Callback<T,  E> : OnResult<T, E>{

    private var data: T? = null
    private var error: E? = null

    override fun onSuccess(result: T) {
        this.data = result
    }

    override fun onError(error: E) {
        this.error = error
    }
}