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
            Receta(1,"Vitel Toné", RecetaNacion.Argentina, RecetaDificultad.EXPERTO,
         "\nPeceto de ternera 1 unidad (aprox 1/2 kg.)\n" +
                   "Zanahoria 2 unidades\n" +
                   "Cebolla 2 unidades\n" +
                   "Apio 1 rama\n" +
                   "Atun\n" +
                   "Mostaza, Sal y Pimienta\n",
             "https://www.recetasnatura.com.ar/sites/default/files/vitel-thone-1.jpg"),
            Receta(2,"Rabanada", RecetaNacion.Brasil, RecetaDificultad.EXPERTO,
         "\n3 huevos medianos\n" +
                   "600 ml (2 ½ tazas) de leche entera\n" +
                   "1 rama de canela\n" +
                   "8 rebanadas de pan\n" +
                   "500 ml (2 tazas) de aceite\n" +
                   "3 cucharadas de azúcar\n" +
                   "2 cucharadas de canela",
             "https://cdn0.tudoreceitas.com/pt/posts/7/7/6/rabanada_tradicional_677_orig.jpg"),
            Receta(3,"Cordero al Palo", RecetaNacion.Chile, RecetaDificultad.CHEF,
          "\n1 cordero (de 8 a 10 kg)\n" +
                    "1⁄4 de litro de aceite vegetal\n" +
                    "2 dientes de ajo finamente picados\n" +
                    "1 atado de perejil picado (1 taza aproximadamente)\n" +
                    "2 atados de culantro picados finamente (1 taza aproximadamente)",
              "https://media-cdn.tripadvisor.com/media/photo-s/17/90/b4/55/asado-de-cordero-al-palo.jpg"),
            Receta(4,"Hallacas ", RecetaNacion.Venezuela, RecetaDificultad.MODERADO,
          "\n4 kilogramos de de carne\n" +
                    "4 kilogramos de cochino\n" +
                    "1 botella de vino\n" +
                    "1½ kilogramos de papelón\n" +
                    "150 gramos de alcaparras",
              "https://www.pequerecetas.com/wp-content/uploads/2021/11/hallacas-venezolanas-receta-navidad.jpeg"),
            Receta(5,"Pavo Relleno", RecetaNacion.Belice, RecetaDificultad.FACIL,
          "\n1 pavo de 10 kg aproximadamente\n" +
                    "1½ kilogramos de carne molida de res\n" +
                    "1½ kilogramos de carne molida de cerdo\n" +
                    "½ taza de aceite de cocinar\n" +
                    "4 dientes de ajo picados",
              "https://cdn0.recetasgratis.net/es/posts/0/4/7/pavo_relleno_para_navidad_tradicional_50740_orig.jpg"),
            Receta(6,"Lechona", RecetaNacion.Colombia, RecetaDificultad.MEDIO,
          "\n1 kilogramo de Manteca de cerdo\n" +
                    "5 unidades de Cebolla larga\n" +
                    "2 kilogramos de Arvejas cocidas\n" +
                    "2 kilogramos de Papa\n" +
                    "1 unidad de Lechón (20kg)",
              "https://cdn0.recetasgratis.net/es/posts/8/4/9/lechona_tolimense_20948_orig.jpg"),
            Receta(7,"Fanesca", RecetaNacion.Ecuador, RecetaDificultad.MEDIO,"" +
                    "\n1 kg de bacalao seco salado\n" +
                    "7 cebollas (, picadas finamente)\n" +
                    "8 dientes de ajo (, picados)\n" +
                    "1 kg de sambo ((calabaza blanca), de pulpa suave y tierna)\n" +
                    "500 g de calabaza",
              "https://www.196flavors.com/wp-content/uploads/2018/12/fanesca-2-FP.jpg"),
            Receta(8,"Pepperpot", RecetaNacion.Guyana, RecetaDificultad.CHEF,
          "\n 1,250 kg de carne de cabra (cortados en trozos)\n" +
                    "1 kg de rabo de cerdo (cortado en trozos)\n" +
                    "4 dientes de ajo picados\n" +
                    "1 cucharadita de tomillo\n" +
                    "1 cebolla pequeña (, cortada en tiras)",
              "https://foreignfork.com/wp-content/uploads/2021/11/Pepperpot-Featured-Image.jpg"),
            Receta(9,"Nacatamal", RecetaNacion.Honduras, RecetaDificultad.MODERADO,
          "\n4 libras de Harina de maíz\n" +
                    "3 libras de Manteca de cerdo\n" +
                    "1 paquete de Hojas de plátano\n" +
                    "1 trozo de Culantro\n" +
                    "½ cebolla",
              "https://buenprovecho.hn/wp-content/uploads/2019/12/b.jpg"),
            Receta(10,"Jambalaya", RecetaNacion.Jamaica, RecetaDificultad.CHEF,
          "\n12 langostinos\n" +
                    "2 pechugas de pollo sin piel\n" +
                    "250 gr de longaniza seca picante\n" +
                    "200 gr de bacón ahumado\n" +
                    "4 puñados de arroz",
              "https://www.chilipeppermadness.com/wp-content/uploads/2021/11/Crockpot-Jambalaya-SQ.jpg"),
            Receta(11,"Chipa", RecetaNacion.Paraguay, RecetaDificultad.FACIL,
          "\n500 gr Fécula de mandioca (almidón de mandioca)\n" +
                    "3 Huevos\n" +
                    "50 gr Manteca\n" +
                    "100 cc Leche\n" +
                    "2 cditas Sal (opcional)",
              "https://hornomx.com/wp-content/uploads/2020/07/yucca-bread-recipe-hornomx-FG.jpg"),
            Receta(12,"Panetón", RecetaNacion.Peru, RecetaDificultad.FACIL,
          "\n1 kilo de harina\n" +
                    "250 ml de leche\n" +
                    "30 gramos de levadura fresca\n" +
                    "240 gramos de azúcar y 2 cucharadas\n" +
                    "200 gramos de pasas",
              "https://comidaperuanaweb.org/wp-content/uploads/2018/10/Receta-de-Panettone-Casero-1-1.jpg"),
            Receta(13,"Shucos", RecetaNacion.Guatemala, RecetaDificultad.MEDIO,
          "\n3 longanizas\n" +
                    "3 salchichas\n" +
                    "suficiente de aceite en spray\n" +
                    "suficiente de pan para hot dog, jumbo\n" +
                    "1 taza de guacamole",
              "https://www.curiouscuisiniere.com/wp-content/uploads/2022/01/Shucos-Guatemalan-Hot-Dogs-0395.3-735x613.jpg"),
            Receta(14,"Pastelón", RecetaNacion.Dominicana, RecetaDificultad.MODERADO,
          "\n1 cebolla roja grande (, cortada en cubitos)\n" +
                    "3 cucharadas de aceite de oliva\n" +
                    "4 dientes de ajo (, triturados)\n" +
                    "500 g de carne de vaca (, molida)\n" +
                    "1 pimiento rojo (, picado)",
              "https://i.ytimg.com/vi/EOTVuAlyWIk/sddefault.jpg"),
            Receta(15,"Yuca con mojo", RecetaNacion.Cuba, RecetaDificultad.EXPERTO,
          "\n2 raíces de yuca medianas\n" +
                    "1 cebolla blanca pequeña (, picada)\n" +
                    "2 dientes de ajo\n" +
                    "2 naranjas amargas (, exprimidas (o 2 limas y 1 naranja, exprimidas))\n" +
                    "5 cucharadas de aceite de oliva virgen extra",
              "https://belquistwist.com/wp-content/uploads/2023/08/yuca-con-mojo.jpg"),
            Receta(16,"Pescado con loroco", RecetaNacion.Salvador, RecetaDificultad.CHEF,
          "\n4 Filetes de curbina\n" +
                    "Loroco\n" +
                    "Quesillo\n" +
                    "Aceite\n" +
                    "1 pizca de Sal",
              "https://www.recetassalvador.com/base/stock/Recipe/105-image/105-image_web.jpg"),

        )
    }
}