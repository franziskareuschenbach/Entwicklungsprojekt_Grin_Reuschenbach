package com.example.ep_codev1.liste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ep_codev1.R
import kotlinx.android.synthetic.main.activity_itempriority.view.*

class ListAdapter(val mLists : List<ListItem>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_itempriority, parent,false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val list = mLists[position]

        holder.itemListViews.ipHeadline.text = list.namel
        holder.itemListViews.ipIcf.text = list.icfl

    }

    override fun getItemCount() = mLists.size



    class ListViewHolder(val itemListViews: View) : RecyclerView.ViewHolder(itemListViews){
    }
}
