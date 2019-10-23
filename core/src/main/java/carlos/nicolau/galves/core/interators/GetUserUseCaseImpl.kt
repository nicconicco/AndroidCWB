package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

class GetUserUseCaseImpl(private val getUserRepository: GetUserRepositoryImpl) : GetUserUseCase {

    override fun saveInDB(user: User) = getUserRepository.saveInDB(user)

    override fun execute(
        username: String,
        password: String,
        callback: Callback<User, ErrorType>
    ) = getUserRepository.execute(username, password, callback)
}