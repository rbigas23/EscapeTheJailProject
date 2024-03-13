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
        {startActivity(Intent(this, login_activity::class.java)).apply {}}

        findViewById<Button>(R.id.register_deploy).setOnClickListener()
        {
            val pass = findViewById<EditText>(R.id.register_password).text.toString()
            val email = findViewById<EditText>(R.id.register_mail).text.toString()

            if (is_valid_session(pass, email))
            {
                val db = jail_db(this, "users",  null, 1).writableDatabase
                val name = findViewById<EditText>(R.id.register_user).text.toString()

                val cv = ContentValues()

                cv.put("USER", name)
                cv.put("PASSWORD", pass)
                cv.put("EMAIL", email)
                cv.put("SCORE", "0")

                var success = (db.insert("users", null, cv) != -1L)

                if (success)
                    startActivity(Intent(this, login_activity::class.java)).apply {}

                Toast.makeText(this, if (success) "User $name was successfully registered" else "Couldn't register $name", Toast.LENGTH_SHORT).show()

                db.close()
            }
            else Toast.makeText(this, "Password needs to have 6 digit length, 1 capital letter and 2 numbers", Toast.LENGTH_SHORT).show()
        }
    }

    fun is_valid(text : String, pattern : String): Boolean { return Regex(pattern).matches(text) }
    fun is_valid_session(password : String, email : String) : Boolean { return is_valid(password, "\"(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d.*\\\\d.*\\\\d.*\\\\d.*\\\\d.*\\\\d).{8,}|(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d.*\\\\d.*[a-zA-Z].*\\\\d.*\\\\d).{8,}\"") && is_valid(email, ".+\\@.+\\..+") }
}