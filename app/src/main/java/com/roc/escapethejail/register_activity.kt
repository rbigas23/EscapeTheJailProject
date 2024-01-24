package com.roc.escapethejail

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            val db = jail_db(this, "users",  null, 1).writableDatabase
            val name = findViewById<EditText>(R.id.register_user_name).toString();
            val cv = ContentValues()

            cv.put("USER", name)
            cv.put("PASS", findViewById<EditText>(R.id.register_password).toString())
            cv.put("EMAIL", findViewById<EditText>(R.id.register_mail).toString())
            cv.put("SCORE", "0")

            Toast.makeText(
                this,
                if (db.insert(
                        "users",
                        null,
                        cv
                    ) == -1L
                ) "user $name was successfully registered" else "couldn't register $name",
                Toast.LENGTH_SHORT
            ).show()

            db.close()

            startActivity(Intent(this, log_in_activity::class.java)).apply {}
        }
    }
}