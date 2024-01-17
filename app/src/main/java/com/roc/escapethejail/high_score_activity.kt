package com.roc.escapethejail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class high_score_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.high_score)

        findViewById<Button>(R.id.return_highscore).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }
}