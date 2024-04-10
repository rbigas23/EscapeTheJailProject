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
    lateinit var amount_of_users_registered : String
    var once : Boolean = false
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monitor)

        amount_of_users_registered = findViewById<TextView>(R.id.monitor_users_registered).text.toString()

        if (!once)
        {
            amount_of_users_registered = refresh_count(amount_of_users_registered.toLong()).toString()
            once = true
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refresh_count(count : Long) : Long
    {
        val last_month = LocalDate.now().minusMonths(1)

        var db = jail_db(this, "sessions",  null, 1).writableDatabase

        val cursor = db.rawQuery("SELECT SESSION_COUNT from sessions WHERE DATE_ADDED >= date($last_month.format(DateTimeFormatter.ofPattern(\"yyyy-MM-dd\")))", null)

        var total_sessions = 0L

        do total_sessions += cursor.getLong(0)
        while (cursor.moveToNext())

        cursor.close()

        return total_sessions
    }
}