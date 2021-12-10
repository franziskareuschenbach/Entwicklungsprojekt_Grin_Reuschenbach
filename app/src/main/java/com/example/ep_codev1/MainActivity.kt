package com.example.ep_codev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val start = findViewById<Button>(R.id.start)    // on click event

        start.setOnClickListener {

            Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show()

        }
    }
}