package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback

class GetUserUseCaseImpl(private val getUserRepository: GetUserRepositoryImpl) : GetUserUseCase {
    override fun execute(
        username: String,
        password: String,
        callback: Callback<User, ErroType>
    ) = getUserRepository.execute(username, password, callback)
}