package com.example.androidshowcase.data

import com.example.androidshowcase.ui.ComponentActivity
import com.example.androidshowcase.ui.libraries.material.button.MaterialButtonsActivity
import com.example.androidshowcase.ui.libraries.material.textfield.MaterialTextFieldActivity
import com.example.androidshowcase.ui.libraries.navigations.NavigationTabBarActivity
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

val navigationComponents = listOf(
        "NavigationTabBar"
)

val buttonComponents = listOf(
        ""
)

val listComponents = listOf(
        ""
)

val colorsComponents = listOf(
        ""
)

val toolBarComponents = listOf(
        ""
)

val inputComponents = listOf(
        ""
)

val labelComponents = listOf(
        ""
)

val menuComponents = listOf(
        ""
)

val appbarComponents = listOf(
        ""
)

val viewPagerComponents = listOf(
        ""
)

val textFieldComponents = listOf(
        ""
)

val sheetComponents = listOf(
        ""
)

val libraries: Map<String, List<String>> = mapOf("Material" to materialComponents,
        "Progress Bar" to progressBarComponents,
        "Seek Bar" to seekBarComponents,
        "Navigation" to navigationComponents,
        "Button" to buttonComponents,
        "Label" to labelComponents,
        "List" to listComponents,
        "Colors" to colorsComponents,
        "Tool bar" to toolBarComponents,
        "Input" to inputComponents,
        "Menu" to menuComponents,
        "App bar" to appbarComponents,
        "View Pager" to viewPagerComponents,
        "Text Field" to textFieldComponents,
        "Sheet" to sheetComponents)

val componentsToClasses: Map<String, ComponentActivity> = mapOf("Buttons" to MaterialButtonsActivity(),
        "TextFields" to MaterialTextFieldActivity(),
        "SmoothProgressBar" to SmoothProgressBarActivity(),
        "CircularProgressBar" to CircularProgressBarActivity(),
        "DiscreteSeekBar" to DiscreteSeekBarActivity(),
        "NumberProgressBar" to NumberProgressBarActivity(),
        "NavigationTabBar" to NavigationTabBarActivity())
val markings: List<String> = listOf("pin")