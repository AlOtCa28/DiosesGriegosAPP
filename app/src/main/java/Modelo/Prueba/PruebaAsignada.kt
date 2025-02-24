package Modelo.Prueba

import com.google.gson.annotations.SerializedName

data class PruebaAsignada(
    @SerializedName("id_asignacion")
    val idPruebaAsignada: Int? = null,

    @SerializedName("id_prueba")
    val idPrueba: Int,

    @SerializedName("id_humano")
    val idHumano: Int,

    @SerializedName("resultado")
    val resultado: Int,

    @SerializedName("fecha_asignacion")
    val fechaAsignacion: String
)
