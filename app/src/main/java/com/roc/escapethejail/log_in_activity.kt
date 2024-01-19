package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
class log_in_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.here_login).setOnClickListener()
        {startActivity(Intent(this, register_activity::class.java)).apply {}}

        findViewById<Button>(R.id.login_deploy).setOnClickListener()
        {startActivity(Intent(this, social_activity::class.java)).apply {}}

    }
}