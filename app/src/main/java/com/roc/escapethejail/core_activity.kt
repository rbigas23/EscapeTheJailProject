package com.roc.escapethejail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class core_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core)

        val start = findViewById<Button>(R.id.start)
        start.setOnClickListener {
            val intent = Intent(this, core_activity::class.java)  // CAMBIAR LA CLASE
            startActivity(intent)
        }

        val social = findViewById<ImageButton>(R.id.social)
        social.setOnClickListener {
            val intent = Intent(this, social_activity::class.java)
            startActivity(intent)
        }

        val settings = findViewById<ImageButton>(R.id.settings)
        settings.setOnClickListener {
            val intent = Intent(this, core_activity::class.java)  // CAMBIAR LA CLASE
            startActivity(intent)
        }

        val leader_boards = findViewById<ImageButton>(R.id.leader_boards)
        leader_boards.setOnClickListener {
            val intent = Intent(this, core_activity::class.java)  // CAMBIAR LA CLASE
            startActivity(intent)
        }
    }
}
