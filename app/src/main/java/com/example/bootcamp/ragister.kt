package com.example.bootcamp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.content.Intent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class ragister : AppCompatActivity() {

    private lateinit var iptusername: EditText
    private lateinit var iptemail: EditText
    private lateinit var iptpassword: EditText
    private lateinit var btnregister: Button
    private lateinit var fireauth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ragister)
        iptusername = findViewById(R.id.username_input)
        iptpassword = findViewById(R.id.pass_input)
        btnregister = findViewById(R.id.register_btn)

        fireauth = FirebaseAuth.getInstance()

        if (fireauth.currentUser!=null){
            val intent = Intent(this@ragister, home::class.java)
            startActivity(intent)
        }

        btnregister.setOnClickListener {
            val username = iptusername.text.toString()
            val email = iptemail.text.toString()
            val password = iptpassword.text.toString()

            if (TextUtils.isEmpty(username)) {
                iptusername.error = "Username is required"
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(email)) {
                iptemail.error = "Email is required"
                return@setOnClickListener
            }
            else if (password.length<6) {
                iptpassword.error = "Password must be 6 character or more"
                return@setOnClickListener
            }

            val onCompleteListener = OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
                    val authResult = task.result
                    Toast.makeText(this@ragister, "Authentication successful!", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@ragister, home::class.java)
                    startActivity(intent)
                } else {
                    val exception = task.exception
                    Toast.makeText(this@ragister, "Authentication Failed!", Toast.LENGTH_SHORT).show()
                }
            }

            fireauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(onCompleteListener)

        }
    }
}