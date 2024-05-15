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
    lateinit var amount_of_users_registered : TextView
    var once : Boolean = false
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monitor)

        amount_of_users_registered = findViewById<TextView>(R.id.monitor_users_registered)

        if (!once)
        {
            amount_of_users_registered.setText(refresh_count().toString())
            once = true
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refresh_count(count: Long = 0L): Long
    {
        val oneMonthAgo = LocalDate.now().minusMonths(1)
        val oneMonthAgoFormatted = oneMonthAgo.format(DateTimeFormatter.ISO_LOCAL_DATE)

        val db = jail_db(this, "sessions", null, 1).writableDatabase
        var totalSessions = 0L

        db.rawQuery(
            "SELECT SESSION_COUNT FROM sessions WHERE DATE_ADDED >= ?",
            arrayOf(oneMonthAgoFormatted)
        ).use { cursor ->
            while (cursor.moveToNext())
                totalSessions += cursor.getLong(cursor.getColumnIndexOrThrow("SESSION_COUNT"))
        }

        utils.send_toast("returning refresh $count $totalSessions", this)

        return count + totalSessions
    }

}