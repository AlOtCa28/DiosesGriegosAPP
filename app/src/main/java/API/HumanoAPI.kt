package API

import Modelo.Humano.Humano
import Modelo.Usuario.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET

interface HumanoAPI {
    @GET("humanos/listar")
    suspend fun listarHumanos(): Response<MutableList<Humano>>


    @GET("humanos/registrar")
    suspend fun registrarHumano(@Body humano: Humano): Response<Boolean>
}