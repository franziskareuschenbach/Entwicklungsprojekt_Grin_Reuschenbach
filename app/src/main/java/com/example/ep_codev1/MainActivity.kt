package com.example.ep_codev1

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Start Button auf der Startseite
        val start = findViewById<Button>(R.id.start)    // on click event

        start.setOnClickListener {
            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, AnimationActivity :: class.java))
        }
        val actionBar = supportActionBar

        actionBar!!.title="Startseite"

        //Meine Box Button zu MeineBoxActivity
        val box = findViewById<Button>(R.id.buttonMeineBox)
        box.setOnClickListener {
           startActivity(Intent(this, MeineBoxActivity :: class.java ))
        }

        //Auslogen Button zu LogInActivity
        val logOut = findViewById<Button>(R.id.buttonLogOut)
        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity :: class.java ))
        }

    }
}

