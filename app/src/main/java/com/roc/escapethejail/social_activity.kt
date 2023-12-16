package com.roc.escapethejail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class social_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social)

        findViewById<Button>(R.id.add_friend_button).setOnClickListener {
            val intent = Intent(this, add_friend_activity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.friend_list_button).setOnClickListener {
            val intent = Intent(this, friend_list_activity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.return_social).setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }


}