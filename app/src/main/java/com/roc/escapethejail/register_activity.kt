package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class register_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        findViewById<Button>(R.id.register_deploy).setOnClickListener {
            val intent = Intent(this, log_in_activity::class.java)  // Y bueno vas metiendo todos los listeners que quieras
            startActivity(intent)
        } // Mirate la social_activity que ahí te explico como se hace lo del return y tal

    }
}