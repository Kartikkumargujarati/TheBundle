package com.kartik.thebundle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->

            startActivity(Intent(this, Main2Activity::class.java))

        }
    }
}
