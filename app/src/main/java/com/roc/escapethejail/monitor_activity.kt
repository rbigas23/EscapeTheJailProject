package com.roc.escapethejail

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class monitor_activity : AppCompatActivity()
{
    lateinit var amount_of_users_registered : TextView
    lateinit var info_button : Button
    lateinit var refresh_button : Button
    var once : Boolean = false
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monitor)

        amount_of_users_registered = findViewById<TextView>(R.id.monitor_users_registered)
        info_button = findViewById<Button>(R.id.monitor_info)
        refresh_button = findViewById<Button>(R.id.monitor_refresh)

        info_button.setOnClickListener() { utils.send_toast("This data is collected when logged in, it's used to show activity to the public", this); }
        refresh_button.setOnClickListener() { refresh_gui_count()  }

        if (!once)
        {
            refresh_gui_count()
            once = true
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun refresh_gui_count() { amount_of_users_registered.setText(refresh_count().toString())}

    @RequiresApi(Build.VERSION_CODES.O)
    fun refresh_count(count: Long = 0L): Long
    {
        val oneMonthAgo = LocalDate.now().minusMonths(1)
        val oneMonthAgoFormatted = oneMonthAgo.format(DateTimeFormatter.ISO_LOCAL_DATE)

        val db = jail_db(this, "sessions", null, 1).writableDatabase
        var total_sessions = 0L

        db.rawQuery(
            "SELECT SESSION_COUNT FROM sessions WHERE DATE_ADDED >= ?",
            arrayOf(oneMonthAgoFormatted)
        ).use { cursor ->
            while (cursor.moveToNext())
                total_sessions += cursor.getLong(cursor.getColumnIndexOrThrow("SESSION_COUNT"))
        }

        return count + total_sessions
    }

}