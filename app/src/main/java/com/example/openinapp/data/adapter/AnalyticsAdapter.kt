package com.example.openinapp.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.openinapp.R
import com.example.openinapp.data.models.AnalData

class AnalyticsAdapter: RecyclerView.Adapter<AnalyticsAdapter.MyViewHolder>() {
    private var data= ArrayList<AnalData>()
//    fun setData(items: ArrayList<AnalData>){
//        this.data=items
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.top_view_vard, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.text1.text=data[position].text1
        holder.text2.text=data[position].text2
        if(data[position].image==4){
            holder.image.imageAlpha=(R.drawable.img_4)
        }else if(data[position].image==5){
            holder.image.imageAlpha=(R.drawable.img_5)
        }
    }

    fun setData(analData: ArrayList<AnalData>) {
        this.data=analData
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var text1: TextView = itemView.findViewById(R.id.text1)
        var text2: TextView = itemView.findViewById(R.id.text2)
        var image: ImageView= itemView.findViewById(R.id.icon)
    }
}