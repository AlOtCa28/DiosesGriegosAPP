package Modelo.Humano

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Humano(
    @SerializedName("idHumano")
    val idHumano: Int? = null,

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

    @SerializedName("idDiosProtector")
    val idDiosProtector: Int
) : Serializable
