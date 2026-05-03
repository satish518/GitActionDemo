package com.example.gitactionsdemo

import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class LoginValidatorTest {

    private val validator = LoginValidator()

    @Test
    fun validCredentials_shouldReturnTrue() {
        val result = validator.isValid("admin", "1234")
        assertTrue(result)
    }

    @Test
    fun invalidCredentials_shouldReturnFalse() {
        val result = validator.isValid("user", "wrong")
        assertFalse(result)
    }
}