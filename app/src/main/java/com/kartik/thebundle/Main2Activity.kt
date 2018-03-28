package com.kartik.thebundle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.MenuItem


class Main2Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = Main2Activity::class.java.canonicalName
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        getMenuInflater().inflate( R.menu.search, menu)

        val menuItem:MenuItem = menu.findItem(R.id.action_search)
        val searchView:SearchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("Query", query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("Query2", newText)

                return true
            }

        })

        return true
    }

}
