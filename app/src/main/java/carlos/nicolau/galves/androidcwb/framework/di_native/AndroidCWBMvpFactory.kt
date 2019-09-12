package carlos.nicolau.galves.androidcwb.framework.di_native

import carlos.nicolau.galves.androidcwb.framework.Interactors
import carlos.nicolau.galves.utils.BasePresenter

object AndroidCWBMvpFactory {

    lateinit var dependencies: Interactors

    fun inject(dependencies: Interactors) {
        this.dependencies = dependencies
    }

    fun <T : BasePresenter<T>?> create(modelClass: Class<T>): T {
        if (AndroidCWBMvp::class.java.isAssignableFrom(modelClass)) {
            return modelClass.getConstructor(
                Interactors::class.java
            )
                .newInstance(
                    dependencies
                )
        } else {
            throw IllegalStateException("ViewModel must extend AndroidCWBMvp")
        }
    }
}