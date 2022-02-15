package com.example.ep_codev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageButton

class KarteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_karte)

        //AnimationButton zu Animation
        val animationsButton = findViewById<ImageButton>(R.id.playerbutton)

        animationsButton.setOnClickListener {
            startActivity(Intent(this, AnimationActivity :: class.java))
        }


        //VorleseButton zu Vorlesen
        val vorleseButton = findViewById<ImageButton>(R.id.vorlesebutton)

        vorleseButton.setOnClickListener {
            startActivity(Intent(this, VorlesenActivity :: class.java))
        }




    }
}