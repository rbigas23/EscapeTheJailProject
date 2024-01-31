package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class log_in_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.here_login).setOnClickListener()
        {startActivity(Intent(this, register_activity::class.java)).apply {}}

        findViewById<Button>(R.id.login_deploy).setOnClickListener()
        {

            val db = jail_db(this, "users",  null, 1).readableDatabase
            val users = db.rawQuery("SELECT * FROM users", null)

            var user = findViewById<EditText>(R.id.login_user_name).text.toString()
            var password = findViewById<EditText>(R.id.login_password).text.toString()

            /*
            6 min
            1 may
            2 num
             */
            if (users.moveToFirst())
            {
                do
                {
                    if (user == users.getString(1) && password == users.getString(2))
                    {
                        Toast.makeText(this, "Logging on " + user + "..", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, social_activity::class.java)).apply {}
                        break
                    }
                }
                while (users.moveToNext())
            }

            users.close()
        }
    }
}