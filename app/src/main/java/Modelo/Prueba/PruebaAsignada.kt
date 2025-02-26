package Modelo.Prueba

import com.google.gson.annotations.SerializedName

data class PruebaAsignada(
    @SerializedName("idAsignacion")
    val idPruebaAsignada: Int? = null,

    @SerializedName("idPrueba")
    val idPrueba: Int,

    @SerializedName("idHumano")
    val idHumano: Int,

    @SerializedName("resultado")
    val resultado: Int,

    @SerializedName("fechaAsignacion")
    val fechaAsignacion: String
)
