package carlos.nicolau.galves.androidcwb.framework.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var didLogin: Boolean = false,
    var user: String = "",
    var password: String = "",
    var idFirestore: String = ""
) : Serializable