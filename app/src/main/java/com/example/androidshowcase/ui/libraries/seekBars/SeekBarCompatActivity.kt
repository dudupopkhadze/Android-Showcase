package com.example.androidshowcase.ui.libraries.seekBars

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity

class SeekBarCompatActivity : AppCompatActivity(), ComponentActivity {
    private val componentName = "SeekBarCompat"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seek_bar_compat)

        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun start(context: Context) {
        val intent = Intent(context, SeekBarCompatActivity::class.java)
        context.startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}