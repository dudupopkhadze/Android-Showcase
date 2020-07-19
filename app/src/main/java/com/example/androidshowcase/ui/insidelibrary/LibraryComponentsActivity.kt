package com.example.androidshowcase.ui.insidelibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidshowcase.R
import com.example.androidshowcase.data.libraries
import com.example.androidshowcase.databinding.ActivityLibraryComponentsBinding
import com.example.androidshowcase.ui.libraries.material.button.MaterialButtonsActivity
import com.example.androidshowcase.ui.libraries.progressBars.CircularProgressBarActivity
import com.example.androidshowcase.ui.libraries.progressBars.NumberProgressBarActivity
import com.example.androidshowcase.ui.libraries.seekBars.DiscreteSeekBarActivity
import com.example.androidshowcase.ui.libraries.progressBars.SmoothProgressBarActivity
import com.example.androidshowcase.ui.notadded.ComponentNotAddedActivity

class LibraryComponentsActivity : AppCompatActivity() {

    companion object {
        private const val LIBRARY_NAME = "LIBRARY_POSITION"

        fun start(context: Context, libraryName: String) {
            val intent = Intent(context, LibraryComponentsActivity::class.java)
            intent.putExtra(LIBRARY_NAME, libraryName)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityLibraryComponentsBinding
    private lateinit var adapter: ComponentsRecyclerAdapter
    private var libraryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.components)

        libraryName = intent.getStringExtra(LIBRARY_NAME)

        setupAdapter()
        binding.recyclerViewComponents.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewComponents.adapter = adapter
    }

    private fun setupAdapter() {
        adapter = ComponentsRecyclerAdapter()
        adapter.setData(libraries[libraryName]!!)
        adapter.itemClickedListener = { component ->
            when (libraryName) {
                "Material" -> {
                    when (component) {
                        "Buttons" -> MaterialButtonsActivity.start(this)
                        else -> ComponentNotAddedActivity.start(this, component)
                    }
                }

                "Progress Bar" -> {
                    when (component) {
                        "SmoothProgressBar" -> SmoothProgressBarActivity.start(this)
                        "CircularProgressBar" -> CircularProgressBarActivity.start(this)
                        "NumberProgressBar" -> NumberProgressBarActivity.start(this)
                        else -> ComponentNotAddedActivity.start(this, component)
                    }
                }

                "Seek Bar" -> {
                    when (component) {
                        "DiscreteSeekBar" -> DiscreteSeekBarActivity.start(this)

                        else -> ComponentNotAddedActivity.start(this, component)
                    }
                }

                else -> ComponentNotAddedActivity.start(this, component)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}