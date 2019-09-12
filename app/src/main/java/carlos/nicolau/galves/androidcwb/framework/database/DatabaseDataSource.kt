package carlos.nicolau.galves.androidcwb.framework.database

import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User

class DatabaseDataSource : GetUserDataSource {
    override fun execute(username: String, password: String): User {
        return User(true)
    }
}