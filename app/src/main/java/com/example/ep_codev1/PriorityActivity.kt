package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PriorityActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_priority_activity)


        val actionBar = supportActionBar

        actionBar!!.title="Priorität"

        actionBar.setDisplayHomeAsUpEnabled(true)


    }




}