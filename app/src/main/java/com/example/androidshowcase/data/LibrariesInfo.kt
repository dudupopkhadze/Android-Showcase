package com.example.androidshowcase.data

import com.example.androidshowcase.ui.ComponentActivity
import com.example.androidshowcase.ui.libraries.imageView.CircleImageViewActivity
import com.example.androidshowcase.ui.libraries.imageView.ShapeImageviewActivity
import com.example.androidshowcase.ui.libraries.material.button.MaterialButtonsActivity
import com.example.androidshowcase.ui.libraries.material.textfield.MaterialTextFieldActivity
import com.example.androidshowcase.ui.libraries.navigations.NavigationTabBarActivity
import com.example.androidshowcase.ui.libraries.progressBars.*
import com.example.androidshowcase.ui.libraries.labels.shimmerActivity
import com.example.androidshowcase.ui.libraries.seekBars.DiscreteSeekBarActivity
import com.example.androidshowcase.ui.libraries.seekBars.SeekBarCompatActivity

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
        "NumberProgressBar",
        "RoundCornerProgressBar",
        "WaveProgress"
)

val seekBarComponents = listOf(
        "DiscreteSeekBar",
        "SeekBarCompat"
)

val navigationComponents = listOf(
        ""
)

val buttonComponents = listOf<String>()

val listComponents = listOf<String>()

val colorsComponents = listOf<String>()

val toolBarComponents = listOf<String>()

val inputComponents = listOf<String>()

val labelComponents = listOf<String>(
        "shimmer"
)

val menuComponents = listOf<String>()

val appbarComponents = listOf<String>()

val viewPagerComponents = listOf<String>()

val textFieldComponents = listOf<String>()

val sheetComponents = listOf<String>()

val imageviewComponents = listOf(
        "CircleImageView",
        "ShapeImageView"
)

val libraries: Map<String, List<String>> = mapOf("Material" to materialComponents,
        "Progress" to progressBarComponents,
        "Seek Bar" to seekBarComponents,
        "Navigation" to navigationComponents,
        "Image View" to imageviewComponents,
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
        "SeekBarCompat" to SeekBarCompatActivity(),
        "RoundCornerProgressBar" to RoundCornerProgressActivity(),
        "CircleImageView" to CircleImageViewActivity(),
        "ShapeImageView" to ShapeImageviewActivity(),
        "WaveProgress" to WaveProgressActivity()),
        "shimmer" to shimmerActivity()

val markings: List<String> = listOf("pin")