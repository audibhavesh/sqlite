package com.example.user.sqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*

class DatabaseHelper(context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VER){
    override fun onCreate(db: SQLiteDatabase?) {
        val create_tabel_query="CREATE TABLE IF NOT EXISTS "+ TABLE_NAME+
                "("+ ID+" INTEGER PRIMARY KEY,"+ NAME+" TEXT,"+ AGE+" INTEGER)"
        db!!.execSQL(create_tabel_query)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val drop_tabel_query="DROP TABLE IF EXISTS "+ TABLE_NAME
        db!!.execSQL(drop_tabel_query)
    }
    fun allusers():List<User>{
        val listuser=ArrayList<User>()
        val fetch_query="SELECT * FROM "+ TABLE_NAME
        val db:SQLiteDatabase=this.writableDatabase
        val cursor:Cursor=db.rawQuery(fetch_query,null)
        if(cursor.moveToFirst())
        {
            do{
                val user=User()
                user.id=cursor.getInt(cursor.getColumnIndex(ID))
                user.name=cursor.getString(cursor.getColumnIndex(NAME))
                user.age=cursor.getInt(cursor.getColumnIndex(AGE))
                listuser.add(user)
            }while (cursor.moveToNext())
        }
        return listuser
    }
    fun add(user:User){
        val db:SQLiteDatabase=this.writableDatabase
        var values=ContentValues()
        values.put(ID,user.id)
        values.put(NAME,user.name)
        values.put(AGE,user.age)
        db.insert(TABLE_NAME,null,values)
    }
    fun update(user:User){
        val db:SQLiteDatabase=this.writableDatabase
        var values=ContentValues()
        values.put(ID,user.id)
        values.put(NAME,user.name)
        values.put(AGE,user.age)
        db.update(TABLE_NAME,values,"$ID=?", arrayOf(user.id.toString()))
    }
    fun delete(user:User){
        val db:SQLiteDatabase=this.writableDatabase
        db.delete(TABLE_NAME,"$ID=?", arrayOf(user.id.toString()))
    }
    companion object {
            private val DATABASE_VER=1
            private val DATABASE_NAME="data.db"
            private val TABLE_NAME="USER"
            private val ID="id"
            private val NAME="name"
            private val AGE="age"
    }
}