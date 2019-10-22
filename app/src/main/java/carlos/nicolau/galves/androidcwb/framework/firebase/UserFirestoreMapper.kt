package carlos.nicolau.galves.androidcwb.framework.firebase

import carlos.nicolau.galves.androidcwb.framework.room.UserEntity
import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.utils.Mapper

class UserFirestoreMapper : Mapper<UserEntity, User> {
    override fun mapFrom(from: UserEntity): User {
        return User(from.didLogin, from.user, from.token)
    }
}