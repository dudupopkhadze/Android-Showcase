package com.example.androidshowcase.data

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

val componentsToClasses: Map<String, String> = mapOf("SmoothProgressBar" to "com.example.androidshowcase.ui.libraries.progressBars.SmoothProgressBarActivity",
        "CircularProgressBar" to "com.example.androidshowcase.ui.libraries.progressBars.CircularProgressBarActivity",
        "DiscreteSeekBar" to "com.example.androidshowcase.ui.libraries.seekBars.DiscreteSeekBarActivity",
        "NumberProgressBar" to "com.example.androidshowcase.ui.libraries.progressBars.NumberProgressBarActivity")
val markings: List<String> = listOf("pin")