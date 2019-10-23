package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.firebase.FirebaseFirestoreUtils
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback
import com.nhaarman.mockitokotlin2.argumentCaptor
import org.junit.Test
import org.mockito.Mockito.*


class GetUserDataSourceTest {

    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val firebaseFirestoreUtils: FirebaseFirestoreUtils = mock(FirebaseFirestoreUtils::class.java)

    @Test
    fun `when getUserDataSource saved method called then dbRoom call`() {
        //When
        `when`(dbRoom.getUserDAO()).thenReturn(userDAO)

        val getUserDataSource = GetUserDataSourceImpl(
            dbRoom, firebaseFirestoreUtils
        )

        getUserDataSource.saveInDB(User())

        //Then
        verify(dbRoom, atLeast(1)).getUserDAO()
        verifyNoMoreInteractions(dbRoom)
    }

    @Test
    fun `when getUserDataSource execute method called then dbRoom call`() {
        //Given
        val callbackFirestore = Callback<User, ErrorType>()
        val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

        //When
        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User?, ErrorType>).onSuccess(User())
        }.`when`(firebaseFirestoreUtils).getUser(
            anyString(),
            anyString(), resultCaptor.capture()
        )

        val getUserDataSource = GetUserDataSourceImpl(
            dbRoom, firebaseFirestoreUtils
        )

        getUserDataSource.execute("", "", callbackFirestore)

        //Then
        verify(firebaseFirestoreUtils, atLeast(1))
            .getUser("", "", callbackFirestore)

        verifyNoMoreInteractions(firebaseFirestoreUtils)
    }
}