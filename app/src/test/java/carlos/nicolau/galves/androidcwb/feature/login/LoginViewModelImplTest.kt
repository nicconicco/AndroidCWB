package carlos.nicolau.galves.androidcwb.feature.login

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtils
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtilsImpl
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModel
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.interators.GetUserUseCase
import carlos.nicolau.galves.core.utils.Callback
import com.nhaarman.mockitokotlin2.argumentCaptor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations


class LoginViewModelImplTest {

    private val getUserUseCase: GetUserUseCase = mock(GetUserUseCase::class.java)
    private val context: Context = mock(Context::class.java)
    private val internetUtils: InternetUtils = mock(InternetUtils::class.java)
    private val application: AndroidCWBApplication = mock(AndroidCWBApplication::class.java)
    private val dbRoom: AndroidCWBRoom = mock(AndroidCWBRoom::class.java)
    private val dispatcher = Dispatchers.Unconfined

    @Mock
    lateinit var observer: Observer<LoginViewModel.ViewState>

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


        login = LoginViewModelImpl(
            application,
            dbRoom,
            getUserUseCase,
            dispatcher,
            dispatcher,
            internetUtils
        )

        login.viewState.observeForever(observer)
    }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return UserDidLogin and GoToHome Success`() =
        runBlocking {
            // Given
            val expectedStateSuccess = LoginViewModel.ViewState.goToHome::class.java
            val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

            doAnswer {
                @Suppress("UNCHECKED_CAST")
                (it.arguments[2] as Callback<User, ErrorType>).onSuccess(User())
            }.`when`(getUserUseCase).execute(anyString(), anyString(), resultCaptor.capture())

            `when`(internetUtils.isNetworkAvailable()).thenReturn(true)

            // When
            login.onClickBtnLogin("", "")

            // Then
            assert(login.viewState.value != null)
            assert(login.viewState.value == LoginViewModel.ViewState.goToHome)
            assertThat(login.viewState.value, IsInstanceOf(expectedStateSuccess))
            verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
            verify(observer).onChanged(LoginViewModel.ViewState.goToHome)
        }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return msg ERRO_INTERNET`() = runBlocking {
        // Given
        val expectedState = LoginViewModel.ViewState.errorLogin::class.java
        val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User, ErrorType>).onError(ErrorType.ERRO_INTERNET)
        }.`when`(getUserUseCase).execute(anyString(), anyString(), resultCaptor.capture())

        `when`(internetUtils.isNetworkAvailable()).thenReturn(false)

        // When
        login.onClickBtnLogin("", "")

        // Then
        assert(login.viewState.value != null)
        assert(login.viewState.value == LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_INTERNET))
        assertThat(login.viewState.value, IsInstanceOf(expectedState))
        verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
        verify(observer).onChanged(LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_INTERNET))
    }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return msg ERRO_USER_NOT_FOUND`() = runBlocking {
        // Given
        val expectedState = LoginViewModel.ViewState.errorLogin::class.java
        val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User, ErrorType>).onError(ErrorType.ERRO_USER_NOT_FOUND)
        }.`when`(getUserUseCase).execute(anyString(), anyString(), resultCaptor.capture())

        `when`(internetUtils.isNetworkAvailable()).thenReturn(true)

        // When
        login.onClickBtnLogin("", "")

        // Then
        assert(login.viewState.value != null)
        assert(login.viewState.value == LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_USER_NOT_FOUND))
        assertThat(login.viewState.value, IsInstanceOf(expectedState))
        verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
        verify(observer).onChanged(LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_USER_NOT_FOUND))
    }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return msg ERRO_404`() = runBlocking {
        // Given
        val expectedState = LoginViewModel.ViewState.errorLogin::class.java
        val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User, ErrorType>).onError(ErrorType.ERRO_404)
        }.`when`(getUserUseCase).execute(anyString(), anyString(), resultCaptor.capture())

        `when`(internetUtils.isNetworkAvailable()).thenReturn(true)

        // When
        login.onClickBtnLogin("", "")

        // Then
        assert(login.viewState.value != null)
        assert(login.viewState.value == LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_404))
        assertThat(login.viewState.value, IsInstanceOf(expectedState))
        verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
        verify(observer).onChanged(LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_404))
    }

    @Test
    fun `Given LoginViewModel when ClickBtnLogin should Return msg ERRO_265`() = runBlocking {
        // Given
        val expectedState = LoginViewModel.ViewState.errorLogin::class.java
        val resultCaptor = argumentCaptor<Callback<User, ErrorType>>()

        doAnswer {
            @Suppress("UNCHECKED_CAST")
            (it.arguments[2] as Callback<User, ErrorType>).onError(ErrorType.ERRO_265)
        }.`when`(getUserUseCase).execute(anyString(), anyString(), resultCaptor.capture())

        `when`(internetUtils.isNetworkAvailable()).thenReturn(true)

        // When
        login.onClickBtnLogin("", "")

        // Then
        assert(login.viewState.value != null)
        assert(login.viewState.value == LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_265))
        assertThat(login.viewState.value, IsInstanceOf(expectedState))
        verify(observer).onChanged(LoginViewModel.ViewState.isLoading(true))
        verify(observer).onChanged(LoginViewModel.ViewState.errorLogin(ErrorType.ERRO_265))
    }
}