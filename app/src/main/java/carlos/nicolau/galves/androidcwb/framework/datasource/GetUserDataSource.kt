package carlos.nicolau.galves.androidcwb.framework.datasource

import carlos.nicolau.galves.androidcwb.framework.repository.IRepository
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.data.IGetUserDataSource
import carlos.nicolau.galves.core.domain.User

class GetUserDataSource(
    private val repository: IRepository,
    private val mapper: UserEntityMapper
) : IGetUserDataSource {
    override fun execute(username: String, password: String): User? {
        return getUserDB()
    }

    override fun getUserDB(): User? {
        val users = repository.getAllUser()
        try {
            if(users.isNotEmpty()) {
                return mapper.transformToUser(users.first())
            }

            return mapper.transformToUser(
                insertUserEntityInDbAndReturnUser()
            )
        } catch (e: Exception) {
            throw Exception("Somenthing WRONG happens! hehe")
        }
    }

    private fun insertUserEntityInDbAndReturnUser(): UserEntity? {
        repository.insert()
        return repository.first()
    }
}