package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl

class GetUserUseCase(private val getUserRepository: GetUserRepositoryImpl) : IGetUserUseCase {
    override fun execute(username: String, password: String) = getUserRepository.execute(username, password)
}