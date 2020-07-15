package com.example.androidshowcase.ui.insidelibrary

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidshowcase.R
import com.example.androidshowcase.data.librariesComponentsList
import com.example.androidshowcase.data.librariesNameList
import com.example.androidshowcase.databinding.ActivityLibraryComponentsBinding
import com.example.androidshowcase.ui.notadded.ComponentNotAddedActivity

class LibraryComponentsActivity : AppCompatActivity() {

    companion object {
        private const val LIBRARY_POSITION = "LIBRARY_POSITION"

        fun start(context: Context, position: Int) {
            val intent = Intent(context, LibraryComponentsActivity::class.java)
            intent.putExtra(LIBRARY_POSITION, position)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityLibraryComponentsBinding
    private lateinit var adapter: ComponentsRecyclerAdapter
    private var libraryId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.components)

        libraryId = intent.getIntExtra(LIBRARY_POSITION, -1)

        setupAdapter()
        binding.recyclerViewComponents.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewComponents.adapter = adapter
    }

    private fun setupAdapter() {
        adapter = ComponentsRecyclerAdapter()
        adapter.setData(librariesComponentsList[libraryId])
        adapter.itemClickedListener = { position ->
            when(librariesNameList[libraryId]) {
                "Material" -> {
                    when(librariesComponentsList[libraryId][position]) {

                        else -> ComponentNotAddedActivity.start(this)
                    }
                }
                else -> ComponentNotAddedActivity.start(this)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}