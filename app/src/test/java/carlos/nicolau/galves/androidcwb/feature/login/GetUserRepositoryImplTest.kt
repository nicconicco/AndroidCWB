package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.data.GetUserDataSource
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback
import org.junit.Test
import org.mockito.Mockito

class GetUserRepositoryImplTest {

    private val dataSource: GetUserDataSource = Mockito.mock(GetUserDataSource::class.java)

    @Test
    fun whenGetUserRepositoryImplCall_shoulReturnUser() {

        val callback = Callback<User, ErroType>()

        val getUserRepositoryImpl = GetUserRepositoryImpl(dataSource)
        getUserRepositoryImpl.execute("","", callback)

        Mockito.verify(dataSource, Mockito.atLeast(1)).execute("","", callback)
        Mockito.verify(dataSource).execute("","", callback)
        Mockito.verifyNoMoreInteractions(dataSource)
    }
}