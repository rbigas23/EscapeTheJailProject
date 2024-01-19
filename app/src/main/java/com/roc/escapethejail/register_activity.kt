package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class register_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        findViewById<Button>(R.id.register_here).setOnClickListener()
        {startActivity(Intent(this, log_in_activity::class.java)).apply {}}

        findViewById<Button>(R.id.register_deploy).setOnClickListener()
        {
            val username = findViewById<EditText>(R.id.register_user_name).toString()
            val password = findViewById<EditText>(R.id.register_password).toString()
            val email = findViewById<EditText>(R.id.register_mail).toString()
            jail_db.ins
            startActivity(Intent(this, log_in_activity::class.java)).apply {}
        }

    }
}