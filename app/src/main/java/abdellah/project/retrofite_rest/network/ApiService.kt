package abdellah.project.retrofite_rest.network

import abdellah.project.retrofite_rest.entities.Client
import abdellah.project.retrofite_rest.entities.Chambre
import abdellah.project.retrofite_rest.entities.Reservation
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    // Endpoints Client
    @GET("clients")
    fun getAllClients(): Call<List<Client>>

    @GET("clients/{id}")
    fun getClientById(@Path("id") id: Long): Call<Client>

    @POST("clients")
    fun createClient(@Body client: Client): Call<Client>

    @PUT("clients/{id}")
    fun updateClient(@Path("id") id: Long, @Body client: Client): Call<Client>

    @DELETE("clients/{id}")
    fun deleteClient(@Path("id") id: Long): Call<Void>

    // Endpoints Chambre
    @GET("chambres")
    fun getAllChambres(): Call<List<Chambre>>

    @GET("chambres/{id}")
    fun getChambreById(@Path("id") id: Long): Call<Chambre>

    @GET("chambres/disponibles")
    fun getChambresDisponibles(): Call<List<Chambre>>

    // Endpoints Reservation
    @GET("reservations")
    fun getAllReservations(): Call<List<Reservation>>

    @GET("reservations/{id}")
    fun getReservationById(@Path("id") id: Long): Call<Reservation>

    @POST("reservations")
    fun createReservation(@Body reservation: Reservation): Call<Reservation>

    @PUT("reservations/{id}")
    fun updateReservation(@Path("id") id: Long, @Body reservation: Reservation): Call<Reservation>

    @DELETE("reservations/{id}")
    fun deleteReservation(@Path("id") id: Long): Call<Void>
}