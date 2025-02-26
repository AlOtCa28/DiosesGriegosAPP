package Modelo.Usuario

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("idUsuario")
    val idUsuario: Int? = null,

    @SerializedName("nombre")
    val nombre: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("contraseña")
    val contraseña: String,

    @SerializedName("rol")
    val rol: Int,

    @SerializedName("fotoPerfil")
    val fotoPerfil: String,

    @SerializedName("estado")
    val estado: Int,

    @SerializedName("destino")
    val destino: Int
) : Serializable
