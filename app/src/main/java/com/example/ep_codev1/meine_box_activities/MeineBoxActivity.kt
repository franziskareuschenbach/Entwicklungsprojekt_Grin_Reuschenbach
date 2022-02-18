package com.example.ep_codev1.meine_box_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
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
        val infoDringend = findViewById<ImageButton>(R.id.frageButtonDringendBox)

        infoDringend.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dringend")
            builder.setMessage("Sie sind betroffen und möchten kurzfristig eine Lösung herbeiführen.")

            val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        //Meine ErledigtButton zu Erledigt
        val box1 = findViewById<Button>(R.id.buttonErledigtBox)
        box1.setOnClickListener {
            startActivity(Intent(this, ErledigtActivity :: class.java ))
        }
        val infoErledigt = findViewById<ImageButton>(R.id.frageButtonErledigtBox)

        infoErledigt.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Erledigt")
            builder.setMessage("Sie waren mal betroffen, das Problem besteht jedoch nicht mehr.")

            val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        //Meine SpäterButton zu Später
        val box2 = findViewById<Button>(R.id.buttonSpäterBox)
        box2.setOnClickListener {
            startActivity(Intent(this, SpaeterActivity :: class.java ))
        }
        val infoSpaeter = findViewById<ImageButton>(R.id.frageButtonSpaeterBox)

        infoSpaeter.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Später")
            builder.setMessage("Sie sind betroffen, jedoch ist keine kurfristige Lösung möglich oder nötig.")

            val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

        //Meine OkButton zu Ok
        val box3 = findViewById<Button>(R.id.buttonOkBox)
        box3.setOnClickListener {
            startActivity(Intent(this, OkActivity :: class.java ))
        }
        val infoOk = findViewById<ImageButton>(R.id.frageButtonOkBox)

        infoOk.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Ok")
            builder.setMessage("Sie sind nicht betroffen.")

            val alertDialog : AlertDialog = builder.create()
            alertDialog.setCancelable(true)
            alertDialog.show()
        }

    }
}