package com.roc.escapethejail

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Date

object utils
{
    fun send_toast(message: String, context : Context)
    {
        val toast = Toast(context)
        toast.setText(message)
        toast.duration = Toast.LENGTH_LONG
        toast.view = LayoutInflater.from(context).inflate(R.layout.escape_the_jail_custom_toast, null)
        toast.show()
    }

    fun get_current_date(): String { return SimpleDateFormat("dd/MM/yy").format(Date()) }
}