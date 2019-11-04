package carlos.nicolau.galves.androidcwb.framework.base

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import carlos.nicolau.galves.androidcwb.BuildConfig
import carlos.nicolau.galves.androidcwb.framework.module_android.ModuleName
import carlos.nicolau.galves.androidcwb.presentation.login.LoginActivity
import carlos.nicolau.galves.core.utils.Callback
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

open class BaseActivity : AppCompatActivity() {
    //region Module Controll do not delete this section
    private val splitInstallManager: SplitInstallManager by lazy {
        SplitInstallManagerFactory.create(applicationContext)
    }

    internal fun installRegistrationModule(
        moduleName: ModuleName,
        listener: Callback<Boolean, String>
    ) {
        val request = SplitInstallRequest.newBuilder()
            .addModule(moduleName.value)
            .build()

        splitInstallManager.startInstall(request)
            .addOnSuccessListener {
                Log.d(BaseActivity::class.java.simpleName, it.toString())
                listener.onSuccess(true)
            }
            .addOnFailureListener {
                Log.e(BaseActivity::class.java.simpleName, it.toString())
                listener.onError(it.toString())
            }
    }

    internal fun openModule(moduleName: ModuleName) {
        if (splitInstallManager.installedModules.contains(moduleName.value)) {
            val i = Intent()
            i.setClassName(
                BuildConfig.APPLICATION_ID,
                checkModule(moduleName)
            )
            i.putExtra("ExtraInt", 3) // Test intent for Dynamic feature
            startActivity(i)
        } else {
            Log.e(LoginActivity::class.java.simpleName, "Registration feature is not installed")
        }
    }

    private fun checkModule(moduleName: ModuleName): String {
        return when (moduleName) {
            ModuleName.LIST_HOME -> ModuleName.LIST_HOME_DIR.value
            else -> {
                ModuleName.NOT_FOUND.value
            }
        }
    }
    //endregion
}