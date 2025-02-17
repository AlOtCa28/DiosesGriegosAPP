package Modelo.Usuario

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("id_usuario")
    val idUsuario: Int? = null,

    @SerializedName("nombre")
    val nombre: String? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("contraseña")
    val contrasena: String? = null,

    @SerializedName("rol")
    val rol: Int? = null,

    @SerializedName("estado")
    val estado: Int? = null,

    @SerializedName("foto_perfil")
    val fotoPerfil: String? = null,

    @SerializedName("destino")
    val destino: Int? = null

) : Serializable
