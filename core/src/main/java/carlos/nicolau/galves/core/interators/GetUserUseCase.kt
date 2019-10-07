package carlos.nicolau.galves.core.interators

import carlos.nicolau.galves.core.domain.User
import carlos.nicolau.galves.core.errors.ErrorType
import carlos.nicolau.galves.core.utils.Callback

interface GetUserUseCase {
    fun execute(
        username: String,
        password: String,
        callback: Callback<User, ErrorType>
    )
}
