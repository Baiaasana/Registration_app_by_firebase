package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var mail: TextView
    private lateinit var password: TextView
    private lateinit var registration: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()
        listeners()
    }
    private fun init(){
        mail = findViewById(R.id.registerMail)
        password = findViewById(R.id.registerPassword)
        registration = findViewById(R.id.registerButton)
    }
    private fun listeners() {

        registration.setOnClickListener {

            val mail1 = mail.text.toString()
            val password1 = password.text.toString()

            if (mail1.isEmpty() || password1.isEmpty()){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail1, password1)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }

                    }

            }
        }
    }
}