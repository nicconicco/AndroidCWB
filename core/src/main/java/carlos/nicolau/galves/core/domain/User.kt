package carlos.nicolau.galves.core.domain

class User(didLogin: Boolean = false, login: String = "", password: String = "") {
    var id: String? = null
    var didLogin : Boolean = didLogin
    var login : String = login
    var password : String = password
}