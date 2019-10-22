package carlos.nicolau.galves.androidcwb.framework.data_source

import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.utils.Callback
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import java.lang.Exception

class GetUserDataSourceImpl(
    private val db: AndroidCWBRoom,
    private val firebaseFirestoreUtils: FirebaseFirestoreUtils
) : GetUserDataSource {
    override fun execute(
        username: String,
        password: String,
        callback: Callback<User, ErrorType>
    ) {
        firebaseFirestoreUtils.getUser(username, password, object : Callback<User, ErrorType>() {
            override fun onSuccess(result: User) {
                result.id.apply {
                    saveUser(result, callback)
                }
            }

            override fun onError(error: ErrorType) {
                super.onError(error)
                callback.onError(error)
            }
        })
    }


    override fun saveUser(user: User, callback: Callback<User, ErrorType>) {
        try {
            db.getUserDAO().insert(
                UserEntityMapper().reverseFrom(user)
            )

            callback.onSuccess(user)
        } catch (e: Exception) {
            callback.onError(ErrorType.ERRO_USER_NOT_ADDED_ROOM)
        }
    }
}
