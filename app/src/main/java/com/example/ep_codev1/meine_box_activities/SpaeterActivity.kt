package com.example.ep_codev1.meine_box_activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ep_codev1.liste.ListAdapter
import com.example.ep_codev1.liste.ListItem
import com.example.ep_codev1.R
import kotlinx.android.synthetic.main.activity_rvdringend.*

class SpaeterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_rvdringend)

        val listen = SpaeterListe

        rvDringend.layoutManager = LinearLayoutManager(this)
        rvDringend.adapter = ListAdapter(listen.listend)

        val actionBar = supportActionBar
        actionBar!!.title="Später"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    object SpaeterListe{
        var listend = mutableListOf<ListItem>()

        fun addListeSpaeter(listItem : ListItem) {
            listend.add(listItem)
        }
    }
}