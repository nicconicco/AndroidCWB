package carlos.nicolau.galves.core.data

import androidx.lifecycle.LifecycleObserver
import carlos.nicolau.galves.core.domain.User

interface GetUserDataSource : LifecycleObserver {
    fun execute(username: String, password: String): User?
    fun getUserDB(): User?
}