package carlos.nicolau.galves.androidcwb.framework.firebase

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import carlos.nicolau.galves.core.domain.User
import com.google.firebase.firestore.FirebaseFirestore

abstract class FirebaseFirestoreUtils {
    companion object {

        enum class UserEnum(val value: String) {
            ADMIN("ADMIN"),
            USERS("users")
        }

        @SuppressLint("StaticFieldLeak")
        @Volatile
        private var INSTANCE: FirebaseFirestore? = null

        internal fun getInstance(): FirebaseFirestore {
            if (INSTANCE == null) {
                INSTANCE = FirebaseFirestore.getInstance()
            }
            return INSTANCE!!
        }

        internal fun getUser(db: FirebaseFirestore) {

            val docRef =
                db
                    .collection(UserEnum.USERS.value)
                    .document(UserEnum.ADMIN.value)

            docRef.get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        Log.d(ContentValues.TAG, "DocumentSnapshot data: ${document.data}")
                    } else {
                        Log.d(ContentValues.TAG, "No such document")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.d(ContentValues.TAG, "get failed with ", exception)
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