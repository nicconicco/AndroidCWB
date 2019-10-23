package carlos.nicolau.galves.core.data

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

class GetUserRepositoryImpl(private val dataSource: GetUserDataSource) : GetUserRepository {
    override fun saveInDB(user: User)  =
        dataSource.saveInDB(user)

    override fun execute(username: String, password: String, callback: Callback<User, ErrorType>) =
        dataSource.execute(username,password, callback)
}