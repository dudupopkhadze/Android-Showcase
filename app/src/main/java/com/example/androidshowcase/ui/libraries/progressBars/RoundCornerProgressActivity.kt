package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity
import kotlinx.android.synthetic.main.activity_round_corner_progress.*

class RoundCornerProgressActivity : AppCompatActivity(), ComponentActivity {
    private  val componentName = "RoundCornerProgressBar"

    override fun start(context: Context) {
        val intent = Intent(context, RoundCornerProgressActivity::class.java)
        context.startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_corner_progress)
        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        textViewSimple1.text = getSimple1Description()
        textViewSimple2.text = getSimple2Description()
        textViewSimple3.text = getSimple3Description()
        textViewSimple4.text = getSimple4Description()
        textViewSimple5.text = getSimple5Description()
        buttonSimpleCustomIncrease.setOnClickListener { increaseCustomProgress() }
        buttonSimpleCustomExtraIncrease.setOnClickListener { extraIncreaseCustomProgress() }
        buttonSimpleCustomDecrease.setOnClickListener { decreaseCustomProgress() }
        buttonSimpleCustomExtraDecrease.setOnClickListener { extraDecreaseCustomProgress() }
        checkBoxAnimationEnable.setOnCheckedChangeListener { _, isChecked -> onAnimationEnableCheckedChange(isChecked) }
        checkBoxGradientProgressColor.setOnCheckedChangeListener { _, isChecked -> onApplyGradientProgressColorCheckedChange(isChecked) }
        progressBarSimpleCustom.setOnProgressChangedListener { _, _, isPrimaryProgress, _ ->
            if (isPrimaryProgress) {
                updateCustomProgressText()
            }
        }
        updateCustomProgressText()
    }

    private fun onAnimationEnableCheckedChange(isChecked: Boolean) {
        if (isChecked) {
            progressBarSimpleCustom.enableAnimation()
        } else {
            progressBarSimpleCustom.disableAnimation()
        }
    }

    private fun onApplyGradientProgressColorCheckedChange(isChecked: Boolean) {
        if (isChecked) {
            progressBarSimpleCustom.progressColors = resources.getIntArray(R.array.sample_progress_gradient)
        } else {
            @Suppress("DEPRECATION")
            progressBarSimpleCustom.progressColor = resources.getColor(R.color.sample_progress_primary)
        }
    }

    private fun increaseCustomProgress() {
        progressBarSimpleCustom.progress = progressBarSimpleCustom.progress + 2
        updateCustomSecondaryProgress()
    }

    private fun extraIncreaseCustomProgress() {
        progressBarSimpleCustom.progress = progressBarSimpleCustom.progress + 20
        updateCustomSecondaryProgress()
    }

    private fun decreaseCustomProgress() {
        progressBarSimpleCustom.progress = progressBarSimpleCustom.progress - 2
        updateCustomSecondaryProgress()
    }

    private fun extraDecreaseCustomProgress() {
        progressBarSimpleCustom.progress = progressBarSimpleCustom.progress - 20
        updateCustomSecondaryProgress()
    }

    private fun updateCustomSecondaryProgress() {
        progressBarSimpleCustom.secondaryProgress = progressBarSimpleCustom.progress + 10
    }

    private fun updateCustomProgressText() {
        textViewSimpleCustom.text = String.format("%.0f", progressBarSimpleCustom.progress)
    }

    private fun getSimple1Description() = """
    |Max : 100
    |Progress : 50
    |Radius : 0dp
    |Padding : 4dp
    |Width : 260dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple2Description() = """
    |Max : 100
    |Progress : 40
    |SecondaryProgress : 60
    |Radius : 10dp
    |Padding : 2dp
    |Width : 260dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple3Description() = """
    |Max : 100
    |Progress : 20
    |SecondaryProgress : 75
    |Radius : 80dp
    |Padding : 2dp
    |Reverse : True
    |Width : 260dp
    |Height : 30dp
    """.trimMargin()

    private fun getSimple4Description() = """
    |Max : 100
    |Progress : 80
    |Radius : 20dp
    |Padding : 2dp
    |Width : 260dp
    |Height : 20dp
    """.trimMargin()

    private fun getSimple5Description() = """
    |Max : 200
    |Progress : 20
    |Radius : 20dp
    |Padding : 10dp
    |Width : 260dp
    |Height : 50dp
    """.trimMargin()

}