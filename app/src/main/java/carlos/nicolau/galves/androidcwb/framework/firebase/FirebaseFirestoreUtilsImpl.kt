package carlos.nicolau.galves.androidcwb.framework.firebase

import android.util.Log
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class FirebaseFirestoreUtilsImpl(val firebaseFirestore: FirebaseFirestore) : FirebaseFirestoreUtils {
    override fun addUser(userLogged: User, callbackFirestore: Callback<User, ErrorType>) {
        val user2 = hashMapOf(
            "didLogin" to userLogged.didLogin,
            "user" to userLogged.login,
            "password" to userLogged.password
        )

        val users = firebaseFirestore.collection(UserEnum.USERS.value)

        users.add(user2)
            .addOnSuccessListener { userResponse ->
                Log.d(
                    FirebaseFirestore::class.java.simpleName,
                    "DocumentSnapshot successfully written!"
                )
                userLogged.id = userResponse.id

                callbackFirestore.onSuccess(userLogged)
            }
            .addOnFailureListener { e ->
                Log.w(
                    FirebaseFirestore::class.java.simpleName,
                    "Error writing document",
                    e
                )

                callbackFirestore.onError(ErrorType.ERRO_USER_NOT_ADDED_FIRESTORE)
            }
    }

    override fun getUser(
        login: String,
        password: String,
        callbackFirestore: Callback<User, ErrorType>
    ) {
        firebaseFirestore.collection(UserEnum.USERS.value)
            .whereEqualTo(UserEnum.LOGIN.value, login)
            .whereEqualTo(UserEnum.PASSWORD.value, password)
            .get()
            .addOnSuccessListener { documents ->
                if(documents.isEmpty) {
                    Log.d(TAG, ErrorType.ERRO_USER_NOT_FOUND.value)
                    addUser(User(didLogin = true, login = login, password = password), callbackFirestore)
                } else {
                    for (document in documents) {
                        val user: User? = document.toObject(User::class.java)
                        user?.let {
                            callbackFirestore.onSuccess(user)
                        }
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
            }
            .addOnFailureListener { exception ->
                checkStatusResponseError(exception, callbackFirestore)
            }
    }

    private val TAG: String = FirebaseFirestoreUtils::class.java.simpleName

    private fun checkStatusResponseError(
        exception: Exception,
        callback: Callback<User, ErrorType>
    ) {
        Log.w(TAG, "Error getting documents: ", exception)
        callback.onError(ErrorType.ERRO_USER_NOT_ADDED_FIRESTORE)
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