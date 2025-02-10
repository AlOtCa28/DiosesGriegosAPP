package Modelo.Prueba

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Prueba(
    @SerializedName("id_prueba")
    val idPrueba: Int = 0,

    @SerializedName("id_dios_creador")
    val idDiosCreador: Int,

    @SerializedName("tipo_prueba")
    val tipoPrueba: String,

    @SerializedName("descripcion")
    val descripcion: String,

    @SerializedName("atributo_prueba")
    val atributoPrueba: String?,

    @SerializedName("dificultad")
    val dificultad: Int,

    @SerializedName("impacto_destino")
    val impactoDestino: Int,

    @SerializedName("palabras_clave")
    val palabrasClave: String? = null
) : Serializable
