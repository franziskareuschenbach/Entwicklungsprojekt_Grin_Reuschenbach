package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager

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



    }
}