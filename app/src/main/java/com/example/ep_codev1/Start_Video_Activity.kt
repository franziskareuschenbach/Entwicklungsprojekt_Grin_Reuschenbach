package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Start_Video_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_video)

        //Action Bar zurück zur Startseite
        val actionBar = supportActionBar

        actionBar!!.title="Animation"

        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}