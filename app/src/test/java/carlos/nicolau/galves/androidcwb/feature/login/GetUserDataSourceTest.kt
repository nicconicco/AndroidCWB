package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import kotlinx.coroutines.Dispatchers
import org.junit.Test
import org.mockito.Mockito

class GetUserDataSourceTest {

    private val dbRoom: AndroidCWBRoom = Mockito.mock(AndroidCWBRoom::class.java)
    private val userDAO: UserDAO = Mockito.mock(UserDAO::class.java)

    @Test
    fun whenGetUserDataSourceCall_shoulCallDbRoom() {

        Mockito.`when`(dbRoom.getUserDAO()).thenReturn(userDAO)

        val getUserDataSource = GetUserDataSource(
            dbRoom
        )

        getUserDataSource.execute("", "")
        Mockito.verify(dbRoom, Mockito.atLeast(1)).getUserDAO()
        Mockito.verifyNoMoreInteractions(dbRoom)
    }
}