package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class settings_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        findViewById<Button>(R.id.return_settings).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}