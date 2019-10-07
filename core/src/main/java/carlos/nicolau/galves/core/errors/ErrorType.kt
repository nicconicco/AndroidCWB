package carlos.nicolau.galves.core.errors

enum class ErrorType(val value: String) {
    ERRO_INTERNET("Sem internet"),
    ERRO_404("Erro 404"),
    ERRO_265("Erro consulte o código 265 do servidor"),
    ERRO_USER_NOT_FOUND("Erro user not found")
}