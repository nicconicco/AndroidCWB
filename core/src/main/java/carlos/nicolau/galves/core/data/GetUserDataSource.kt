package carlos.nicolau.galves.core.data

import carlos.nicolau.galves.core.domain.User

interface GetUserDataSource {
    fun execute(username: String, password: String): User
}