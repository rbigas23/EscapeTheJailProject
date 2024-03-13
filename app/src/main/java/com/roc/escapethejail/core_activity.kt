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

        findViewById<Button>(R.id.core_start).setOnClickListener()
        {startActivity(Intent(this, levels_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_social).setOnClickListener()
        {startActivity(Intent(this, login_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_settings).setOnClickListener()
        {startActivity(Intent(this, settings_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_leader_boards).setOnClickListener()
        {startActivity(Intent(this, leader_boards_activity::class.java)).apply {}}
    }
}
