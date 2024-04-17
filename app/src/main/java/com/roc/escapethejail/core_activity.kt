package com.roc.escapethejail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
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
        {startActivity(Intent(this, if (user_globals.logged_in) social_activity::class.java else login_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_settings).setOnClickListener()
        {startActivity(Intent(this, settings_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_leader_boards).setOnClickListener()
        {startActivity(Intent(this, leader_boards_activity::class.java)).apply {}}

        findViewById<ImageButton>(R.id.core_monitoring).setOnClickListener()
        {startActivity(Intent(this, monitor_activity::class.java)).apply {}}

    }
}
