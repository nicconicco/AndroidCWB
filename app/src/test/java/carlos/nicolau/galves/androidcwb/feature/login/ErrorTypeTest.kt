package carlos.nicolau.galves.androidcwb.feature.login

import carlos.nicolau.galves.core.errors.ErrorType
import junit.framework.Assert.assertEquals
import org.junit.Test

class ErrorTypeTest {

    @Test
    fun test_ERRO_INTERNET() {
        assertEquals("Sem internet", ErrorType.ERRO_INTERNET.value)
    }

    @Test
    fun test_ERRO_404() {
        assertEquals("Erro 404", ErrorType.ERRO_404.value)
    }

    @Test
    fun test_ERRO_265() {
        assertEquals("Erro consulte o código 265 do servidor", ErrorType.ERRO_265.value)
    }

    @Test
    fun test_ERRO_USER_NOT_FOUND() {
        assertEquals("Erro user not found", ErrorType.ERRO_USER_NOT_FOUND.value)
    }

    @Test
    fun ERRO_USER_NOT_ADDED_FIRESTORE() {
        assertEquals("Erro user not added on Firestore", ErrorType.ERRO_USER_NOT_ADDED_FIRESTORE.value)
    }

    @Test
    fun ERRO_USER_NOT_ADDED_ROOM() {
        assertEquals("Erro user not added on database Room", ErrorType.ERRO_USER_NOT_ADDED_ROOM.value)
    }
}