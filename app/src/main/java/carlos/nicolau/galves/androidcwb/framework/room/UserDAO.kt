package carlos.nicolau.galves.androidcwb.framework.room

import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity)

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * from user")
    fun getAllUser(): List<UserEntity>

    @Query(
        "SELECT * from user WHERE token = :token AND didLogin = :didLogin")
    fun getUserWithTokenAndDidLogin(token: String, didLogin: Boolean): List<UserEntity>

    @Update
    fun update(vararg user: UserEntity)

    @Delete
    fun delete(vararg menu: UserEntity)
}