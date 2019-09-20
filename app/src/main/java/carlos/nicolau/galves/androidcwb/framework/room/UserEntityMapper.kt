package carlos.nicolau.galves.androidcwb.framework.room

import carlos.nicolau.galves.core.domain.User

class UserEntityMapper {

    companion object {
        fun transformToUser(userEntity: UserEntity?): User {
            val user = User()

            userEntity?.let {
                user.didLogin = it.didLogin
            }

            return user
        }
    }
}