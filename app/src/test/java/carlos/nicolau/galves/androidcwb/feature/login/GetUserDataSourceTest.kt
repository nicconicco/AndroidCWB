package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModel
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback
import com.google.firebase.FirebaseApp
import com.nhaarman.mockitokotlin2.argumentCaptor
import org.junit.Test
import org.mockito.Mockito.*


class GetUserDataSourceTest {

    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val firebaseFirestore: FirebaseFirestoreUtils = mock(FirebaseFirestoreUtils::class.java)
    private val firebaseApp = mock(FirebaseApp::class.java)

    @Test
    fun whenGetUserDataSourceCall_shoulCallDbRoom() {
        //Given
        val expectedStateSuccess = LoginViewModel.ViewState.goToHome::class.java
        val resultCaptor = argumentCaptor<Callback<User, ErroType>>()

        val list: ArrayList<UserEntity> = ArrayList()
        list.add(UserEntity(didLogin = true))
        val callback = Callback<User, ErroType>()

        //When
//        `when`(dbRoom.getUserDAO()).thenReturn(userDAO)
//        `when`(dbRoom.getUserDAO().getAllUser()).thenReturn(list)

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User, ErroType>).onSuccess(User())
        }.`when`(firebaseFirestore).getUser(
            anyString(),
            anyString(), resultCaptor.capture())

        val getUserDataSource = GetUserDataSourceImpl(
            dbRoom, firebaseFirestore
        )

        getUserDataSource.execute("", "", callback)

        //Then
        verify(firebaseFirestore, atLeast(1)).getUser(
            anyString(),
            anyString(), resultCaptor.capture())
        verifyNoMoreInteractions(firebaseFirestore)
    }
}