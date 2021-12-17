package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {

    private lateinit var changePassword: Button
    private lateinit var logOut: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        listeners()
    }

    private fun init(){
        changePassword = findViewById(R.id.profileChangePassword)
        logOut = findViewById(R.id.profileLogOut)
        textView = findViewById(R.id.textView)

        textView.text = FirebaseAuth.getInstance().currentUser?.email
    }

    private  fun listeners(){
        changePassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
            finish()
        }
        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }

}