package com.marc.examen2marcgutierrez.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.marc.examen2marcgutierrez.R
import com.marc.examen2marcgutierrez.model.Moble

class MobleAdapter (private val  list: List<Moble>) : RecyclerView.Adapter<MobleAdapter.MobleViewHolder>() {

    private lateinit var clickListener : onItemClickListener

    interface onItemClickListener {
        fun onItemClick(moble: Moble)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        clickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_moble, parent, false)
        return MobleViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: MobleViewHolder, position: Int) {
        val moble = list[position]
        holder.mobleName.text = moble.nom
        holder.moblePrice.text = moble.preu.toString()
    }

    override fun getItemCount(): Int = list.size

    class MobleViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val mobleName : TextView = itemView.findViewById(R.id.tvName)
        val moblePrice : TextView = itemView.findViewById(R.id.tvPrice)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(Moble(mobleName.text.toString(), moblePrice.text.toString().toInt()))
            }
        }

    }
}