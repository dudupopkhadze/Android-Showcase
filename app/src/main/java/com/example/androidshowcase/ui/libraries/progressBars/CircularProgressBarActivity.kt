package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity

class CircularProgressBarActivity : AppCompatActivity(), ComponentActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_progress_bar)
    }

    override fun start(context: Context) {
        val intent = Intent(context, CircularProgressBarActivity::class.java)
        context.startActivity(intent)
    }

}