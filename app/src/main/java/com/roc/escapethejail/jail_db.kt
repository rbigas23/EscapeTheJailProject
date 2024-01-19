package com.roc.escapethejail

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class jail_db (context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version)
{
    private val user_table = "CREATE TABLE users" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "USER TEXT," +
            "PASSWORD TEXT," +
            "EMAIL TEXT," +
            "SCORE INT)"
    override fun onCreate(database: SQLiteDatabase?) { database?.execSQL(user_table)}

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        TODO("Not yet implemented")
    }

    fun insertData(name: String, pass: String, email: String): Long
    {
        val db = writableDatabase

        val cv = ContentValues()
        cv.put("USER", name)
        cv.put("PASS", pass)
        cv.put("EMAIL", email)
        cv.put("SCORE", "0")

        val result = db.insert("users", null, cv)

        db.close()

        return result
    }
}