package API

import Modelo.Prueba.Prueba
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PruebaAPI {
        @GET("pruebas/{id}")
        suspend fun obtenerPruebaPorId(@Path("id") id: Int): Response<Prueba>

        @POST("pruebas/registrar")
        suspend fun registrarPrueba(@Body prueba: Prueba): Response<Prueba>

        @GET("pruebas/listado")
        suspend fun listarPruebas(): Response<MutableList<Prueba>>
}