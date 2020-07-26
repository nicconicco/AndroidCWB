package carlos.nicolau.galves.androidcwb.framework.repository

import carlos.nicolau.galves.androidcwb.framework.room.AndroidCWBRoom
import carlos.nicolau.galves.androidcwb.framework.room.UserEntity

class RepositoryImpl(private val db: AndroidCWBRoom) : IRepository {
    override fun getAllUser() = db.getUserDAO().getAllUser()
    override fun insert() {
        db.getUserDAO().insert(
            UserEntity(didLogin = true, user = "AndroidCWB", token = "meutokenfalso")
        )
    }

    override fun first(): UserEntity? = db.getUserDAO().getAllUser().first()
}