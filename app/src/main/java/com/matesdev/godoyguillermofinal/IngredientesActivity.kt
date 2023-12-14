package com.matesdev.godoyguillermofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class IngredientesActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var imageRecipe: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredientes)

        textViewName = findViewById(R.id.tvNameRecipe)
        imageRecipe = findViewById(R.id.imgReceta)


        val bundle = intent.extras
        val nameSelected = bundle?.getString("name", "") ?: ""
        val urlSelected = bundle?.getString("urlImg", "")

        textViewName.text = nameSelected

        Glide.with(this)
            .load(urlSelected)
            .placeholder(R.drawable.placeholder_image)
            .into(imageRecipe)

    }



}