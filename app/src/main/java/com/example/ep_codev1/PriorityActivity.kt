package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

class PriorityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_priority_activity)


        val actionBar = supportActionBar

        actionBar!!.title="Priorität"

        actionBar.setDisplayHomeAsUpEnabled(true)


    }




}