package carlos.nicolau.galves.androidcwb.framework.room

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.utils.Mapper

class UserEntityMapper : Mapper<UserEntity?, User> {
    override fun mapFrom(from: UserEntity?): User {
        val user = User()

        from?.let {
            user.didLogin = it.didLogin
            user.login = it.user
            user.password = it.token
        }

        return user
    }
}