package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class social_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social)

        findViewById<Button>(R.id.social_add_friends).setOnClickListener()
        {startActivity(Intent(this, add_friend_activity::class.java)).apply {}}

        findViewById<Button>(R.id.social_check_friends).setOnClickListener()
        {startActivity(Intent(this, friend_list_activity::class.java)).apply {}}
    }
}