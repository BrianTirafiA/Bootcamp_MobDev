package com.example.bootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var iptemail : EditText
    private lateinit var iptpassword : EditText
    private lateinit var btnlogin : Button
    private lateinit var btnpindah : Button
    private lateinit var fireauth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        iptemail = findViewById(R.id.email_input)
        iptpassword = findViewById(R.id.pass_input)
        btnlogin = findViewById(R.id.login_btn)
        btnpindah = findViewById(R.id.toregister_btn)

        fireauth = FirebaseAuth.getInstance()

        btnlogin.setOnClickListener{
            val email = iptemail.text.toString()
            val password = iptpassword.text.toString()

            if (TextUtils.isEmpty(email)) {
                iptemail.error = "Username is required"
                return@setOnClickListener
            }
            else if (password.length<6) {
                iptpassword.error = "Password must be 6 character or more"
                return@setOnClickListener
            }

            val onCompleteListener = OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    val authResult = task.result
                    Toast.makeText(this@login, "Authentication successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@login, home::class.java)
                    startActivity(intent)
                } else {
                    val exception = task.exception
                    Toast.makeText(this@login, "Authentication Failed!", Toast.LENGTH_SHORT).show()
                }
            }

            fireauth.signInWithEmailAndPassword(email,password).addOnCompleteListener(onCompleteListener)

            btnpindah.setOnClickListener{
                val intent = Intent(this@login, ragister::class.java)
                startActivity(intent)
            }
        }
    }
}