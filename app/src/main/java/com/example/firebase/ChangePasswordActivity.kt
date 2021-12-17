package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var newPassword: TextView
    private lateinit var changeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        newPassword = findViewById(R.id.newPassword)
        changeButton = findViewById(R.id.changePasswordButton)

        changeButton.setOnClickListener {
            val password = newPassword.text.toString()
            if (password.isEmpty() || password.length < 8){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(password)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "Password changed successfully", Toast.LENGTH_SHORT).show()

                    } else {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}