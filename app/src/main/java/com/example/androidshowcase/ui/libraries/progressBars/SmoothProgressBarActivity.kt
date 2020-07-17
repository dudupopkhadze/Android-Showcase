package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidshowcase.R


class SmoothProgressBarActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SmoothProgressBarActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smooth_progress_bar)
    }
}