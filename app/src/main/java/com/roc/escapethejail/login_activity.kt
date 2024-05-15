package com.roc.escapethejail

import android.content.ContentValues
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class login_activity : AppCompatActivity()
{
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        findViewById<Button>(R.id.login_here_button).setOnClickListener()
        {startActivity(Intent(this, register_activity::class.java)).apply {}}

        findViewById<Button>(R.id.login_deploy).setOnClickListener()
        {
            var db = jail_db(this, "users",  null, 1).writableDatabase

            val user = findViewById<EditText>(R.id.login_user).text.toString()

            var cursor = db.rawQuery("SELECT PASSWORD, ID FROM users WHERE USER LIKE ?", arrayOf(user))

            if (cursor.moveToFirst())
            {
                if (findViewById<EditText>(R.id.login_password).text.toString() == cursor.getString(0))
                {
                    utils.send_toast("Logging on $user..", this)
                    user_globals.logged_in = true

                    increment_session_count(cursor.getLong(1))

                    startActivity(Intent(this, social_activity::class.java))
                }
                else utils.send_toast("Password is incorrect", this)
            }
            else utils.send_toast("User not found", this)

            cursor.close()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun increment_session_count(user_id: Long)
    {
        var db = jail_db(this, "sessions",  null, 1).writableDatabase

        val current_date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)

        val cursor = db.rawQuery("SELECT SESSION_COUNT FROM sessions WHERE DATE_ADDED = ? AND USER_ID = ?",  arrayOf(current_date, user_id.toString()))

        if (cursor.moveToFirst())
        {
            val session_count = cursor.getInt(cursor.getColumnIndexOrThrow("SESSION_COUNT")) + 1
            val content_values = ContentValues().apply { put("SESSION_COUNT", session_count) }

            db.update("sessions", content_values,"DATE_ADDED = ? AND USER_ID = ?", arrayOf(current_date, user_id.toString()))
        }
        else
        {
            val content_values = ContentValues().apply {
                put("SESSION_COUNT", 1)
                put("DATE_ADDED", current_date)
                put("USER_ID", user_id)
            }
            db.insert("sessions", null, content_values)
        }

        cursor.close()
        db.close()
    }

}