package Modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UsuarioLogIn (
    @SerializedName("nombre")
    val nombre:String? = null,

    @SerializedName("email")
    val correo:String? = null,

    @SerializedName("contraseña")
    val contrasena:String? = null

):Serializable