package com.example.ep_codev1.animation_activities

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
import com.example.ep_codev1.PriorityActivity
import com.example.ep_codev1.R

class AnimationActivity1 : AppCompatActivity() {

    var videoView : VideoView? = null
    var mediaController : MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_animation)

        val videoView = findViewById<View>(R.id.videoView) as VideoView?

        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController !!.setAnchorView(this.videoView)
        }

        videoView!!.setMediaController(mediaController)
        videoView.setVideoURI(Uri.parse("android.resource://"+packageName + "/" + R.raw.metahmananimationsvideo1))
        videoView.requestFocus()

        //start Video
        videoView.start()

        videoView.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        //Änderungen 15.2 Videos aus storage streamen
        //videoView!!.setVideoURI(Uri.parse(https://firebasestorage.googleapis.com/v0/b/ep-srb.appspot.com/o/Animation%2FAnima.test2.mp4?alt=media&token=f3d74086-1f42-479f-ae19-1337c0e96c95)

        //Action Bar zurück zur Startseite
        val actionBar = supportActionBar
        actionBar!!.hide()

        //Weiter Button unter Video Player zu PriorityActivity
        val weiter = findViewById<Button>(R.id.buttonWeiter)

        weiter.setOnClickListener {
            val intent = Intent(this, PriorityActivity :: class.java)
            startActivity(intent)
        }
    }
}