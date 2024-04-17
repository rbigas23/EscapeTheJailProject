package com.roc.escapethejail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class monitor_activity : AppCompatActivity()
{
    var amount_of_users_registered : String = ""
    var once : Boolean = false
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monitor)

        amount_of_users_registered = findViewById<TextView>(R.id.monitor_users_registered).text.toString()

        if (!once)
        {
            amount_of_users_registered = refresh_count().toString()
            once = true
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refresh_count(count : Long = 0L) : Long
    {
        utils.send_toast("entered refresh", this);
        val last_month = LocalDate.now().minusMonths(1)
        val last_month_formatted = last_month.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))

        val db = jail_db(this, "sessions", null, 1).writableDatabase
        var total_sessions = 0L

        db.rawQuery(
            "SELECT SESSION_COUNT FROM sessions WHERE DATE_ADDED >= ?",
            arrayOf(last_month_formatted)
        ).use { cursor ->
            if (cursor.moveToFirst())
            {
                do total_sessions += cursor.getLong(0)
                while (cursor.moveToNext())
            }
        }
        utils.send_toast("returning refresh", this);

        return count + total_sessions
    }
}