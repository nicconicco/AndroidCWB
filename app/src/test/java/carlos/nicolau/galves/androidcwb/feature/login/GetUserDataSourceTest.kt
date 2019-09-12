package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.androidcwb.framework.database.GetUserDataSource
import org.junit.Test

class GetUserDataSourceTest {

    @Test
    fun whenGetUserRepositoryImplCall_shoulReturnUser() {
        val getUserDataSource = GetUserDataSource()
        val user = getUserDataSource.execute("","")
        assert(user.didLogin)
    }
}