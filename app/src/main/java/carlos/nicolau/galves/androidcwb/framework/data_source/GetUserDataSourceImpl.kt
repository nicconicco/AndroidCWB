package carlos.nicolau.galves.androidcwb.framework.data_source

import android.content.ContentValues.TAG
import android.util.Log
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.domain.User
import com.google.firebase.firestore.FirebaseFirestore

class GetUserDataSourceImpl(
    private val db: AndroidCWBRoom
) : GetUserDataSource {

    override fun execute(username: String, password: String): User? {
        return getUserDB()
    }

    override fun getUserDB(): User? {
        FirebaseFirestoreUtils.addUser(
            FirebaseFirestoreUtils.getInstance(),
            User()
        )

//        val db2 = FirebaseFirestore.getInstance()
//        val docRef = db2.collection("users").document("SF")
//        docRef.get()
//            .addOnSuccessListener { document ->
//                if (document != null) {
//                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
//                } else {
//                    Log.d(TAG, "No such document")
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(TAG, "get failed with ", exception)
//            }

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

//        val db2 = FirebaseFirestoreUtils.getInstance()
//        // Create a new user with a first and last name
//        val user = hashMapOf(
//            "first" to "Ada",
//            "last" to "Lovelace",
//            "born" to 1815
//        )
//
//        db2.collection("users")
//            .add(user)
//            .addOnSuccessListener { documentReference ->
//                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w(TAG, "Error adding document", e)
//            }

        db.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", token = "meutokenfalso")
        )

        return db.getUserDAO().getAllUser().first()
    }
}