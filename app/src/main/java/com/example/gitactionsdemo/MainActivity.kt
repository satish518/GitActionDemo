package com.example.gitactionsdemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var validator: LoginValidator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validator = LoginValidator()

        val username = findViewById<EditText>(R.id.etUsername)
        val password = findViewById<EditText>(R.id.etPassword)
        val button = findViewById<Button>(R.id.btnLogin)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        button.setOnClickListener {
            val isValid = validator.isValid(
                username.text.toString(),
                password.text.toString()
            )

            // 👉 message is created here
            val message = if (isValid) "Login Success" else "Login Failed"

            // 👉 instead of Toast, set TextView
            tvResult.text = message
        }
    }
}