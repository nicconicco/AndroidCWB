package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import org.junit.Test
import org.mockito.Mockito

class GetUserUseCaseTest {

    private val getUserRepositoryImpl: GetUserRepositoryImpl = Mockito.mock(GetUserRepositoryImpl::class.java)

    @Test
    fun whenGetUserUseCaseCall_shoulCallRepositoryAndReturnUser() {

        val getUserUseCase = GetUserUseCaseImpl(getUserRepositoryImpl)
        val user = User()

        Mockito.`when`(getUserRepositoryImpl.execute("","")).thenReturn(user)
        getUserUseCase.execute("", "")

        Mockito.verify(getUserRepositoryImpl, Mockito.atLeast(1)).execute("","")
        Mockito.verify(getUserRepositoryImpl).execute("","")
        Mockito.verifyNoMoreInteractions(getUserRepositoryImpl)
    }
}