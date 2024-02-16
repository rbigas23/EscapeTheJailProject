package com.roc.escapethejail;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class player_adapter(private val playerList: ArrayList<player>): RecyclerView.Adapter<player_adapter.ViewHolder>() {

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_player_list, parent, false)
        return ViewHolder(itemView)
    }

    var onItemClick: ((player) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val scoreTextView: TextView = itemView.findViewById(R.id.score)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val player = playerList[position]

        holder.scoreTextView.text = player.score
        holder.nameTextView.text = player.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(player)
        }

    }

    override fun getItemCount(): Int {
        return playerList.size
    }

}