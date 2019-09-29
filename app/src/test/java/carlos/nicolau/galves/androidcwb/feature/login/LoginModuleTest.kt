package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.di.AndroidCWBMvpFactory.inject
import carlos.nicolau.galves.androidcwb.framework.di.appModule
import carlos.nicolau.galves.core.data.GetUserRepository
import carlos.nicolau.galves.core.data.GetUserRepositoryImpl
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject

class LoginModuleTest : AutoCloseKoinTest() {

//    @Before
//    fun setUpTest() {
//        startKoin { modules(appModule) }
//    }
//
//    @Test
//    fun `Assert if repository is provided by module`() {
//        loadKoinModules(appModule)
//        val repository by inject<GetUserRepository>()
//        with(repository) {
//            assertNotNull(this)
//            assertEquals(GetUserRepositoryImpl::class.java, javaClass)
//        }
//    }
}