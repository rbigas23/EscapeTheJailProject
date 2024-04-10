package com.roc.escapethejail

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

enum class login_validation
{
    pass,
    email,
    both,
    none
}
class register_activity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        findViewById<Button>(R.id.register_here).setOnClickListener()
        {startActivity(Intent(this, login_activity::class.java)).apply {}}

        findViewById<Button>(R.id.register_deploy).setOnClickListener()
        {
            val pass = findViewById<EditText>(R.id.register_password).text.toString()
            val email = findViewById<EditText>(R.id.register_mail).text.toString()

            val what_failed: login_validation? = is_valid_session(pass, email)

            var password_valid_when = "( 1 Upper letter, 1 Lower letter and 6 numbers minimum )"

            if (what_failed == login_validation.none)
            {
                var db = jail_db(this, "users",  null, 1).writableDatabase
                val name = findViewById<EditText>(R.id.register_user).text.toString()

                var cv = ContentValues()

                cv.put("USER", name)
                cv.put("PASSWORD", pass)
                cv.put("EMAIL", email)
                cv.put("SCORE", "0")

                var success = (db.insert("users", null, cv) != -1L)

                if (success)
                {
                    val cursor = db.rawQuery("SELECT MAX(ID) FROM users LIMIT 1;", null)
                    var last_id = 0L

                    if (cursor != null && cursor.moveToFirst())
                    {
                        last_id = cursor.getLong(0)
                        cursor.close()
                    }

                    db = jail_db(this, "sessions",  null, 1).writableDatabase

                    cv = ContentValues()

                    cv.put("SESSION_COUNT", "0")
                    cv.put("DATE_ADDED", utils.get_current_date())
                    cv.put("USER_ID", last_id)

                    success = (db.insert("sessions", null, cv) != -1L)

                    if (success)
                    {
                        startActivity(Intent(this, login_activity::class.java)).apply {}
                        user_globals.logged_in = true
                    }
                }

                utils.send_toast(if (success) "User $name was successfully registered" else "Couldn't register $name", this)

                db.close()
            }
            else utils.send_toast(if (what_failed == login_validation.pass) "Password is invalid $password_valid_when" else if (what_failed == login_validation.email) "Email is invalid" else "Both password $password_valid_when and email are invalid",this)
        }
    }

    fun is_valid(text : String, pattern : String): Boolean { return Regex(pattern).matches(text) }

    fun is_valid_session(password: String, email: String): login_validation
    {
        val pass_valid = is_valid(password, "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d.*\\d.*\\d.*\\d.*\\d).{8,}|(?=.*[A-Z])(?=.*[a-z])(?=.*\\d.*\\d.*[a-zA-Z].*\\d.*\\d).{8,}")
        val email_valid = is_valid(email, ".+\\@.+\\..+")

        //check what is wrong
        return when
        {
            !pass_valid && !email_valid -> login_validation.both
            !pass_valid -> login_validation.pass
            !email_valid -> login_validation.email
            else -> login_validation.none
        }
    }}