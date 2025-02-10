package Modelo

import java.io.Serializable


data class Prueba(
    val idPrueba: Int = 0,
    val idDiosCreador: Int,
    val tipoPrueba: TipoPrueba,
    val descripcion: String,
    val atributoPrueba: AtributoPrueba?,
    val dificultad: Int,
    val impactoDestino: Int,
    val palabrasClave: String? = null
) : Serializable
