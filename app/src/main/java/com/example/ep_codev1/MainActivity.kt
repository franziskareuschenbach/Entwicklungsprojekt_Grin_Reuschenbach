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


class MainActivity : AppCompatActivity() {

    var videoView : VideoView? = null

    var mediaController : MediaController? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Video

        var videoView = findViewById<View>(R.id. videoView) as VideoView?

        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController !!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)

        videoView!!.setVideoURI(Uri.parse("android.resource://"+packageName + "/" + R.raw.animation))

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


        //Start Button auf der Startseite
        val start = findViewById<Button>(R.id.start)    // on click event

        start.setOnClickListener {

            //Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Start_Video_Activity :: class.java)
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

