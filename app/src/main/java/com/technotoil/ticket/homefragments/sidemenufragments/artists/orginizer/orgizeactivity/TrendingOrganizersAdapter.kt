package com.technotoil.ticket.homefragments.sidemenufragments.artists.orginizer.orgizeactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R

class TrendingOrganizersAdapter(private val dataList: ArrayList<OrginizerSuggestDataModel>):
    RecyclerView.Adapter<TrendingOrganizersAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.horizontal_list_item,
            parent,false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=dataList[position]
       // holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading

    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        //val titleImage: ImageView =itemView.findViewById(R.id.profile)
        val tvHeading: TextView =itemView.findViewById(R.id.name)

    }


}

