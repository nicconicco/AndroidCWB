package carlos.nicolau.galves.androidcwb.framework.database

import carlos.nicolau.galves.core.data.IGetUserDataSource
import carlos.nicolau.galves.core.domain.User

class GetUserDataSource : IGetUserDataSource {

    override fun execute(username: String, password: String): User {
        return getUserDB()
    }

    private fun getUserDB(): User {
        return User(true)
    }
}