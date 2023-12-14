package com.matesdev.godoyguillermofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecetaAdapter(this)

        recyclerView.adapter = adapter

        val listaRecetas = getRecetas()
        adapter.submitList(listaRecetas)

        adapter.onItemClickListener = {  recipe ->
            val intent = Intent(this, IngredientesActivity::class.java)
            intent.putExtra("name", recipe.nombreReceta)
            intent.putExtra("urlImg", recipe.image)

            startActivity(intent)

        }

    }

    private fun getRecetas(): MutableList<Receta> {
        return mutableListOf(
            Receta(1,"Vitel Toné", RecetaNacion.Argentina, RecetaDificultad.MODERADO,"Peceto, Salsa blanca, Sal","https://www.recetasnatura.com.ar/sites/default/files/vitel-thone-1.jpg"),
            Receta(2,"Rabanada", RecetaNacion.Brasil, RecetaDificultad.EXPERTO,"Carne, Aceite, Pan rallado","https://cdn0.tudoreceitas.com/pt/posts/7/7/6/rabanada_tradicional_677_orig.jpg"),
            Receta(3,"Cordero al Palo", RecetaNacion.Chile, RecetaDificultad.CHEF,"Cordero","https://media-cdn.tripadvisor.com/media/photo-s/17/90/b4/55/asado-de-cordero-al-palo.jpg")

        )
    }
}