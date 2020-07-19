package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidshowcase.R


class SmoothProgressBarActivity : AppCompatActivity() {
    private  val componentName = "SmoothProgressBar"
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SmoothProgressBarActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smooth_progress_bar)
        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}