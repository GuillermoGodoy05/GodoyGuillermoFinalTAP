package com.matesdev.godoyguillermofinal

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class IngredientesActivity : AppCompatActivity() {

    private lateinit var textViewName: TextView
    private lateinit var textViewIngredientes: TextView

    private lateinit var imageRecipe: ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredientes)

        textViewName = findViewById(R.id.tvNameRecipe)
        imageRecipe = findViewById(R.id.imgReceta)
        textViewIngredientes = findViewById(R.id.tvIngredientes)


        val bundle = intent.extras
        val nameSelected = bundle?.getString("name", "") ?: ""
        val urlSelected = bundle?.getString("urlImg", "")
        val ingredientes = bundle?.getString("ingredients", "")



        textViewName.text = nameSelected
        textViewIngredientes.text = "Ingredientes: " + ingredientes

        Glide.with(this)
            .load(urlSelected)
            .placeholder(R.drawable.placeholder_image)
            .into(imageRecipe)

    }



}