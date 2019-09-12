package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.data.IGetUserDataSource
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import org.junit.Test
import org.mockito.Mockito

class GetUserRepositoryImplTest {

    private val dataSource: IGetUserDataSource = Mockito.mock(IGetUserDataSource::class.java)

    @Test
    fun whenGetUserRepositoryImplCall_shoulReturnUser() {

        val getUserRepositoryImpl = GetUserRepositoryImpl(dataSource)
        getUserRepositoryImpl.execute("","")

        Mockito.verify(dataSource, Mockito.atLeast(1)).execute("","")
        Mockito.verify(dataSource).execute("","")
        Mockito.verifyNoMoreInteractions(dataSource)
    }
}