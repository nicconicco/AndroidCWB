package carlos.nicolau.galves.core.data

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback

class GetUserRepositoryImpl(private val dataSource: GetUserDataSource) : GetUserRepository {
    override fun execute(username: String, password: String, callback: Callback<User, ErroType>) =
        dataSource.execute(username,password, callback)
}