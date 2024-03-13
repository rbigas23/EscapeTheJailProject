package com.roc.escapethejail

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast

object utils
{
    fun send_toast(message: String, context : Context)
    {
        val toast = Toast.makeText(context, message, Toast.LENGTH_LONG)
        toast.view = LayoutInflater.from(context).inflate(R.layout.escape_the_jail_custom_toast, null)
        toast.show()
    }
}