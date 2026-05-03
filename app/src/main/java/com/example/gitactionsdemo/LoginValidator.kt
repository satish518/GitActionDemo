package com.example.gitactionsdemo

class LoginValidator {

    fun isValid(username: String, password: String): Boolean {
        return username == "admin" && password == "1234"
    }
}