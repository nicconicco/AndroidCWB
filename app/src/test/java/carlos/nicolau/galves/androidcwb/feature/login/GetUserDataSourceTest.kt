package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.data_source.GetUserDataSourceImpl
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import org.junit.Test
import org.mockito.Mockito

class GetUserDataSourceTest {

    private val dbRoom: AndroidCWBRoom = Mockito.mock(AndroidCWBRoom::class.java)
    private val userDAO: UserDAO = Mockito.mock(UserDAO::class.java)

    @Test
    fun whenGetUserDataSourceCall_shoulCallDbRoom() {

        val list: ArrayList<UserEntity> = ArrayList()
        list.add(UserEntity(didLogin = true))

        Mockito.`when`(dbRoom.getUserDAO()).thenReturn(userDAO)
        Mockito.`when`(dbRoom.getUserDAO().getAllUser()).thenReturn(list)

        val getUserDataSource = GetUserDataSourceImpl(
            dbRoom
        )

        getUserDataSource.execute("", "")
        Mockito.verify(dbRoom, Mockito.atLeast(1)).getUserDAO()
        Mockito.verifyNoMoreInteractions(dbRoom)
    }
}