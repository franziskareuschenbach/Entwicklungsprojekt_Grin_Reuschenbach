package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import com.example.ep_codev1.karte.KarteActivity
import com.example.ep_codev1.meine_box_activities.MeineBoxActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)

        //Start Button auf der Startseite
        val start = findViewById<Button>(R.id.start)    // on click event

        start.setOnClickListener {
            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, KarteActivity :: class.java))
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