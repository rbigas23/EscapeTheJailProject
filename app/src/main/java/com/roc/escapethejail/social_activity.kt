package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class social_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // Aqui también definimos todito dentro del onCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social)

        findViewById<Button>(R.id.add_friend_button).setOnClickListener { // Esto es otro listener más para ir a add_friend
            val intent = Intent(this, add_friend_activity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.friend_list_button).setOnClickListener {
            val intent = Intent(this, friend_list_activity::class.java)
            startActivity(intent)
        }

        // Esta siguiente línea es lo del return. Basicamente le estoy diciento que el return sea como apretar
        // la flecha de back del movil. Lo bueno es que como estamos iniciando actividades en vez de mostrar el
        // contenido y ya, la flecha de tirar para atrás del móvil funciona "nativamente", y solo queda implementar
        // el return, como hemos hecho aquií debajo:

        findViewById<Button>(R.id.return_social).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }


}