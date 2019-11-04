package carlos.nicolau.galves.androidcwb.listhome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ListHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_home_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListHomeFragment.newInstance())
                .commitNow()
        }
    }

}
