package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.datasource.GetUserDataSource
import carlos.nicolau.galves.androidcwb.framework.repository.IRepository
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.framework.room.UserEntityMapper
import carlos.nicolau.galves.core.domain.User
import com.nhaarman.mockitokotlin2.mock
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class GetUserDataSourceTest {

    private val user: List<UserEntity> = mock()
    private val repository: IRepository = mock()
    private val mapper: UserEntityMapper = mock()
    private val userResult: User = mock()
    private val entity: UserEntity = mock()
    private val dbRoom: AndroidCWBRoom = Mockito.mock(AndroidCWBRoom::class.java)
    private val userEntityMapper = Mockito.mock(UserEntityMapper::class.java)

    @Test
    fun whenGetUserDataSourceCall_shoulCallDbRoom() {
        MockitoAnnotations.initMocks(this)

        val list = mutableListOf<UserEntity>()
        list.add(UserEntity(1, true, "", ""))
        Mockito.`when`(repository.getAllUser()).thenReturn(list)
        Mockito.`when`(userEntityMapper.transformToUser(entity)).thenReturn(userResult)
        Mockito.`when`(user.isEmpty()).thenReturn(false)

        val getUserDataSource = GetUserDataSource(
            repository,
            mapper
        )

        getUserDataSource.execute("", "")
        Mockito.verify(repository, Mockito.atLeast(1)).getAllUser()
        Mockito.verifyNoMoreInteractions(repository)
    }
}