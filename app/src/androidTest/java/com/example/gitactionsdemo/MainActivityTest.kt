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

    @Test
    fun loginSuccess_showsSuccessMessage() {

        Thread.sleep(3000)

        try {
            onView(withId(R.id.etUsername))
                .perform(typeText("admin"), closeSoftKeyboard())

            onView(withId(R.id.etPassword))
                .perform(typeText("1234"), closeSoftKeyboard())

            onView(withId(R.id.btnLogin))
                .perform(click())

            onView(withId(R.id.tvResult))
                .check(matches(withText("Login Success")))
        } catch (e: Exception) {
            Thread.sleep(2000)
            onView(withId(R.id.tvResult))
                .check(matches(withText("Login Success")))
        }
    }
}