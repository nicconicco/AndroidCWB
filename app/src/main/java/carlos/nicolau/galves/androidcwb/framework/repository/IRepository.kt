package carlos.nicolau.galves.androidcwb.framework.repository

import carlos.nicolau.galves.androidcwb.framework.room.UserEntity

interface IRepository {
    fun getAllUser(): List<UserEntity>
    fun insert()
    fun first(): UserEntity?
}