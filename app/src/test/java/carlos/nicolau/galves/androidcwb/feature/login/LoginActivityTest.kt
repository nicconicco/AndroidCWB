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
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config


@Config(application = AndroidCWBApplication::class, sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class LoginActivityTest : KoinTest {

    val viewModelImpl by inject<LoginViewModelImpl>()

    @Before
    fun before(){


        val app = RuntimeEnvironment.application as AndroidCWBApplication

        stopKoin()
        startKoin {
            androidContext(app)
            modules(appModule)
        }
    }

    @Test
    fun mainActivity_ShouldNOT_be_Null() {
        // Given
        val activity = Robolectric.buildActivity(LoginActivity::class.java)

        // Then
        Assert.assertNotNull(activity)
    }
}
