package com.example.ep_codev1.meine_box_activities

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ep_codev1.liste.ListeAdapter
import com.example.ep_codev1.liste.ListenItem
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
        rvDringend.adapter = ListeAdapter(listen.listend)

        val actionBar = supportActionBar
        actionBar!!.title="Ok"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    object OkListe{
        var listend = mutableListOf<ListenItem>()

        fun addListeOk(listenItem : ListenItem) {
            listend.add(listenItem)
        }
    }
}