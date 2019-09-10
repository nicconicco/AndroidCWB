package carlos.nicolau.galves.androidcwb.feature

import carlos.nicolau.galves.androidcwb.presentation.login.LoginPresenter
import carlos.nicolau.galves.androidcwb.presentation.login.LoginPresenterImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class LoginPresenterImplTest {

    private val mView = Mockito.mock(LoginPresenter.View::class.java)
    private val getUserUseCase: IGetUserUseCase = Mockito.mock(IGetUserUseCase::class.java)

    private val presenter =
        LoginPresenterImpl(getUserUseCase)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter.attach(mView)
    }

    @Test
    fun whenClickBtnLogin_shouldReturnUserDidLogin_Sucess() {
        val user = User()
        Mockito.`when`(getUserUseCase.execute("","")).thenReturn(user)
        presenter.onClickBtnLogin("","")

        Mockito.verify(mView).showLoading()
        Mockito.verify(getUserUseCase).execute("","")
        Mockito.verify(mView).hideLoading()
    }
}