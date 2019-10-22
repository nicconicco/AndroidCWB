package carlos.nicolau.galves.androidcwb.framework.firebase

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

interface FirebaseFirestoreUtils {
    fun getUser(
        login: String,
        password: String,
        callbackFirestore: Callback<User, ErrorType>
    )

    fun addUser(
        userLogged: User,
        callbackFirestore: Callback<User, ErrorType>
    )
}