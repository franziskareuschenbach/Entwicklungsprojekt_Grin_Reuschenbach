package com.example.ep_codev1.karte

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_codev1.R
import com.example.ep_codev1.animation_activities.*
import com.example.ep_codev1.vorlesen_activities.*
import kotlinx.android.synthetic.main.activity_itemkarte.view.*

class KarteAdapter(val mKarten : List<KarteItem>): RecyclerView.Adapter<KarteAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_itemkarte, parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val karte = mKarten[position]

        holder.itemViews.kueberschrift.text = karte.ueberschrift
        holder.itemViews.kktext.text = karte.erklaerungText
        holder.itemViews.kkbeispiele.text = karte.beispiele
        holder.itemViews.kkicf.text = karte.icf

    }

    override fun getItemCount() = mKarten.size


    inner class ViewHolder(val itemViews: View) : RecyclerView.ViewHolder(itemViews) {
        var intent = Intent()
        init {
            itemViews.kvorlesebutton.setOnClickListener {
                // Je nachdem auf welcher Karte man den Button klickt, kommt man auf das jeweilige Video
                when(adapterPosition) {
                    0 -> {
                        intent = Intent(itemViews.context, VorlesenActivity::class.java)
                    }
                    1 ->{
                        intent = Intent(itemViews.context, VorlesenActivity1::class.java)
                    }
                    2 ->{
                        intent = Intent(itemViews.context, VorlesenActivity2::class.java)
                    }
                    3 ->{
                        intent = Intent(itemViews.context, VorlesenActivity3::class.java)
                    }
                    4 ->{
                        intent = Intent(itemViews.context, VorlesenActivity4::class.java)
                    }
                }
                itemViews.context.startActivity(intent)
            }
            itemViews.kplayerbutton.setOnClickListener {
                when(adapterPosition) {
                    0 -> {
                        intent = Intent(itemViews.context, AnimationActivity::class.java)
                    }
                    1 ->{
                        intent = Intent(itemViews.context, AnimationActivity1::class.java)
                    }
                    2 ->{
                        intent = Intent(itemViews.context, AnimationActivity2::class.java)
                    }
                    3 ->{
                        intent = Intent(itemViews.context, AnimationActivity3::class.java)
                    }
                    4 ->{
                        intent = Intent(itemViews.context, AnimationActivity4::class.java)
                    }
                }
                itemViews.context.startActivity(intent)
            }
        }
    }
}

