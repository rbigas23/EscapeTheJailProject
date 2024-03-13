package com.roc.escapethejail

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import android.widget.Toast

object utils
{
    fun send_toast(message: String, context : Context)
    {
        val layoutInflater = LayoutInflater.from(context)
        val layout = layoutInflater.inflate(R.layout.escape_the_jail_custom_toast, null)

        val textView = layout.findViewById<TextView>(R.id.textViewToastMessage)
        textView.text = message

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()

    }
}