package carlos.nicolau.galves.androidcwb.framework.firebase

import android.annotation.SuppressLint
import android.util.Log
import carlos.nicolau.galves.core.utils.Callback
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import com.google.firebase.firestore.FirebaseFirestore

abstract class FirebaseFirestoreUtils {

    companion object {
        enum class UserEnum(val value: String) {
            ADMIN("ADMIN"),
            USERS("users"),
            LOGIN("login"),
            PASSWORD("password"),
        }

        private val TAG: String = FirebaseFirestoreUtils::class.java.simpleName
        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: FirebaseFirestore? = null

        fun getInstance(): FirebaseFirestore {
            if (INSTANCE == null) {
                INSTANCE = FirebaseFirestore.getInstance()
            }
            return INSTANCE!!
        }

        internal fun getUser(
            login: String,
            password: String,
            callback: Callback<User, ErroType>,
            db: FirebaseFirestore = getInstance()) {

            db.collection(UserEnum.USERS.value)
                .whereEqualTo(UserEnum.LOGIN.value, login)
                .whereEqualTo(UserEnum.PASSWORD.value, password)
                .get()
                .addOnSuccessListener { documents ->
                    if(documents.isEmpty) {
                        Log.d(TAG, ErroType.ERRO_USER_NOT_FOUND.value)
                        callback.onError(ErroType.ERRO_USER_NOT_FOUND)
                    } else {
                        for (document in documents) {
                            val user: User? = document.toObject(User::class.java)
                            user?.let {
                                callback.onSuccess(user)
                            }
                            Log.d(TAG, "${document.id} => ${document.data}")
                        }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                    callback.onError(ErroType.ERRO_404)
                }
        }

        internal fun addUser(db: FirebaseFirestore, userLogged: User) {
            // Create a new user with a first and last name
            val user2 = hashMapOf(
                "didLogin" to userLogged.didLogin,
                "OSOSOS" to ""
            )

            val users = db.collection(UserEnum.USERS.value)

            users.document(UserEnum.ADMIN.value).set(user2)
                .addOnSuccessListener {
                    Log.d(
                        FirebaseFirestore::class.java.simpleName,
                        "DocumentSnapshot successfully written!"
                    )
                }
                .addOnFailureListener { e ->
                    Log.w(
                        FirebaseFirestore::class.java.simpleName,
                        "Error writing document",
                        e
                    )
                }
        }
    }
}