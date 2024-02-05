package com.example.bootcamp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class profile : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val accountProfile = findViewById<Button>(R.id.account_profile)
        accountProfile.setOnClickListener {
            val Intent = Intent(this, account::class.java)
        }

        val accountLogin = findViewById<Button>(R.id.sign_out_button)
        accountLogin.setOnClickListener{
            val Intent = Intent(this, login::class.java)

        }
    }
}