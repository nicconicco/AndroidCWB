package carlos.nicolau.galves.androidcwb.feature.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ExampleUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `my test`() {
        val mutableLiveData = MutableLiveData<String>()

        mutableLiveData.postValue("test")

        assertEquals("test", mutableLiveData.value)
    }
}