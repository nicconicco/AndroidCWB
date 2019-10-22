package carlos.nicolau.galves.androidcwb.framework.firebase

import android.util.Log
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseFirestoreUtilsImpl(val firebaseFirestore: FirebaseFirestore) : FirebaseFirestoreUtils {

    private val TAG: String = FirebaseFirestoreUtils::class.java.simpleName

    override fun getUser(
        login: String,
        password: String,
        callback: Callback<User, ErrorType>
    ) {
        firebaseFirestore.collection(UserEnum.USERS.value)
            .whereEqualTo(UserEnum.LOGIN.value, login)
            .whereEqualTo(UserEnum.PASSWORD.value, password)
            .get()
            .addOnSuccessListener { documents ->
                if(documents.isEmpty) {
                    Log.d(TAG, ErrorType.ERRO_USER_NOT_FOUND.value)
                    callback.onError(ErrorType.ERRO_USER_NOT_FOUND)
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
                callback.onError(ErrorType.ERRO_404)
            }
    }

    override fun addUser(userLogged: User) {
        // Create a new user with a first and last name
        val user2 = hashMapOf(
            "didLogin" to userLogged.didLogin,
            "user" to userLogged.login,
            "password" to userLogged.password
        )

        val users = firebaseFirestore.collection(UserEnum.USERS.value)

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

    companion object {
        enum class UserEnum(val value: String) {
            ADMIN("ADMIN"),
            USERS("users"),
            LOGIN("login"),
            PASSWORD("password"),
        }
    }
}