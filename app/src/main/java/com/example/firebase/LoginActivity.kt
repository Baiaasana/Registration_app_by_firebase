package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    private lateinit var mail: TextView
    private lateinit var password: TextView
    private lateinit var login: Button
    private lateinit var forgotpassword: Button
    private lateinit var signup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
        listeners()
    }

    private fun init(){

        mail = findViewById(R.id.loginMail)
        password = findViewById(R.id.loginPassword)
        login = findViewById(R.id.loginButton)
        forgotpassword = findViewById(R.id.loginForgotButton)
        signup = findViewById(R.id.loginSignupButton)

    }

    private fun listeners(){
        login.setOnClickListener {

            val email = mail.text.toString()
            val password2 = password.text.toString()

            if (email.isEmpty() || password2.isEmpty()){

                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password2)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful){

                        startActivity(Intent(this, ProfileActivity::class.java))
                        finish()

                    }else{
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        signup.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        forgotpassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }


    }

}