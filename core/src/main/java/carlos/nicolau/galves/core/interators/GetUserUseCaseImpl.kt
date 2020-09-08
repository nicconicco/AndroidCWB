package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.domain.User

class GetUserUseCaseImpl : GetUserUseCase {
    override fun execute(username: String, password: String) = User(true)
}