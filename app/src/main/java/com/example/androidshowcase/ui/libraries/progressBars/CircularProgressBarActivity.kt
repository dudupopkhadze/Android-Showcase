package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidshowcase.R
import fr.castorflex.android.circularprogressbar.CircularProgressBar
import fr.castorflex.android.circularprogressbar.CircularProgressDrawable

class CircularProgressBarActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val intent = Intent(context, CircularProgressBarActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_progress_bar)
    }
}