package carlos.nicolau.galves.core.data

import androidx.lifecycle.LifecycleObserver
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

interface GetUserDataSource : LifecycleObserver {
    val TAG: String
        get() = GetUserDataSource::class.java.simpleName

    fun execute(username: String, password: String, callback: Callback<User, ErrorType>)
    fun saveInDB(user: User)
}