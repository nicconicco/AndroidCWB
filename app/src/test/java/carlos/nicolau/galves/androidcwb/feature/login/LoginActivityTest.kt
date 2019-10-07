package carlos.nicolau.galves.androidcwb.feature.login

import android.os.Build
import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.di.appModule
import carlos.nicolau.galves.androidcwb.presentation.login.LoginActivity
import carlos.nicolau.galves.androidcwb.presentation.login.LoginViewModelImpl
import junit.framework.Assert.assertTrue
import kotlinx.android.synthetic.main.activity_login.*
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class LoginActivityTest : KoinTest {

    val viewModelImpl by inject<LoginViewModelImpl>()

    @Before
    fun before(){

        val app = RuntimeEnvironment.application as AndroidCWBApplication

//        startKoin {  androidLogger(Level.DEBUG)
//            androidContext(app)
//            modules(appModule)
//        }

//        loadKoinModules(appModule)
    }

    @Test
    fun mainActivity_ShouldNOT_be_Null() {
        // Given
        val activity = Robolectric.buildActivity(LoginActivity::class.java)

        // Then
        Assert.assertNotNull(activity)
    }

    @Test
    fun clickingButton_shouldChangeMessage() {
//        val activity = Robolectric.setupActivity(LoginActivity::class.java)
//
//        activity.login.performClick()
//
//        assertTrue(activity.password.text.toString() == "Robolectric Rocks!")
    }
}
