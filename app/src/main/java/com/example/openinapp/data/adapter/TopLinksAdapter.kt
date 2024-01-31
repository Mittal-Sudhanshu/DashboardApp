package com.example.openinapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.openinapp.R
import com.example.openinapp.data.models.TopLink

class TopLinksAdapter:RecyclerView.Adapter<TopLinksAdapter.MyViewHolder>() {
    private var data=ArrayList<TopLink>()
    fun setData(items:ArrayList<TopLink>){
        this.data=items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.links_view_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        if(data.size>4)
                return 4
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currItem= data[position]
        holder.title.text=currItem.title
        holder.date.text=currItem.createdAt
        holder.noClicks.text=currItem.totalClicks.toString()
        holder.link.text=currItem.webLink
    }
    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById<TextView>(R.id.title)
        var date: TextView = itemView.findViewById<TextView>(R.id.date)
        var noClicks: TextView = itemView.findViewById<TextView>(R.id.noClicks)
        var link : TextView =itemView.findViewById<TextView>(R.id.link)
    }

}