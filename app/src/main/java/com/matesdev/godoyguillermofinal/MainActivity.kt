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

        adapter.onItemClickListener = {  ingrediente ->
            val intent = Intent(this, IngredientesActivity::class.java)
            intent.putExtra("name", ingrediente.nombreReceta)
            startActivity(intent)

        }


    }



    private fun getRecetas(): MutableList<Receta> {
        return mutableListOf(
            Receta(1,"Vitel Toné", RecetaNacion.ARGENTINA, RecetaDificultad.MODERADO,null,null,null),
            Receta(2,"Rabanada", RecetaNacion.BRASIL, RecetaDificultad.EXPERTO,null,null,null),
            Receta(3,"Cordero al Palo", RecetaNacion.CHILE, RecetaDificultad.CHEF,null,null,null)

        )
    }
}