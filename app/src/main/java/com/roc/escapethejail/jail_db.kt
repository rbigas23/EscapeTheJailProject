package com.roc.escapethejail

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class jail_db(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version)
{

    private val user_table = "CREATE TABLE users" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "USER TEXT," +
            "PASSWORD TEXT," +
            "EMAIL TEXT," +
            "SCORE TEXT)"

    private val session_table = "CREATE TABLE sessions" +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "SESSION_COUNT INTEGER," +
            "DATE_ADDED TEXT," +
            "USER_ID INTEGER," +
            "FOREIGN KEY(USER_ID) REFERENCES users(ID))"

    override fun onCreate(database: SQLiteDatabase?)
    {
        database?.execSQL(user_table)
        database?.execSQL(session_table)
    }

    override fun onUpgrade(database: SQLiteDatabase?, oldVer: Int, newVer: Int)
    {
        if (oldVer < 2)
            database?.execSQL("INSERT INTO users VALUES ('1', 'admin', 'admin', 'admin@admin.com', '300000')")

    }
}
