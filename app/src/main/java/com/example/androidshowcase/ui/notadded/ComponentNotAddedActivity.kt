package com.example.androidshowcase.ui.notadded

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.androidshowcase.R

class ComponentNotAddedActivity : AppCompatActivity() {

    companion object {
        private const val COMPONENT_NAME = "COMPONENT_NAME"

        fun start(context: Context, componentName: String) {
            val intent = Intent(context, ComponentNotAddedActivity::class.java)
            intent.putExtra(COMPONENT_NAME, componentName)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component_not_added)
        supportActionBar?.title = intent.getStringExtra(COMPONENT_NAME)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}