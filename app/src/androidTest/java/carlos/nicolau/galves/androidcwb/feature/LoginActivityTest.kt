package carlos.nicolau.galves.androidcwb.feature

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import carlos.nicolau.galves.androidcwb.R
import carlos.nicolau.galves.androidcwb.presentation.login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun check_initial_status_LoginActivity() {
        onView(withId(R.id.username)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))

        onView(withId(R.id.login)).check(matches(isDisplayed()))
        onView(withId(R.id.login)).check(matches(isEnabled()))
    }
}