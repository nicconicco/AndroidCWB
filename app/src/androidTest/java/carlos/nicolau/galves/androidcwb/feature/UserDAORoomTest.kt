package carlos.nicolau.galves.androidcwb.feature

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserDAO
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDAORoomTest {

    private lateinit var androidCWBRoom: AndroidCWBRoom
    private lateinit var userDAO: UserDAO

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("carlos.nicolau.galves.androidcwb", appContext.packageName)
    }

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        androidCWBRoom = AndroidCWBRoom.getDatabase(context)
        userDAO = androidCWBRoom.getUserDAO()
    }

    @Test
    fun whenInsertUser_checkIfDbHaveOneUser() {
        androidCWBRoom.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", idFirestore = "meutokenfalso")
        )

        Assert.assertNotNull(
            userDAO.getAllUser()
        )
    }

    @Test
    fun whendeleteAlltUser_checkIfDbIsEmpty() {
        androidCWBRoom.getUserDAO().deleteAll()
        val list = userDAO.getAllUser()

        Assert.assertTrue(list.isEmpty())
    }

    @After
    fun closeDb() {
        androidCWBRoom.close()
    }
}