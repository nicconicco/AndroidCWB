package carlos.nicolau.galves.androidcwb

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class ExampleLiveDataUnitTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Test
    fun `my test`() {
        val mutableLiveData = MutableLiveData<String>()

        mutableLiveData.postValue("test")

        assertEquals("test", mutableLiveData.value)
    }
}