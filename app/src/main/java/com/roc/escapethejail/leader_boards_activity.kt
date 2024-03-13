package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class leader_boards_activity : AppCompatActivity()
{
    private lateinit var player_adapter : player_adapter
    private lateinit var recicled_view : RecyclerView
    //lateinit var player_data : player
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leader_boards)
        //player_data = intent.getParcelableExtra("player")!!
    }

    override fun onStart()
    {
        super.onStart()
        val layout_manager = LinearLayoutManager(this)

        recicled_view = findViewById(R.id.rv_lista_partidas)
        recicled_view.layoutManager = layout_manager
        recicled_view.setHasFixedSize(true)

        player_adapter = player_adapter(get_players())

        recicled_view.adapter = player_adapter
    }

    fun get_players(): ArrayList<player>
    {
        val player_list: ArrayList<player> = ArrayList()

        val admin = jail_db(this, "users", null, 1)
        val db = admin.writableDatabase

        val reg = db.rawQuery("SELECT USER, SCORE FROM users", null)

        reg.moveToFirst()

        while (reg.moveToNext())
            player_list.add(player(reg.getString(0), reg.getString(1)))

        reg.close()

        return player_list
    }
}