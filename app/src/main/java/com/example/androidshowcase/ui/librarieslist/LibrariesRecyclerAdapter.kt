package com.example.androidshowcase.ui.librarieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshowcase.R
import com.example.androidshowcase.database.entities.Library

class LibrariesRecyclerAdapter(argLibraries : List<Library>) : RecyclerView.Adapter<LibrariesRecyclerAdapter.ViewHolder>() {

    var libraries :  List<Library> = argLibraries
    var itemClickedListener: ((libraryName: String) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_library_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return libraries.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val libraryName = itemView.findViewById<TextView>(R.id.library_name_text)

        init {
            itemView.setOnClickListener {
                itemClickedListener?.invoke(libraries[adapterPosition].name)
            }
        }

        fun bindData(position: Int) {
            libraryName.text = itemView.context.getString(R.string.library_name, libraries[position].name)
        }
    }

}
