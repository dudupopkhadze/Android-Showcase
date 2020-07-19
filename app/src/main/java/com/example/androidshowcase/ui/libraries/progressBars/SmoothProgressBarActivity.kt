package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity


class SmoothProgressBarActivity : AppCompatActivity(), ComponentActivity {
    private val componentName = "SmoothProgressBar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smooth_progress_bar)
        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun start(context: Context) {
        val intent = Intent(context, SmoothProgressBarActivity::class.java)
        context.startActivity(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}