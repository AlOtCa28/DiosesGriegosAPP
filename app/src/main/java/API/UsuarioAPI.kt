package API

import Modelo.Usuario
import Modelo.UsuarioLogIn
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioAPI {
    @GET("usuarios/{id}")
    suspend fun obtenerUsuarioPorId(@Path("id") id: Int): Response<Usuario>

    @POST("usuarios/login")
    suspend fun iniciarSesion(@Body usuerData: UsuarioLogIn): Response<Usuario?>

    @GET("usuarios/listado")
    suspend fun listarUsuarios(): Response<MutableList<Usuario>>

    @POST("usuarios/registrar")
    suspend fun registrarUsuario(@Body usuario: Usuario): Response<Boolean>
}
