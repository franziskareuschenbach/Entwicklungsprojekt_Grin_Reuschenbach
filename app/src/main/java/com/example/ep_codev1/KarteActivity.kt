package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class KarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karte)

        //AnimationButton zu Animation
        val animationsButton = findViewById<ImageButton>(R.id.playerbutton)

        animationsButton.setOnClickListener {
            startActivity(Intent(this, AnimationActivity :: class.java))
        }

        /*
        //VolumeButton zu Vorlesen
        val volumeButton = findViewById<ImageButton>(R.id.volumebutton)

        volumeButton.setOnClickListener {
            startActivity(Intent(this, AnimationActivity :: class.java))
        }

         */


    }
}