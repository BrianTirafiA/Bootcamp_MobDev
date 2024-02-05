package com.example.bootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var iptusername : EditText
    private lateinit var iptpassword : EditText
    private lateinit var btnlogin : Button
    private lateinit var fireauth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        iptusername = findViewById(R.id.username_input)
        iptpassword = findViewById(R.id.pass_input)
        btnlogin = findViewById(R.id.login_btn)

        fireauth = FirebaseAuth.getInstance()

        btnlogin.setOnClickListener{
            val username = iptusername.text
            val password = iptpassword.text
        }
    }
}