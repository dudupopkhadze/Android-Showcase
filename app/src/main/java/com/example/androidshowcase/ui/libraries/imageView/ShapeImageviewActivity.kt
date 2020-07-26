package com.example.androidshowcase.ui.libraries.imageView

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity

class ShapeImageviewActivity : AppCompatActivity(), ComponentActivity {
    private val componentName = "ShapeImageView"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_imageview)

        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun start(context: Context) {
        val intent = Intent(context, ShapeImageviewActivity::class.java)
        context.startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}