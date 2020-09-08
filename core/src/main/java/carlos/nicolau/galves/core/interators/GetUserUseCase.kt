package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.domain.User

interface GetUserUseCase {
    fun execute(username: String, password: String): User
}