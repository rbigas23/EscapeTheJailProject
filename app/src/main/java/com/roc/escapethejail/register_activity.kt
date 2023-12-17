package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class register_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        findViewById<Button>(R.id.register_here).setOnClickListener {
            val intent = Intent(this, log_in_activity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.register_deploy).setOnClickListener {
            val intent = Intent(this, log_in_activity::class.java)
            startActivity(intent)
        }

    }
}