package com.example.androidshowcase.ui.librarieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshowcase.R
import com.example.androidshowcase.data.libraries

class LibrariesRecyclerAdapter : RecyclerView.Adapter<LibrariesRecyclerAdapter.ViewHolder>() {

    var itemClickedListener: ((libraryName: String) -> Unit)? = null
    private val librariesNames = libraries.keys.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_library_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return librariesNames.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val libraryName = itemView.findViewById<TextView>(R.id.library_name_text)

        init {
            itemView.setOnClickListener {
                itemClickedListener?.invoke(librariesNames[adapterPosition])
            }
        }

        fun bindData(position: Int) {
            libraryName.text = itemView.context.getString(R.string.library_name, librariesNames[position])
        }
    }

}
