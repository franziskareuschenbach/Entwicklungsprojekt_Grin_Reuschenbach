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

class AnimationActivity : AppCompatActivity() {

    var videoView : VideoView? = null

    var mediaController : MediaController? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        val videoView = findViewById<View>(R.id. videoView) as VideoView?

        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController !!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)

        videoView!!.setVideoURI(Uri.parse("android.resource://"+packageName + "/" + R.raw.kauenundschluckenanimation))

        videoView!!.requestFocus()

        //start Video
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            Toast.makeText(applicationContext,"VideoEnd", Toast.LENGTH_LONG).show()
        }

        videoView!!.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        //Action Bar zurück zur Startseite
        val actionBar = supportActionBar

        actionBar!!.title="Animation"

        actionBar.setDisplayHomeAsUpEnabled(true)

        //Weiter Button unter Video Player zu PriorityActivity
        val weiter = findViewById<Button>(R.id.buttonWeiter)

        weiter.setOnClickListener {
            val intent = Intent(this, PriorityActivity :: class.java)
            startActivity(intent)
        }
    }
}





