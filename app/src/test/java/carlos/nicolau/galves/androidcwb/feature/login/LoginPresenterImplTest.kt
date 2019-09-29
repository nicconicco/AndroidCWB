package carlos.nicolau.galves.androidcwb.feature.login

import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModel
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class LoginPresenterImplTest {

    private val getUserUseCase: GetUserUseCase = mock(GetUserUseCase::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val application: AndroidCWBApplication = mock(AndroidCWBApplication::class.java)
    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val dispatcher = Dispatchers.Unconfined

    @Mock
    lateinit var viewState : Observer<LoginViewModel.ViewState>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var login: LoginViewModelImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        login = LoginViewModelImpl(application, dbRoom, getUserUseCase, dispatcher, dispatcher)

        login.viewState.observeForever(viewState)
    }

    @Test
    fun whenClickBtnLogin_shouldReturnUserDidLogin_Sucess() = runBlocking {

        val user = User()

        val list: ArrayList<UserEntity> = ArrayList()
        list.add(UserEntity(didLogin = true))

        Mockito.`when`(getUserUseCase.execute("", "")).thenReturn(user)
        Mockito.`when`(dbRoom.getUserDAO()).thenReturn(userDAO)
        Mockito.`when`(userDAO.getAllUser()).thenReturn(list)

        login.onClickBtnLogin("", "")

        assert(login.viewState.value != null)
        assert(login.viewState.value == LoginViewModel.ViewState.goToHome)
    }
}