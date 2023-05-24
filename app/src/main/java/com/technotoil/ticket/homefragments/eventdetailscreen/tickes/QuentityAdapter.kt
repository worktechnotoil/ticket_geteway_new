package com.technotoil.ticket.homefragments.eventdetailscreen.tickes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R


class QuentityAdapter(private val dataList: ArrayList<QuentityDataModel>): RecyclerView.Adapter<QuentityAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
       R.layout.quentity_item,
            parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=dataList[position]
        var count = 0
        var count2 = 0
        var count3 = 0

        holder.plus.setOnClickListener {
            count++
            holder.quentity.text = count.toString()
        }
        holder.minus.setOnClickListener {
            if (count==0){
            }else{
                count--
                holder.quentity.text = count.toString()
            }
        }

        holder.plus2.setOnClickListener {
            count2++
            holder.quentity2.text = count2.toString()
        }
        holder.minus2.setOnClickListener {
            if (count2==0){
            }else{
                count2--
                holder.quentity2.text = count2.toString()
            }
        }
        holder.plus3.setOnClickListener {
            count3++
            holder.quentity3.text = count3.toString()
        }
        holder.minus3.setOnClickListener {
            if (count3==0){
            }else{
                count3--
                holder.quentity3.text = count3.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        // val titleImage: ImageView =itemView.findViewById(R.id.images)
        val tvHeading: TextView =itemView.findViewById(R.id.heading)
        val minus: ImageView =itemView.findViewById(R.id.minus)
        val plus: ImageView =itemView.findViewById(R.id.plus)
        val quentity: TextView =itemView.findViewById(R.id.value)
        val minus2: ImageView =itemView.findViewById(R.id.minus2)
        val plus2: ImageView =itemView.findViewById(R.id.plus2)
        val quentity2: TextView =itemView.findViewById(R.id.value2)
        val minus3: ImageView =itemView.findViewById(R.id.minus3)
        val plus3: ImageView =itemView.findViewById(R.id.plus3)
        val quentity3: TextView =itemView.findViewById(R.id.value3)

    }


}

