package com.example.androidshowcase.data

import com.example.androidshowcase.ui.libraries.progressBars.DiscreteSeekBarActivity

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
    "SmoothProgressBar"
)

val seekBarComponents = listOf(
    "DiscreteSeekBar"
)

val libraries: Map<String, List<String>> = mapOf("Material" to materialComponents,
                                                "Progress Bar" to progressBarComponents,
                                                "Seek Bar" to seekBarComponents)