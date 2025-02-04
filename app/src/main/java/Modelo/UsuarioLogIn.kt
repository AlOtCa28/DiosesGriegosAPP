package Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsuarioLogIn (
    @SerializedName("nombre")
    val nombre:String? = null,

    @SerializedName("email")
    val email:String? = null,

    @SerializedName("contraseña")
    val contraseña:String? = null

):Serializable