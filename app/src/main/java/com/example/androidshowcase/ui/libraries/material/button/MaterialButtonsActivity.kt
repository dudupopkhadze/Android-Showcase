package com.example.androidshowcase.ui.libraries.material.button

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.androidshowcase.R
import com.example.androidshowcase.databinding.ActivityMaterialButtonsBinding
import com.example.androidshowcase.ui.ComponentActivity

class MaterialButtonsActivity : AppCompatActivity(),ComponentActivity {

    private lateinit var binding: ActivityMaterialButtonsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Material Buttons"
        binding.titlesEditText.doAfterTextChanged {
            if(it?.isNotEmpty() == true) {
                binding.textButton.text = it.toString()
                binding.outlinedButton.text = it.toString()
                binding.containedButton.text = it.toString()
            }
        }

        binding.addIconButton.setOnClickListener {
            binding.textButton.icon = getDrawable(R.drawable.ic_baseline_add_24)
            binding.outlinedButton.icon = getDrawable(R.drawable.ic_baseline_add_24)
            binding.containedButton.icon = getDrawable(R.drawable.ic_baseline_add_24)
        }

        binding.removeIconButton.setOnClickListener {
            binding.textButton.icon = null
            binding.outlinedButton.icon = null
            binding.containedButton.icon = null
        }

        binding.singleSelectingSwitch.setOnCheckedChangeListener { _, isChecked ->
            binding.toggledButtons.isSingleSelection = isChecked
        }

        binding.miniFloatingButton.setOnClickListener {
            Toast.makeText(this, "Mini Floating Button", Toast.LENGTH_SHORT).show()
        }

        binding.regularFloatingButton.setOnClickListener {
            Toast.makeText(this, "Regular Floating Button", Toast.LENGTH_SHORT).show()
        }

        binding.extendedFloatingButton.setOnClickListener {
            Toast.makeText(this, "Extended Floating Button", Toast.LENGTH_SHORT).show()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.scrollView.setOnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                if (oldScrollY > scrollY + 5) {
                    binding.miniFloatingButton.show()
                    binding.regularFloatingButton.show()
                    binding.extendedFloatingButton.show()
                } else if(oldScrollY + 5 < scrollY){
                    binding.miniFloatingButton.hide()
                    binding.regularFloatingButton.hide()
                    binding.extendedFloatingButton.hide()
                }
            }
        }
    }

    override fun start(context: Context) {
        val intent = Intent(context, MaterialButtonsActivity::class.java)
        context.startActivity(intent)
    }
}

