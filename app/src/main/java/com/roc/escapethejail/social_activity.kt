package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class social_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social)

        val return_social = findViewById<Button>(R.id.return_social)
        return_social.setOnClickListener {
            setContentView(R.layout.core)
        }

    }
}