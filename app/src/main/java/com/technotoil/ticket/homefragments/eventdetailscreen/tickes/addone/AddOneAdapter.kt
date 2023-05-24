package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R


class AddOneAdapter(private val dataList: ArrayList<AddOneDataModel>): RecyclerView.Adapter<AddOneAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.add_one_item,
            parent,false)
        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=dataList[position]
        holder.titleImage.setImageResource(currentItem.images)
        holder.tvHeading.text=currentItem.heading
        holder.price.text=currentItem.price

        holder.switchBox.setOnCheckedChangeListener { buttonView, isChecked ->
            holder.switchBox.visibility = View.VISIBLE
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
         val titleImage: ImageView =itemView.findViewById(R.id.images)
        val tvHeading: TextView =itemView.findViewById(R.id.heading)
        val switchBox: SwitchCompat =itemView.findViewById(R.id.customSwitch)
        val price: TextView =itemView.findViewById(R.id.price)
        val autoCompleteTextView: AutoCompleteTextView =itemView.findViewById(R.id.autoCompleteTextView)



    }


}

