package com.example.androidshowcase.ui.libraries.imageView

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity

class CircleImageViewActivity : AppCompatActivity(), ComponentActivity {

    private val componentName = "CircleImageView"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle_image_view)

        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun start(context: Context) {
        val intent = Intent(context, CircleImageViewActivity::class.java)
        context.startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}