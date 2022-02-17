package com.example.ep_codev1.meine_box_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import com.example.ep_codev1.DringendActivity
import com.example.ep_codev1.R

class  MeineBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_meine_box)

        val actionBar = supportActionBar

        actionBar!!.title="Mein Box"

        actionBar.setDisplayHomeAsUpEnabled(true)

        //Meine DringendButton zu Dringend
        val box = findViewById<Button>(R.id.buttonDringendBox)
        box.setOnClickListener {
            startActivity(Intent(this, DringendActivity :: class.java ))
        }

        //Meine ErledigtButton zu Erledigt
        val box1 = findViewById<Button>(R.id.buttonErledigtBox)
        box1.setOnClickListener {
            startActivity(Intent(this, ErledigtActivity :: class.java ))
        }

        //Meine SpäterButton zu Später
        val box2 = findViewById<Button>(R.id.buttonSpäterBox)
        box2.setOnClickListener {
            startActivity(Intent(this, SpaeterActivity :: class.java ))
        }

        //Meine OkButton zu Ok
        val box3 = findViewById<Button>(R.id.buttonOkBox)
        box3.setOnClickListener {
            startActivity(Intent(this, OkActivity :: class.java ))
        }

    }
}