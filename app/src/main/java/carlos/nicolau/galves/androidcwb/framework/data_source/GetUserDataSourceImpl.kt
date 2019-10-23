package carlos.nicolau.galves.androidcwb.framework.data_source

import android.util.Log
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.utils.Callback
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType

class GetUserDataSourceImpl(
    private val db: AndroidCWBRoom,
    private val firebaseFirestoreUtils: FirebaseFirestoreUtils
) : GetUserDataSource {
    override fun saveInDB(user: User) {
        val userEntity = UserEntityMapper().reverseFrom(user)

        val id = db.getUserDAO().insert(
            userEntity
        )

        if (id > 0) {
            Log.d(TAG, "user with id = $id was saved succeful")
        } else {
            Log.d(TAG, "user with id = $id was not saved")
        }
    }

    override fun execute(
        username: String,
        password: String,
        callback: Callback<User, ErrorType>
    ) {

        firebaseFirestoreUtils.getUser(username, password, object : Callback<User, ErrorType>() {
            override fun onSuccess(result: User) {
                callback.onSuccess(result)
//                result.id.apply {
//                    saveUser(result, callback)
//                }
            }

            override fun onError(error: ErrorType) {
                super.onError(error)
                callback.onError(error)
            }
        })
    }


    override fun saveUser(user: User, callback: Callback<User, ErrorType>) {

        val userEntity = UserEntityMapper().reverseFrom(user)

        val id = db.getUserDAO().insert(
            userEntity
        )

        if (id > 0) {
            callback.onSuccess(user)
        } else {
            callback.onError(ErrorType.ERRO_USER_NOT_ADDED_ROOM)
        }
    }
}
