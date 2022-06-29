package com.example.filterablerecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var dataList: MutableList<Modal> = ArrayList()
    private lateinit var tempArrayList : ArrayList<Modal>
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         recyclerView = findViewById(R.id.recyclerView)


        dataList.add(Modal(R.drawable.alert, " Alert Dialog"))
        dataList.add(Modal(R.drawable.lifecycle, "Activity LifeCycle Demo"))
        dataList.add(Modal(R.drawable.calendar, "Date & Time Piker Demo "))
        dataList.add(Modal(R.drawable.seekbar, "Seekbar"))
        dataList.add(Modal(R.drawable.rating, "Rating Bar"))
        dataList.add(Modal(R.drawable.intent, "Intent (Implicit & Explicit)"))
        dataList.add(Modal(R.drawable.checkbox, "Checkbox"))
        dataList.add(Modal(R.drawable.switchicon, "Switch"))
        dataList.add(Modal(R.drawable.alert, " Alert Dialog"))
        dataList.add(Modal(R.drawable.lifecycle, "Activity LifeCycle Demo"))
        dataList.add(Modal(R.drawable.calendar, "Date & Time Piker Demo "))
        dataList.add(Modal(R.drawable.seekbar, "Seekbar"))
        dataList.add(Modal(R.drawable.rating, "Rating Bar"))
        dataList.add(Modal(R.drawable.intent, "Intent (Implicit & Explicit)"))
        dataList.add(Modal(R.drawable.checkbox, "Checkbox"))
        dataList.add(Modal(R.drawable.switchicon, "Switch"))
        dataList.add(Modal(R.drawable.alert, " Alert Dialog"))
        dataList.add(Modal(R.drawable.lifecycle, "Activity LifeCycle Demo"))
        dataList.add(Modal(R.drawable.calendar, "Date & Time Piker Demo "))
        dataList.add(Modal(R.drawable.seekbar, "Seekbar"))
        dataList.add(Modal(R.drawable.rating, "Rating Bar"))
        dataList.add(Modal(R.drawable.intent, "Intent (Implicit & Explicit)"))
        dataList.add(Modal(R.drawable.checkbox, "Checkbox"))
        dataList.add(Modal(R.drawable.switchicon, "Switch"))

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(this , dataList)
        recyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu , menu)
        val item = menu?.findItem(R.id.action_search)
        val search = item!!.actionView as SearchView
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }


}