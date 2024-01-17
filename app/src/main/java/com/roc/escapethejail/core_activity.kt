package com.roc.escapethejail

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class core_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core)

        findViewById<Button>(R.id.start).setOnClickListener()
        {startActivity(Intent(this, levels_activity::class.java))}

        findViewById<ImageButton>(R.id.social).setOnClickListener()
        {startActivity(Intent(this, register_activity::class.java))}

        findViewById<ImageButton>(R.id.settings).setOnClickListener()
        {startActivity(Intent(this, settings_activity::class.java))}

        findViewById<ImageButton>(R.id.leader_boards).setOnClickListener()
        {startActivity(Intent(this, leader_boards_activity::class.java))}
    }
}
