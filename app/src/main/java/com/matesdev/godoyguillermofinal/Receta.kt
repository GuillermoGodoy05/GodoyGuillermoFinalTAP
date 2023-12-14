package com.matesdev.godoyguillermofinal

data class Receta (
    val id: Int,
    val nombreReceta: String,
    val nacion: RecetaNacion,
    val dificultad: RecetaDificultad,
    val ingredientes: String?,
    val image: String?
)

enum class RecetaDificultad {
    FACIL, MEDIO, MODERADO, EXPERTO, CHEF
}

enum class RecetaNacion {
    Argentina, Brasil, Chile, Peru, Venezuela, Ecuador, Guyana, Honduras, Belice, Colombia, Paraguay, Jamaica

}