package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import carlos.nicolau.galves.core.utils.Callback
import org.junit.Test
import org.mockito.Mockito

class GetUserRepositoryImplTest {

    private val dataSource: GetUserDataSource = Mockito.mock(GetUserDataSource::class.java)

    @Test
    fun whenGetUserRepositoryImplCall_shoulReturnUser() {

        val callback = Callback<User, ErrorType>()

        val getUserRepositoryImpl = GetUserRepositoryImpl(dataSource)
        getUserRepositoryImpl.execute("","", callback)

        Mockito.verify(dataSource, Mockito.atLeast(1)).execute("","", callback)
        Mockito.verify(dataSource).execute("","", callback)
        Mockito.verifyNoMoreInteractions(dataSource)
    }

    @Test
    fun `when GetUserRepository call saveInDB should call repository and saveUser`() {

        val user = User()

        val getUserRepositoryImpl = GetUserRepositoryImpl(dataSource)
        getUserRepositoryImpl.saveInDB(user)

        Mockito.verify(dataSource, Mockito.atLeast(1)).saveInDB(user)
        Mockito.verify(dataSource).saveInDB(user)
        Mockito.verifyNoMoreInteractions(dataSource)
    }
}