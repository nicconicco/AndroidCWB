package carlos.nicolau.galves.androidcwb.framework.data_source

import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.utils.Callback
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType

class GetUserDataSourceImpl(
    private val db: AndroidCWBRoom,
    private val firebaseFirestoreUtils: FirebaseFirestoreUtils
) : GetUserDataSource {

    override fun execute(username: String, password: String, callback: Callback<User, ErrorType>) {
        firebaseFirestoreUtils.getUser(username, password, callback)
    }

    override fun getUserDB(): User? {

        firebaseFirestoreUtils.addUser(
            User()
        )

        val users = db.getUserDAO().getAllUser()

        if (users.isNotEmpty()) {
            return UserEntityMapper().mapFrom(users.first())
        }

        return UserEntityMapper().mapFrom(
            insertUserEntityInDbAndReturnUser()
        )
    }

    private fun insertUserEntityInDbAndReturnUser(): UserEntity {
        firebaseFirestoreUtils.addUser(
            User()
        )

        db.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", token = "meutokenfalso")
        )

        return db.getUserDAO().getAllUser().first()
    }
}