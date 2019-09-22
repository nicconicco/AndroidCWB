package carlos.nicolau.galves.androidcwb.feature.login

import android.content.Context
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.interators.IGetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

class LoginPresenterImplTest {

    private val getUserUseCase: IGetUserUseCase = mock(IGetUserUseCase::class.java)
    private val userDAO: UserDAO = mock(UserDAO::class.java)
    private val application: AndroidCWBApplication = mock(AndroidCWBApplication::class.java)
    private val context: Context = mock(Context::class.java)
    private val dbRoom: AndroidCWBRoom = AndroidCWBRoom.getDatabase(context)

    val dispatcher = Dispatchers.Unconfined

    private val login =
        LoginViewModelImpl(application, dbRoom, getUserUseCase, dispatcher, dispatcher)

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun whenClickBtnLogin_shouldReturnUserDidLogin_Sucess() = runBlocking {

        val user = User()

        val list: ArrayList<UserEntity> = ArrayList()
        list.add(UserEntity(didLogin = true))

        Mockito.`when`(getUserUseCase.execute("", "")).thenReturn(user)
        Mockito.`when`(dbRoom.getUserDAO()).thenReturn(userDAO)
        Mockito.`when`(dbRoom.getUserDAO().getAllUser()).thenReturn(list)

        login.viewState.observeForever {}
        login.onClickBtnLogin("", "")

        assert(login.viewState.value != null)
        assert(login.viewState.value!!.goToHome)

        Mockito.verify(dbRoom, Mockito.atLeast(1)).getUserDAO()
        Mockito.verifyNoMoreInteractions(dbRoom)
    }
}