package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Start Button auf der Startseite
        val start = findViewById<Button>(R.id.start)    // on click event

        start.setOnClickListener {

            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnimationActivity :: class.java)
            startActivity(intent)
        }
        val actionBar = supportActionBar

        actionBar!!.title="Startseite"

        //Meine Box Button zu MeineBoxActivity
        val box = findViewById<Button>(R.id.buttonMeineBox)
        box.setOnClickListener {
           val intent = Intent(this, MeineBoxActivity :: class.java )
           startActivity(intent)
        }

    }
}

