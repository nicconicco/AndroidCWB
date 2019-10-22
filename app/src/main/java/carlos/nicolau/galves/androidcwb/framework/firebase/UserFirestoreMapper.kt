package carlos.nicolau.galves.androidcwb.framework.firebase

import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.utils.Mapper

class UserFirestoreMapper : Mapper<UserEntity, User> {
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

    override fun mapFrom(from: UserEntity): User {
        return User(from.didLogin, from.user, from.idFirestore)
    }
}