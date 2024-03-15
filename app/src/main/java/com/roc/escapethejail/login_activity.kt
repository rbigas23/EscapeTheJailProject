package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.login_here_button).setOnClickListener()
        {startActivity(Intent(this, register_activity::class.java)).apply {}}

        findViewById<Button>(R.id.login_deploy).setOnClickListener()
        {
            var user = findViewById<EditText>(R.id.login_user).text.toString()

            if (jail_db(this, "users",  null, 1).readableDatabase.rawQuery("SELECT PASS FROM users WHERE USER LIKE '" + user + "'", null).getString(0) == findViewById<EditText>(R.id.login_password).text.toString())
            {
                utils.send_toast("Logging on $user..", this)
                startActivity(Intent(this, social_activity::class.java)).apply {}
            }
        }
    }
}