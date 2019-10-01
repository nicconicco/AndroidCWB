package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.AndroidCWBApplication
import carlos.nicolau.galves.androidcwb.framework.di.appModule
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.test.AutoCloseKoinTest
import org.koin.test.check.checkModules
import org.mockito.Mockito.mock

class LoginModuleTest : AutoCloseKoinTest() {

    @Before
    fun setUpTest() {
        startKoin { modules(appModule) }
    }

    @Test
    fun `Assert if modules is ok`() {
        val mockedAndroidContext = mock(AndroidCWBApplication::class.java)

        koinApplication {
            androidContext(mockedAndroidContext)
            loadKoinModules(appModule)
        }.checkModules()
    }
}