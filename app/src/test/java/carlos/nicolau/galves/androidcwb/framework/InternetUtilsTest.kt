package carlos.nicolau.galves.androidcwb.framework

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import carlos.nicolau.galves.androidcwb.framework.util.InternetUtilsImpl
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class InternetUtilsTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `Assert internetUtilsImpl isNetworkAvailable`() {
        val app = RuntimeEnvironment.application as AndroidCWBApplication
        val internetUtilsImpl: InternetUtilsImpl = InternetUtilsImpl(app)
        assert(internetUtilsImpl.isNetworkAvailable())
    }
}