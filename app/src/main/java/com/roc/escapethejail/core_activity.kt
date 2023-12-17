package com.roc.escapethejail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class core_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {  // Dentro del onCreate definimos los listeners
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core)

        findViewById<Button>(R.id.start).setOnClickListener {//Buscas el botón por id y defines un listener
            val intent = Intent(this, levels_activity::class.java) // Creas un intent con el contexto de esta clase
            startActivity(intent)                                               // y la actividad que vas a abrir al apretar el boton
        } // Me acabo de dar cuenta de que la variable no es necesaria, se puede poner dentro directamente

        findViewById<ImageButton>(R.id.social).setOnClickListener {
            val intent = Intent(this, social_activity::class.java)  // Y bueno vas metiendo todos los listeners que quieras
            startActivity(intent)
        } // Mirate la social_activity que ahí te explico como se hace lo del return y tal

        findViewById<ImageButton>(R.id.settings).setOnClickListener {
            val intent = Intent(this, settings_activity::class.java)
            startActivity(intent)
        }

        findViewById<ImageButton>(R.id.leader_boards).setOnClickListener {
            val intent = Intent(this, leader_boards_activity::class.java)
            startActivity(intent)
        }
    }
}
