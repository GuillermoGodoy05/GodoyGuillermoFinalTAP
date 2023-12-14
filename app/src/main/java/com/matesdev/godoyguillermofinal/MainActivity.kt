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
            intent.putExtra("ingredients", recipe.ingredientes)
            intent.putExtra("dificultad", recipe.dificultad)


            startActivity(intent)

        }

    }

    private fun getRecetas(): MutableList<Receta> {
        return mutableListOf(
            Receta(1,"Vitel Toné", RecetaNacion.Argentina, RecetaDificultad.MODERADO,"Peceto, Huevo, Atun, Mostaza Sal, Pimienta","https://www.recetasnatura.com.ar/sites/default/files/vitel-thone-1.jpg"),
            Receta(2,"Rabanada", RecetaNacion.Brasil, RecetaDificultad.EXPERTO,"Carne, Aceite, Pan rallado","https://cdn0.tudoreceitas.com/pt/posts/7/7/6/rabanada_tradicional_677_orig.jpg"),
            Receta(3,"Cordero al Palo", RecetaNacion.Chile, RecetaDificultad.CHEF,"Cordero","https://media-cdn.tripadvisor.com/media/photo-s/17/90/b4/55/asado-de-cordero-al-palo.jpg"),
            Receta(4,"Hallacas ", RecetaNacion.Venezuela, RecetaDificultad.MODERADO,"Cordero","https://www.pequerecetas.com/wp-content/uploads/2021/11/hallacas-venezolanas-receta-navidad.jpeg"),
            Receta(5,"Pavo Relleno", RecetaNacion.Belice, RecetaDificultad.FACIL,"Cordero","https://cdn0.recetasgratis.net/es/posts/0/4/7/pavo_relleno_para_navidad_tradicional_50740_orig.jpg"),
            Receta(6,"Lechona", RecetaNacion.Colombia, RecetaDificultad.MEDIO,"Cordero","https://cdn0.recetasgratis.net/es/posts/8/4/9/lechona_tolimense_20948_orig.jpg"),
            Receta(7,"Fanesca", RecetaNacion.Ecuador, RecetaDificultad.MEDIO,"Cordero","https://www.196flavors.com/wp-content/uploads/2018/12/fanesca-2-FP.jpg"),
            Receta(8,"Pepperpot", RecetaNacion.Guyana, RecetaDificultad.CHEF,"Cordero","https://foreignfork.com/wp-content/uploads/2021/11/Pepperpot-Featured-Image.jpg"),
            Receta(9,"Nacatamal", RecetaNacion.Honduras, RecetaDificultad.FACIL,"Cordero","https://buenprovecho.hn/wp-content/uploads/2019/12/b.jpg"),
            Receta(10,"Jambalaya", RecetaNacion.Jamaica, RecetaDificultad.EXPERTO,"Cordero","https://www.chilipeppermadness.com/wp-content/uploads/2021/11/Crockpot-Jambalaya-SQ.jpg"),
            Receta(11,"Chipa", RecetaNacion.Paraguay, RecetaDificultad.FACIL,"Cordero","https://hornomx.com/wp-content/uploads/2020/07/yucca-bread-recipe-hornomx-FG.jpg"),
            Receta(12,"Panetón", RecetaNacion.Peru, RecetaDificultad.MODERADO,"Cordero","https://comidaperuanaweb.org/wp-content/uploads/2018/10/Receta-de-Panettone-Casero-1-1.jpg")



        )
    }
}