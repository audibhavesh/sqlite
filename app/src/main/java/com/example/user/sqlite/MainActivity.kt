package com.example.user.sqlite

import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var db:DatabaseHelper
    lateinit var listuser:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db= DatabaseHelper(this)

    }
    fun ListViewData()
    {
           listuser=db.allusers() as ArrayList<User>
           val adapter=ListAdapter(this,listuser,id,name,age)
            userdata.adapter=adapter

    }
    fun add(view: View)
    {

        val user=User()
        user.id =id.text.toString().trim().toInt()
        user.name=name.text.toString().trim()
        user.age=age.text.toString().trim().toInt()
        db.add(user)
        ListViewData()

    }
    fun update(view: View)
    {
        val user=User()
        user.id =id.text.toString().trim().toInt()
        user.name=name.text.toString().trim()
        user.age=age.text.toString().trim().toInt()
        db.update(user)
        ListViewData()

    } fun delete(view: View)
    {
        val user=User()
        user.id =id.text.toString().trim().toInt()
        db.delete(user)
        ListViewData()
    }
}
