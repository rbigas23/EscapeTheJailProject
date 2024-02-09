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

        findViewById<Button>(R.id.return_social).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.foldable_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.foldable_menu_home->{startActivity(Intent(this, core_activity::class.java))}
            R.id.foldable_menu_settings->{startActivity(Intent(this, settings_activity::class.java))}
            R.id.foldable_menu_social->{startActivity(Intent(this, social_activity::class.java))}
        }

        return super.onOptionsItemSelected(item)
    }
}