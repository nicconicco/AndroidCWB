package carlos.nicolau.galves.androidcwb.framework.room

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.utils.Mapper

class UserEntityMapper : Mapper<UserEntity?, User> {

    override fun reverseFrom(from: User): UserEntity {
        val userEntity = UserEntity()

        from.id?.let {
            userEntity.idFirestore = it
        }

        userEntity.user = from.login
        userEntity.password = from.password
        userEntity.didLogin = from.didLogin

        return userEntity
    }

    override fun mapFrom(from: UserEntity?): User {
        val user = User()

        from?.let {
            user.didLogin = it.didLogin
            user.login = it.user
            user.id = it.idFirestore
            user.password = it.password
        }

        return user
    }
}