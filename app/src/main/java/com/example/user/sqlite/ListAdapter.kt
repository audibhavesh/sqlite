package com.example.user.sqlite

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.list_row_layout.view.*

class ListAdapter(internal var activity: Activity,
                  internal var listuser:List<User>,
                  internal var userid:EditText,
                  internal var username:EditText,
                  internal var userage:EditText):BaseAdapter(){

    internal var inflater:LayoutInflater
    init {
        inflater=activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listrow:View
        listrow= inflater.inflate(R.layout.list_row_layout,null)
        listrow.user_row_data.text=listuser[position].toString()
        return listrow
    }

    override fun getItem(position: Int): Any {
        return listuser[position]
    }

    override fun getItemId(position: Int): Long {
        return  listuser[position].id.toLong()
    }

    override fun getCount(): Int {
        return listuser.size
    }


}