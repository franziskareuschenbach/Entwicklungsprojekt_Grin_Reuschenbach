package com.example.ep_codev1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class Tutorial : AppCompatActivity() {

    var videoView2: VideoView? = null
    var mediaController: MediaController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)

        val videoViewTutorial = findViewById<View>(R.id.videoView2) as VideoView?



        val beendenTutorial = findViewById<Button>(R.id.buttonBeenden)    // on click event

        beendenTutorial.setOnClickListener {
            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity :: class.java))
        }
        val actionBarTutorial = supportActionBar

        actionBarTutorial!!.title="Tutorial"




        if (mediaController == null) {
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.videoView2)
        }

        videoViewTutorial!!.setMediaController(mediaController)

        videoViewTutorial!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.tutorial))

        videoViewTutorial!!.requestFocus()

        //start Video
        videoViewTutorial!!.start()

        videoViewTutorial!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "VideoEnd", Toast.LENGTH_LONG).show()
        }

        videoViewTutorial!!.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        //Action Bar zurück zur Startseite
        val actionBar = supportActionBar

        actionBar!!.title = "Tutorial"

        actionBar.setDisplayHomeAsUpEnabled(true)

        //Weiter Button unter Video Player zu PriorityActivity
        val beenden = findViewById<Button>(R.id.buttonBeenden)

        beenden.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}