package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.numberprogressbar.NumberProgressBar
import com.daimajia.numberprogressbar.OnProgressBarListener
import com.example.androidshowcase.R
import java.util.*

class NumberProgressBarActivity : AppCompatActivity(),OnProgressBarListener {
    private  val componentName = "NumberProgressBar"

    lateinit var bnp:NumberProgressBar
    lateinit var rpb:NumberProgressBar
    private lateinit var timer:Timer

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, NumberProgressBarActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_progress_bar)
        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bnp = findViewById<NumberProgressBar>(R.id.number_progress_bar)
        rpb = findViewById<NumberProgressBar>(R.id.number_progress_bar_red)
        bnp.setOnProgressBarListener(this)
        rpb.setOnProgressBarListener(this)
        timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    bnp.incrementProgressBy(1)
                    rpb.incrementProgressBy(1)
                }
            }
        }, 1000, 100)
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onProgressChange(current: Int, max: Int) {
        if(current == max) {
            Toast.makeText(applicationContext, getString(R.string.finished), Toast.LENGTH_SHORT).show()
            bnp.progress = 0
            rpb.progress = 0
        }
    }
}