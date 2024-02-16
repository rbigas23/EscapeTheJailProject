package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class leader_boards_activity : AppCompatActivity() {
    private lateinit var player_adapter: player_adapter
    private lateinit var recycledView: RecyclerView
    lateinit var player_data: player
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leader_boards)
        findViewById<Button>(R.id.return_leader_boards).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
//        player_data = intent.getParcelableExtra("player")!!

    }

    //Generar la vista después de cargar la lista de partidas
    override fun onStart() {
        super.onStart()
        val layoutManager = LinearLayoutManager(this)
        recycledView = findViewById(R.id.rv_lista_partidas)
        recycledView.layoutManager = layoutManager
        recycledView.setHasFixedSize(true)
        player_adapter = player_adapter(getPartidasList())
        recycledView.adapter = player_adapter
    }

    fun getPartidasList(): ArrayList<player> {

        //Array para almacenar las partidas
        val player_list: ArrayList<player> = ArrayList()

        //Acceso a la base de datos
        val admin = jail_db(this, "users", null, 1)
        val db = admin.writableDatabase

        //Obtención de registros
        val reg = db.rawQuery("SELECT USER, SCORE FROM users", null)

        //Declaración de variables para guardar los datos de la BD
        var name: String
        var score: String

        //Recorrer la BD y asignar cada registro a una variable
        reg.moveToFirst()
        while (reg.moveToNext()) {
            val name = reg.getString(0)
            val score = reg.getString(1)
            //Agregar variables con valores de la BD al Array que guarda las partidas
            player_list.add(player(score, name))
        }
        reg.close()

        return player_list
    }
}