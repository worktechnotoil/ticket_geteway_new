package com.technotoil.ticket.ui.signIn

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R
import com.technotoil.ticket.ui.signIn.meargescreens.MeargeActivity


open class LoginDataAdapter(
    var data: ArrayList<MobileOTPResponseData>):
    RecyclerView.Adapter<LoginDataAdapter.LoginViewHolder>() {
    var context: Context? = null
    var selectedPosition = -1

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        val view: View
        val mInflater = LayoutInflater.from(context)
        view = mInflater.inflate(R.layout.loginemailresource, parent, false)
        return LoginViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.name.text = data!![position]?.fullName
        holder.email.text = data!![position]?.email

        holder.radiobutton.setChecked(position
                == selectedPosition);
        holder.radiobutton.setOnCheckedChangeListener(
            CompoundButton.OnCheckedChangeListener { compoundButton, b ->
                // check condition
                if (b) {
                    // When checked
                    // update selected position
                    selectedPosition = holder.adapterPosition

                }
            })

        holder.radiobutton.setOnClickListener { v ->
            val intent = Intent(v.context, MeargeActivity::class.java)
            v.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    class LoginViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var email: TextView
        var name: TextView
        var textName11: TextView
        var radiobutton: AppCompatRadioButton

        init {
            email = itemView.findViewById<View>(R.id.email) as TextView
            name = itemView.findViewById<View>(R.id.name) as TextView
            textName11 = itemView.findViewById<View>(R.id.textName11) as TextView
            radiobutton = itemView.findViewById<View>(R.id.radiobutton) as AppCompatRadioButton
        }
    }
}

