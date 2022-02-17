package com.example.ep_codev1.liste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_codev1.R
import kotlinx.android.synthetic.main.activity_itempriority.view.*

class ListeAdapter(val mListen : List<ListenItem>): RecyclerView.Adapter<ListeAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_itempriority, parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val liste = mListen[position]

        holder.itemListViews.ipueberschrift.text = liste.namel
        holder.itemListViews.ipicf.text = liste.icfl

    }

    override fun getItemCount() = mListen.size



    class ListViewHolder(val itemListViews: View) : RecyclerView.ViewHolder(itemListViews){
    }
}
