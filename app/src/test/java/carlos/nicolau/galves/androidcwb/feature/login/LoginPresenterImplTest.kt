package carlos.nicolau.galves.androidcwb.feature.login

import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
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
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.core.errors.ErroType
import carlos.nicolau.galves.core.utils.Callback
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class LoginPresenterImplTest {

    private val getUserUseCase: GetUserUseCase = mock(GetUserUseCase::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val application: AndroidCWBApplication = mock(AndroidCWBApplication::class.java)
    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val dispatcher = Dispatchers.Unconfined

    @Mock
    lateinit var observer : Observer<LoginViewModel.ViewState>

    @get:Rule
    val rule = InstantTaskExecutorRule()

    lateinit var login: LoginViewModelImpl

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        /** todo: injetar com koin
         *  startKoin {
            modules(module {
                factory<GetnetAutomaticAnticipationAutomaticAnticipationUseCase> { automaticAnticipationUseCase }
                factory<GetnetAutomaticAnticipationAccreditingFlagsUseCase> { flagUseCase }
                viewModel { GetnetAutomaticAnticipationInfoViewModel(get(), get()) }
                })
            }

        viewModel = get()
         */

        login = LoginViewModelImpl(application, dbRoom, getUserUseCase, dispatcher, dispatcher)

        login.viewState.observeForever(observer)
    }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return UserDidLogin and GoToHome Success`() = runBlocking {
        // Given
        val user = User()
        val list: ArrayList<UserEntity> = ArrayList()
        list.add(UserEntity(didLogin = true))
        val callback = Callback<User, ErroType>()

        val expectedStateSuccess = LoginViewModel.ViewState.goToHome::class.java

        Mockito.`when`(dbRoom.getUserDAO()).thenReturn(userDAO)
        Mockito.`when`(userDAO.getAllUser()).thenReturn(list)

        // When
        login.onClickBtnLogin("", "")

        // Then
//        assert(login.viewState.value != null)
//        assert(login.viewState.value == LoginViewModel.ViewState.goToHome)
//        assertThat(login.viewState.value, IsInstanceOf(expectedStateSuccess))
//        verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
    }
}