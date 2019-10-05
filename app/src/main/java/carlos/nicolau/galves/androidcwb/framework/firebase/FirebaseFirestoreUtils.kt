package carlos.nicolau.galves.androidcwb.framework.firebase

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback

interface FirebaseFirestoreUtils {
    fun getUser(
        login: String,
        password: String,
        callback: Callback<User, ErroType>)

    fun addUser(userLogged: User)
}