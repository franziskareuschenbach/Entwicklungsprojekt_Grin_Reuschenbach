package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class  MeineBoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meine_box)

        val actionBar = supportActionBar

        actionBar!!.title="Mein Box"

        actionBar.setDisplayHomeAsUpEnabled(true)



    }
}