package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when`


class GetUserDataSourceTest {

    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val firebaseFirestore: FirebaseFirestore = mock(FirebaseFirestore::class.java)
    private val firebaseApp = mock(FirebaseApp::class.java)

    @Test
    fun whenGetUserDataSourceCall_shoulCallDbRoom() {
//        //Given
//
//        val list: ArrayList<UserEntity> = ArrayList()
//        list.add(UserEntity(didLogin = true))
//        val callback = Callback<User, ErroType>()
//
//        //When
//        `when`(dbRoom.getUserDAO()).thenReturn(userDAO)
//        `when`(dbRoom.getUserDAO().getAllUser()).thenReturn(list)
//        `when`(FirebaseApp.getInstance()).thenReturn(firebaseApp)
//        `when`(FirebaseFirestore.getInstance()).thenReturn(firebaseFirestore)
//
////        `when`(FirebaseFirestoreUtils.getUser("", "", callback)).thenCallRealMethod()
//
//        val getUserDataSource = GetUserDataSourceImpl(
//            dbRoom
//        )
//
//        getUserDataSource.execute("", "", callback)
//
//        //Then
//        verify(dbRoom, atLeast(1)).getUserDAO()
//        verifyNoMoreInteractions(dbRoom)
    }
}