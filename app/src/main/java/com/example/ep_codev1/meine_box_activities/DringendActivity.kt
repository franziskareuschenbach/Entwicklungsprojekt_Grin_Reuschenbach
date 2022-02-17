package com.example.ep_codev1

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ep_codev1.liste.ListeAdapter
import com.example.ep_codev1.liste.ListenItem
import kotlinx.android.synthetic.main.activity_rvdringend.*


class DringendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_rvdringend)

        val listen = DringendListe


        rvDringend.layoutManager = LinearLayoutManager(this)
        rvDringend.adapter = ListeAdapter(listen.listend)

        val actionBar = supportActionBar
        actionBar!!.title="DRINGEND"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
    object DringendListe{
        var listend = mutableListOf<ListenItem>()

        fun addListeDringend(listenItem : ListenItem) {
            listend.add(listenItem)
        }
    }
}