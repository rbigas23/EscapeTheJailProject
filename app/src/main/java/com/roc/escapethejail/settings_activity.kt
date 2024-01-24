package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton

class settings_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        findViewById<Button>(R.id.return_settings).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
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