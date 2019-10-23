package carlos.nicolau.galves.androidcwb.framework.room

import androidx.room.*

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: UserEntity):Long

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * from user")
    fun getAllUser(): List<UserEntity>

    @Query(
        "SELECT * from user WHERE idFirestore = :idFirestore AND didLogin = :didLogin"
    )
    fun getUserWithTokenAndDidLogin(idFirestore: String, didLogin: Boolean): List<UserEntity>

    @Update
    fun update(vararg user: UserEntity)

    @Delete
    fun delete(vararg menu: UserEntity)
}