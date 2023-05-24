package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent.artistactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R

class SuggestforyouAdapter (private val dataList: ArrayList<SuggestDataModel>): RecyclerView.Adapter<SuggestforyouAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.suggestforyou_list_item,
            parent,false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=dataList[position]
        //holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
       // val titleImage: ImageView =itemView.findViewById(R.id.images)
        val tvHeading: TextView =itemView.findViewById(R.id.heading)

    }


}

