package com.example.androidshowcase.ui.librarieslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidshowcase.databinding.ActivityLibrariesBinding
import com.example.androidshowcase.ui.insidelibrary.LibraryComponentsActivity

class LibrariesActivity : AppCompatActivity() {
    private lateinit var adapter: LibrariesRecyclerAdapter

    private lateinit var binding: ActivityLibrariesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLibrariesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = LibrariesRecyclerAdapter()
        adapter.itemClickedListener = {libraryName ->
            LibraryComponentsActivity.start(this, libraryName)
        }
        binding.recyclerViewLibraries.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewLibraries.adapter = adapter
    }
}