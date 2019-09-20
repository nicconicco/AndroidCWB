package carlos.nicolau.galves.androidcwb.framework.data_source

import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.data.IGetUserDataSource
import carlos.nicolau.galves.core.domain.User

class GetUserDataSource(
    private val db: AndroidCWBRoom
) : IGetUserDataSource {

    override fun execute(username: String, password: String): User? {
        return getUserDB()
    }

    override fun getUserDB(): User? {
        val users = db.getUserDAO().getAllUser()
        try {
            if(users.isNotEmpty()) {
                return UserEntityMapper.transformToUser(users.first())
            }

            return UserEntityMapper.transformToUser(
                insertUserEntityInDbAndReturnUser()
            )
        } catch (e: Exception) {
            throw Exception("Somenthing WRONG happens! hehe")
        }
    }

    private fun insertUserEntityInDbAndReturnUser(): UserEntity {

        db.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", token = "meutokenfalso")
        )

        return db.getUserDAO().getAllUser().first()
    }
}