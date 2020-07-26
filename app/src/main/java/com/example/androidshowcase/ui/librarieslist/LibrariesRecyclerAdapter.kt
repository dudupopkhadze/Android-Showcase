package com.example.androidshowcase.ui.librarieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshowcase.R
import com.example.androidshowcase.database.entities.Library
import com.example.androidshowcase.database.entities.LibraryMarking
import com.example.androidshowcase.database.entities.MarkingType

class LibrariesRecyclerAdapter : RecyclerView.Adapter<LibrariesRecyclerAdapter.ViewHolder>() {

    var markingTypes: List<MarkingType> = listOf()
    var markings: List<LibraryMarking> = listOf()
    var libraries: List<Library> = listOf()
    var itemClickedListener: ((libraryName: String) -> Unit)? = null
    var onCheckedListener: ((button: CompoundButton, isChecked: Boolean) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_library_cell, parent, false)
        return ViewHolder(view)
    }

    fun setData(argLibraries: List<Library>, argMarkings: List<LibraryMarking>, argMarkingTypes: List<MarkingType>) {
        libraries = argLibraries
        markings = argMarkings
        markingTypes = argMarkingTypes
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return libraries.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val libraryName = itemView.findViewById<TextView>(R.id.library_name_text)
        private val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)

        init {
            itemView.setOnClickListener {
                itemClickedListener?.invoke(libraries[adapterPosition].name)
            }
        }

        fun bindData(position: Int) {
            val libraryMarking = markings.find { marking -> marking.libraryId == libraries[position].id }
            val markingType = markingTypes.find { markingType -> markingType.id == libraryMarking?.markingId }
            checkBox.tag = libraries[position].name
            checkBox.setOnCheckedChangeListener(null)
            checkBox.isChecked = markingType?.literalValue.equals("pin")
            checkBox.setOnCheckedChangeListener(onCheckedListener)
            libraryName.text = itemView.context.getString(R.string.library_name, libraries[position].name)
        }
    }

}
