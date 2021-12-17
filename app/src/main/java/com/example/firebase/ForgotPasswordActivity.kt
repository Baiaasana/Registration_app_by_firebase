package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var mail: TextView
    private lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        init()
        listeners()
    }

    private fun init(){
        mail = findViewById(R.id.forgotPasswordMail)
        send = findViewById(R.id.forgotSendButton)
    }
    private fun listeners(){
        send.setOnClickListener {
            val mail1 = mail.text.toString()

            if (mail1.isEmpty()){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else{

                FirebaseAuth.getInstance().sendPasswordResetEmail(mail1)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                        }

                    }
            }

        }




    }

}