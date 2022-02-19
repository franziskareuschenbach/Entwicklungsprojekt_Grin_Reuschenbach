package com.example.ep_codev1.meine_box_activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ep_codev1.liste.ListAdapter
import com.example.ep_codev1.liste.ListItem
import com.example.ep_codev1.R
import kotlinx.android.synthetic.main.activity_rvdringend.*

class OkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_rvdringend)

        val listen = OkListe

        rvDringend.layoutManager = LinearLayoutManager(this)
        rvDringend.adapter = ListAdapter(listen.listend)

        val actionBar = supportActionBar
        actionBar!!.title="Ok"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    object OkListe{
        var listend = mutableListOf<ListItem>()

        fun addListeOk(listItem : ListItem) {
            listend.add(listItem)
        }
    }
}