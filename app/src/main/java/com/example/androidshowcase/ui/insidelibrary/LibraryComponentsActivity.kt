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
import com.example.androidshowcase.database.entities.ComponentMarking
import com.example.androidshowcase.database.entities.MarkingType
import com.example.androidshowcase.databinding.ActivityLibraryComponentsBinding
import com.example.androidshowcase.ui.notadded.ComponentNotAddedActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        setupRecycler()

    }

    private fun setupRecycler() {
        val showcaseDatabase = ShowcaseDatabase.getInstance(this)
        val componentsDao = showcaseDatabase.getComponentsDao()
        val componentMarkingsDao = showcaseDatabase.getComponentMarkingsDao()
        val markingTypesDao = showcaseDatabase.getMarkingTypesDao()

        binding.recyclerViewComponents.layoutManager = LinearLayoutManager(context)
        adapter = ComponentsRecyclerAdapter()
        binding.recyclerViewComponents.adapter = adapter

        adapter.onCheckedListener = { button, isChecked ->
            GlobalScope.launch {
                val componentName = button.tag as String
                val component = componentsDao.getComponentByName(componentName)
                val pinMarking = markingTypesDao.getMarkingTypeByName("pin")
                if (isChecked) {
                    componentMarkingsDao.insertComponentMarking(ComponentMarking(0, component.id, pinMarking.id))
                } else {
                    val componentMarking = componentMarkingsDao.getComponentMarkingByComponentId(component.id)
                    componentMarkingsDao.deleteComponentMarking(componentMarking)
                }
                runOnUiThread {
                    button.tag = null
                    setupAdapter()
                }
            }
        }

        adapter.itemClickedListener = { component ->
            run {
                try {
                    if (!componentsToClasses.containsKey(component)) {
                        throw Exception("Component Not Added")
                    }
                    componentsToClasses[component]?.start(context)
                } catch (e: Exception) {
                    ComponentNotAddedActivity.start(context, component)
                }
            }
        }

        setupAdapter()
    }

    private fun setupAdapter() {
        val showcaseDatabase = ShowcaseDatabase.getInstance(this)
        val componentsDao = showcaseDatabase.getComponentsDao()
        val componentMarkingsDao = showcaseDatabase.getComponentMarkingsDao()
        val markingTypesDao = showcaseDatabase.getMarkingTypesDao()

        GlobalScope.launch {
            val pinnedComponents: List<Component> = componentsDao.getAllPinnedComponentsByLibraryName(libraryName!!)
            val notPinnedComponents: List<Component> = componentsDao.getAllNotPinnedComponentsByLibraryName(libraryName!!)
            val components : ArrayList<Component> = arrayListOf()
            pinnedComponents.forEach { component -> components.add(component) }
            notPinnedComponents.forEach { component -> components.add(component) }
            val markings: List<ComponentMarking> = componentMarkingsDao.getAllComponentMarkings()
            val markingTypes: List<MarkingType> = markingTypesDao.getAllMarkingTypes()

            runOnUiThread {
                adapter.setData(components, markings, markingTypes)
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