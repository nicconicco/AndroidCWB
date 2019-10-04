package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.interators.GetUserUseCaseImpl
import carlos.nicolau.galves.core.utils.Callback
import org.junit.Test
import org.mockito.Mockito

class GetUserUseCaseTest {

    private val getUserRepositoryImpl: GetUserRepositoryImpl = Mockito.mock(GetUserRepositoryImpl::class.java)

    @Test
    fun whenGetUserUseCaseCall_shoulCallRepositoryAndReturnUser() {
        val callback = Callback<User, ErroType>()

        val getUserUseCase = GetUserUseCaseImpl(getUserRepositoryImpl)

        getUserUseCase.execute("", "", callback)

        Mockito.verify(getUserRepositoryImpl, Mockito.atLeast(1)).execute("","", callback)
        Mockito.verify(getUserRepositoryImpl).execute("","", callback)
        Mockito.verifyNoMoreInteractions(getUserRepositoryImpl)
    }
}