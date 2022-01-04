package com.example.uts.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.R

class AdapterList(val ikanList : List<String>) : RecyclerView.Adapter<AdapterList.Myholder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: ): Myholder {
        val view: View = LayoutInflater.from(parent.context).inflatInte(R.layout.item_recyclerview, parent, false)

    return Myholder(view)
}
    override fun onBindViewHolder(holder: Myholder, position:Int ) {

    holder.tvNama.text = ikanList.get(position)
}

override fun getItemCount(): Int = ikanList.size

class Myholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNama : TextView = itemView.findViewById(R.id.tvNamaikan)

}

}