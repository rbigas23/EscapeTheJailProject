package com.roc.escapethejail;

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class player_adapter(private val players : ArrayList<player>): RecyclerView.Adapter<player_adapter.ViewHolder>()
{
    lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_player_list, parent, false)) }

    var on_item_click : ((player) -> Unit)? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name_text_view  : TextView = itemView.findViewById(R.id.item_player_name)
        val score_text_view : TextView = itemView.findViewById(R.id.item_player_score)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val player = players[position]

        holder.score_text_view.text = player.score
        holder.name_text_view.text = player.name

        holder.itemView.setOnClickListener() { on_item_click?.invoke(player) }
    }

    override fun getItemCount(): Int { return players.size }

}