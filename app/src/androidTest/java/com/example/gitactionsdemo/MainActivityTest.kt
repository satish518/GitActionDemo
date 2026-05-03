package com.example.gitactionsdemo

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.junit.rules.ActivityScenarioRule

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    // 🔹 Helper function for login
    private fun performLogin(username: String, password: String) {
        onView(withId(R.id.etUsername))
            .perform(replaceText(username), closeSoftKeyboard())

        onView(withId(R.id.etPassword))
            .perform(replaceText(password), closeSoftKeyboard())

        onView(withId(R.id.btnLogin))
            .perform(click())
    }

    // 🔹 Helper function to check result
    private fun checkResult(expected: String) {
        onView(withId(R.id.tvResult))
            .check(matches(withText(expected)))
    }

    // ✅ 1. Success case
    @Test
    fun loginSuccess_validCredentials() {

        performLogin("admin", "1234")
        checkResult("Login Success")
    }

    // ❌ 2. Wrong username
    @Test
    fun loginFailure_wrongUsername() {

        performLogin("user", "1234")
        checkResult("Login Failed")
    }

    // ❌ 3. Wrong password
    @Test
    fun loginFailure_wrongPassword() {

        performLogin("admin", "wrong")
        checkResult("Login Failed")
    }

    // ❌ 4. Both wrong
    @Test
    fun loginFailure_bothWrong() {

        performLogin("user", "wrong")
        checkResult("Login Failed")
    }

    // ❌ 5. Empty fields
    @Test
    fun loginFailure_emptyFields() {

        performLogin("", "")
        checkResult("Login Failed")
    }
}