package com.example.ep_codev1.vorlesen_activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.ep_codev1.karte.KarteActivity
import com.example.ep_codev1.R

class VorlesenActivity3 : AppCompatActivity() {

    var videoView : VideoView? = null
    var mediaController : MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_vorlesen)

        val videoView = findViewById<View>(R.id.videoVorlesen) as VideoView?

        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController !!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://"+packageName + "/" + R.raw.gefuehlevorlesen))

        videoView.requestFocus()

        //start Video
        videoView.start()

        videoView.setOnCompletionListener {
            //Toast.makeText(applicationContext,"VideoEnd", Toast.LENGTH_LONG).show()
        }

        videoView.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        //Action Bar zurück zur Startseite
        val actionBar = supportActionBar
        actionBar!!.hide()

        //Weiter Button unter Video Player zu KarteActivity
        val weiter = findViewById<Button>(R.id.buttonWeiter)

        weiter.setOnClickListener {
            val intent = Intent(this, KarteActivity :: class.java)
            startActivity(intent)
        }
    }
}