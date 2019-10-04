package carlos.nicolau.galves.androidcwb.framework.data_source

import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.utils.Callback
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType

class GetUserDataSourceImpl(
    private val db: AndroidCWBRoom
) : GetUserDataSource {

    override fun execute(username: String, password: String, callback: Callback<User, ErroType>) {
        FirebaseFirestoreUtils.getUser(username, password, callback)
//        return getUserDB()
    }

    override fun getUserDB(): User? {

        FirebaseFirestoreUtils.addUser(
            FirebaseFirestoreUtils.getInstance(),
            User()
        )

        val users = db.getUserDAO().getAllUser()

        if (users.isNotEmpty()) {
            return UserEntityMapper.transformToUser(users.first())
        }

        return UserEntityMapper.transformToUser(
            insertUserEntityInDbAndReturnUser()
        )
    }

    private fun insertUserEntityInDbAndReturnUser(): UserEntity {
        FirebaseFirestoreUtils.addUser(
            FirebaseFirestoreUtils.getInstance(),
            User()
        )

        db.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", token = "meutokenfalso")
        )

        return db.getUserDAO().getAllUser().first()
    }
}