package Modelo.Dios

import com.google.gson.annotations.SerializedName

data class Dios(
    @SerializedName("id_dios")
    val idDios: Int? = null,

    @SerializedName("sabiduria")
    val sabiduria: Int,

    @SerializedName("nobleza")
    val nobleza: Int,

    @SerializedName("virtud")
    val virtud: Int,

    @SerializedName("maldad")
    val maldad: Int,

    @SerializedName("audacia")
    val audacia: Int,
)
