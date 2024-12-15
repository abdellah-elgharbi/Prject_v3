package abdellah.project.retrofite_rest.repository

import abdellah.project.retrofite_rest.entities.Reservation
import abdellah.project.retrofite_rest.network.RetrofitClient
import abdellah.project.retrofite_rest.network.ApiService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ReservationRepository {
    private val apiService: ApiService = RetrofitClient.instance.create(ApiService::class.java)

    fun getAllReservations(): LiveData<List<Reservation>> {
        val data = MutableLiveData<List<Reservation>>()

        apiService.getAllReservations().enqueue(object : Callback<List<Reservation>> {
            override fun onResponse(call: Call<List<Reservation>>, response: Response<List<Reservation>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<Reservation>>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }

    fun getReservationById(id: Long): LiveData<Reservation?> {
        val data = MutableLiveData<Reservation?>()

        apiService.getReservationById(id).enqueue(object : Callback<Reservation> {
            override fun onResponse(call: Call<Reservation>, response: Response<Reservation>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<Reservation>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

    fun createReservation(reservation: Reservation): LiveData<Reservation?> {
        val data = MutableLiveData<Reservation?>()

        apiService.createReservation(reservation).enqueue(object : Callback<Reservation> {
            override fun onResponse(call: Call<Reservation>, response: Response<Reservation>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<Reservation>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

    fun updateReservation(id: Long, reservation: Reservation): LiveData<Reservation?> {
        val data = MutableLiveData<Reservation?>()

        apiService.updateReservation(id, reservation).enqueue(object : Callback<Reservation> {
            override fun onResponse(call: Call<Reservation>, response: Response<Reservation>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<Reservation>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

    fun deleteReservation(id: Long): LiveData<Boolean> {
        val data = MutableLiveData<Boolean>()

        apiService.deleteReservation(id).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                data.value = response.isSuccessful
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                data.value = false
            }
        })

        return data
    }
}