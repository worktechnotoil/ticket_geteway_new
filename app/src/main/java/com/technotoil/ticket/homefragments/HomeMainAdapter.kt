package com.technotoil.ticket.homefragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.Listener.Listener
import com.technotoil.ticket.R


class HomeMainAdapter(private val newsList: ArrayList<Homedata>, private val listener: Listener) :
    RecyclerView.Adapter<HomeMainAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent, false
        )
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeMainAdapter.MyViewHolder, position: Int) {
        val currentItem = newsList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ImageView = itemView.findViewById(R.id.images)
        val tvHeading: TextView = itemView.findViewById(R.id.heading)

        init {
            titleImage.setOnClickListener {
                listener.onItemClickListener(adapterPosition)
            }
        }

    }
}





