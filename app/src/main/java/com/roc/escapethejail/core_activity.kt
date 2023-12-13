package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class core_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core)

        val start = findViewById<Button>(R.id.start)
        start.setOnClickListener{
            setContentView(R.layout.levels)
        }

        val social = findViewById<ImageButton>(R.id.social)
        social.setOnClickListener {
            setContentView(R.layout.social)
        }

        val settings = findViewById<ImageButton>(R.id.settings)
        settings.setOnClickListener {
            setContentView(R.layout.settings)
        }

        val leader_boards = findViewById<ImageButton>(R.id.leader_boards)
        leader_boards.setOnClickListener {
            setContentView(R.layout.leaderboards)
        }

    }
}