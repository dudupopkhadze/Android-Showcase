package com.example.androidshowcase.ui.libraries.material.textfield

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.androidshowcase.R
import com.example.androidshowcase.databinding.ActivityMaterialTextFieldBinding
import com.example.androidshowcase.ui.ComponentActivity
import com.google.android.material.textfield.TextInputLayout

class MaterialTextFieldActivity : AppCompatActivity(), ComponentActivity {
    override fun start(context: Context) {
        val intent = Intent(context, MaterialTextFieldActivity::class.java)
        context.startActivity(intent)
    }

    private lateinit var binding: ActivityMaterialTextFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialTextFieldBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActivity()
    }

    private fun setupActivity() {
        binding.errorButton.setOnClickListener {
            if (binding.outlinedTextLayout.error == null) {
                binding.outlinedTextLayout.error = "error"
                binding.filledTextLayout.error = "error"
            } else {
                binding.outlinedTextLayout.error = null
                binding.filledTextLayout.error = null
            }
        }

        binding.clearTextModeButton.setOnClickListener {
            binding.outlinedTextLayout.endIconMode = TextInputLayout.END_ICON_CLEAR_TEXT
            binding.filledTextLayout.endIconMode = TextInputLayout.END_ICON_CLEAR_TEXT
        }

        binding.leadingIconButton.setOnClickListener {
            binding.outlinedTextLayout.startIconDrawable =
                getDrawable(R.drawable.ic_baseline_add_24)
            binding.filledTextLayout.startIconDrawable = getDrawable(R.drawable.ic_baseline_add_24)
        }

        binding.customIconButton.setOnClickListener {
            binding.outlinedTextLayout.endIconMode = TextInputLayout.END_ICON_CUSTOM
            binding.outlinedTextLayout.endIconDrawable =
                getDrawable(R.drawable.ic_outline_remove_24)
            binding.filledTextLayout.endIconMode = TextInputLayout.END_ICON_CUSTOM
            binding.filledTextLayout.endIconDrawable = getDrawable(R.drawable.ic_outline_remove_24)
        }

        binding.passwordModeButton.setOnClickListener {
            binding.outlinedTextLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
            binding.filledTextLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
        }

        binding.clearModeButton.setOnClickListener {
            binding.outlinedTextLayout.endIconMode = TextInputLayout.END_ICON_NONE
            binding.filledTextLayout.endIconMode = TextInputLayout.END_ICON_NONE
            binding.outlinedTextLayout.startIconDrawable = null
            binding.filledTextLayout.startIconDrawable = null
            binding.outlinedTextLayout.error = null
            binding.filledTextLayout.error = null
        }

        binding.newHelperText.doAfterTextChanged {
            binding.outlinedTextLayout.helperText = it.toString()
            binding.filledTextLayout.helperText = it.toString()
        }

        binding.newTitleText.doAfterTextChanged {
            binding.outlinedTextLayout.hint = it.toString()
            binding.filledTextLayout.hint = it.toString()
        }

        binding.newCounterText.doAfterTextChanged {
            if (!it.isNullOrEmpty()) {
                binding.outlinedTextLayout.isCounterEnabled = true
                binding.filledTextLayout.isCounterEnabled = true
                binding.outlinedTextLayout.counterMaxLength = it.toString().toInt()
                binding.filledTextLayout.counterMaxLength = it.toString().toInt()
            } else {
                binding.outlinedTextLayout.isCounterEnabled = false
                binding.filledTextLayout.isCounterEnabled = false
            }
        }

    }
}