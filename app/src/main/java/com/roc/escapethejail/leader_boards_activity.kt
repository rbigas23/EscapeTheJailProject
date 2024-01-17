package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class leader_boards_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leader_boards)

        findViewById<TextView>(R.id.first_name_rbo).setOnClickListener ()
        {startActivity(Intent(this, high_score_activity::class.java))}

        findViewById<Button>(R.id.return_leader_boards).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}