package com.example.androidshowcase.ui.insidelibrary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidshowcase.R
import com.example.androidshowcase.data.componentsToClasses
import com.example.androidshowcase.database.ShowcaseDatabase
import com.example.androidshowcase.database.entities.Component
import com.example.androidshowcase.databinding.ActivityLibraryComponentsBinding
import com.example.androidshowcase.ui.ComponentActivity
import com.example.androidshowcase.ui.notadded.ComponentNotAddedActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.reflect.full.createInstance

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
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibraryComponentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.context = this

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.components)

        libraryName = intent.getStringExtra(LIBRARY_NAME)

        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = ComponentsRecyclerAdapter()

        val showcaseDatabase = ShowcaseDatabase.getInstance(this)
        var components: List<Component> = emptyList()
        GlobalScope.launch {
            val componentsDao = showcaseDatabase.getComponentsDao()
            components = componentsDao.getAllComponents()

            adapter.setData(components)
            adapter.itemClickedListener = { component ->
                run {
                    try {
                        val componentActivity = componentsToClasses[component]?.let { Class.forName(it).kotlin }
                        ((componentActivity?.createInstance()) as ComponentActivity).start(context)
                    } catch (e: Exception) {
                        ComponentNotAddedActivity.start(context, component)
                    }
                }
            }
            binding.recyclerViewComponents.layoutManager = LinearLayoutManager(context)
            binding.recyclerViewComponents.adapter = adapter
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}