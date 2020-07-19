package com.example.androidshowcase.ui.libraries.material.textfield

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidshowcase.databinding.ActivityMaterialTextFieldBinding

class MaterialTextFieldActivity : AppCompatActivity() {

    companion object{
        fun start(context: Context) {
            val intent = Intent(context, MaterialTextFieldActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityMaterialTextFieldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMaterialTextFieldBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}