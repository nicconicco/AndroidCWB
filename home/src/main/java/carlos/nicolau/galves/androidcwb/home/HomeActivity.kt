package carlos.nicolau.galves.androidcwb.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import carlos.nicolau.galves.androidcwb.home.HomeFragment
import carlos.nicolau.galves.androidcwb.home.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    HomeFragment.newInstance()
                )
                .commitNow()
        }
    }

}
