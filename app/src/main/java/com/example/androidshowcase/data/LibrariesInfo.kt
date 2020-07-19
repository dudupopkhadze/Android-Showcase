package com.example.androidshowcase.data

import com.example.androidshowcase.ui.ComponentActivity
import com.example.androidshowcase.ui.libraries.material.button.MaterialButtonsActivity
import com.example.androidshowcase.ui.libraries.material.textfield.MaterialTextFieldActivity
import com.example.androidshowcase.ui.libraries.progressBars.CircularProgressBarActivity
import com.example.androidshowcase.ui.libraries.progressBars.NumberProgressBarActivity
import com.example.androidshowcase.ui.libraries.progressBars.SmoothProgressBarActivity
import com.example.androidshowcase.ui.libraries.seekBars.DiscreteSeekBarActivity

val materialComponents = listOf(
        "App bars",
        "Bottom navigation",
        "Buttons",
        "Cards",
        "Chips",
        "Dialogs",
        "Lists",
        "Menus",
        "Pickers",
        "Selection Controls",
        "Sheets",
        "Sliders",
        "Snackbars",
        "Tabs",
        "TextFields"
)

val progressBarComponents = listOf(
        "SmoothProgressBar",
        "CircularProgressBar",
        "NumberProgressBar"
)

val seekBarComponents = listOf(
        "DiscreteSeekBar"
)

val libraries: Map<String, List<String>> = mapOf("Material" to materialComponents,
        "Progress Bar" to progressBarComponents,
        "Seek Bar" to seekBarComponents)

val componentsToClasses: Map<String, ComponentActivity> = mapOf("Buttons" to MaterialButtonsActivity(),
        "TextFields" to MaterialTextFieldActivity(),
        "SmoothProgressBar" to SmoothProgressBarActivity(),
        "CircularProgressBar" to CircularProgressBarActivity(),
        "DiscreteSeekBar" to DiscreteSeekBarActivity(),
        "NumberProgressBar" to NumberProgressBarActivity())
val markings: List<String> = listOf("pin")