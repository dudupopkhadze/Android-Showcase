package com.example.androidshowcase.ui.libraries.progressBars

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import com.example.androidshowcase.R
import com.example.androidshowcase.ui.ComponentActivity
import com.race604.drawable.wave.WaveDrawable


class WaveProgressActivity : AppCompatActivity(),ComponentActivity {
    private  val componentName = "WaveProgress"

    lateinit var mImageView: ImageView
    lateinit var mWaveDrawable: WaveDrawable
    lateinit var mLevelSeekBar: SeekBar
    lateinit var mAmplitudeSeekBar: SeekBar
    lateinit var mSpeedSeekBar: SeekBar
    lateinit var mLengthSeekBar: SeekBar
    lateinit var mRadioGroup: RadioGroup

    override fun start(context: Context) {
        val intent = Intent(context, WaveProgressActivity::class.java)
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
        setContentView(R.layout.activity_wave_progress)
        supportActionBar?.title = componentName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mImageView = findViewById<View>(R.id.image) as ImageView
        mWaveDrawable = WaveDrawable(this, R.drawable.android_robot)
        mImageView.setImageDrawable(mWaveDrawable)
        mLevelSeekBar = findViewById<View>(R.id.level_seek) as SeekBar
        mLevelSeekBar.setOnSeekBarChangeListener(object : SimpleOnSeekBarChangeListener() {
           override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mWaveDrawable.level = progress
            }
        })
        mAmplitudeSeekBar = findViewById<View>(R.id.amplitude_seek) as SeekBar
        mAmplitudeSeekBar.setOnSeekBarChangeListener(object : SimpleOnSeekBarChangeListener() {
           override  fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mWaveDrawable.setWaveAmplitude(progress)
            }
        })
        mLengthSeekBar = findViewById<View>(R.id.length_seek) as SeekBar
        mLengthSeekBar.setOnSeekBarChangeListener(object : SimpleOnSeekBarChangeListener() {
            override  fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mWaveDrawable.setWaveLength(progress)
            }
        })
        mSpeedSeekBar = findViewById<View>(R.id.speed_seek) as SeekBar
        mSpeedSeekBar.setOnSeekBarChangeListener(object : SimpleOnSeekBarChangeListener() {
            override  fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                mWaveDrawable.setWaveSpeed(progress)
            }
        })
        mRadioGroup = findViewById<View>(R.id.modes) as RadioGroup
        mRadioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val indeterminate = checkedId == R.id.rb_yes
            setIndeterminateMode(indeterminate)
        })
        setIndeterminateMode(mRadioGroup.getCheckedRadioButtonId() == R.id.rb_yes)
        val imageView2 =
            findViewById<View>(R.id.image2) as ImageView
        val chromeWave = WaveDrawable(this, R.drawable.chrome_logo)
        imageView2.setImageDrawable(chromeWave)

        chromeWave.isIndeterminate = true
        val view: View = findViewById(R.id.view)
        val color = resources.getColor(R.color.colorAccent)
        val colorWave = WaveDrawable(ColorDrawable(color))
        view.background = colorWave
        colorWave.isIndeterminate = true
    }

    private fun setIndeterminateMode(indeterminate: Boolean) {
        mWaveDrawable!!.isIndeterminate = indeterminate
        mLevelSeekBar!!.isEnabled = !indeterminate
        if (!indeterminate) {
            mWaveDrawable.level = mLevelSeekBar.progress
        }
        mWaveDrawable.setWaveAmplitude(mAmplitudeSeekBar!!.progress)
        mWaveDrawable.setWaveLength(mLengthSeekBar!!.progress)
        mWaveDrawable.setWaveSpeed(mSpeedSeekBar!!.progress)
    }


    private open class SimpleOnSeekBarChangeListener : OnSeekBarChangeListener {
        override fun onProgressChanged(
            seekBar: SeekBar,
            progress: Int,
            fromUser: Boolean
        ) {
            // Nothing
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {
            // Nothing
        }

        override fun onStopTrackingTouch(seekBar: SeekBar) {
            // Nothing
        }
    }
}