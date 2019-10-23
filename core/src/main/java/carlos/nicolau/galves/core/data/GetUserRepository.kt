package carlos.nicolau.galves.core.data

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

interface GetUserRepository {
    fun execute(username: String, password: String, callback: Callback<User, ErrorType>)
    fun saveInDB(user: User)
}