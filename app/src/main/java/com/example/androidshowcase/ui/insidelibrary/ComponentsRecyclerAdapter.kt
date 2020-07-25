package com.example.androidshowcase.ui.insidelibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidshowcase.R
import com.example.androidshowcase.database.entities.Component
import com.example.androidshowcase.database.entities.ComponentMarking
import com.example.androidshowcase.database.entities.MarkingType

class ComponentsRecyclerAdapter(argMarkings: List<ComponentMarking>, argMarkingTypes: List<MarkingType>) : RecyclerView.Adapter<ComponentsRecyclerAdapter.ViewHolder>() {
    private var componentsList = listOf<Component>()
    var itemClickedListener: ((component: String) -> Unit)? = null
    var markingTypes: List<MarkingType> = argMarkingTypes
    var markings: List<ComponentMarking> = argMarkings
    var onCheckedListener: ((button: CompoundButton, isChecked: Boolean) -> Unit)? = null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_library_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return componentsList.count()
    }

    fun setData(componentsList: List<Component>) {
        this.componentsList = componentsList
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val componentName = itemView.findViewById<TextView>(R.id.library_name_text)
        private val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)

        init {
            itemView.setOnClickListener {
                itemClickedListener?.invoke(componentsList[adapterPosition].name)
            }
        }

        fun bindData(position: Int) {
            val componentMarking = markings.find { marking -> marking.componentId == componentsList[position].id }
            val markingType = markingTypes.find { markingType -> markingType.id == componentMarking?.markingId }
            checkBox.tag = componentsList[position].name
            checkBox.setOnCheckedChangeListener(null)
            checkBox.isChecked = markingType?.literalValue.equals("pin")
            checkBox.setOnCheckedChangeListener(onCheckedListener)
            componentName.text = componentsList[position].name
        }
    }
}