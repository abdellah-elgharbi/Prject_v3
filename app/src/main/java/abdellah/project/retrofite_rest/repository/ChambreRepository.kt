package abdellah.project.retrofite_rest.repository

import abdellah.project.retrofite_rest.entities.Chambre
import abdellah.project.retrofite_rest.network.RetrofitClient
import abdellah.project.retrofite_rest.network.ApiService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChambreRepository {
    private val apiService: ApiService = RetrofitClient.instance.create(ApiService::class.java)

    fun getAllChambres(): LiveData<List<Chambre>> {
        val data = MutableLiveData<List<Chambre>>()

        apiService.getAllChambres().enqueue(object : Callback<List<Chambre>> {
            override fun onResponse(call: Call<List<Chambre>>, response: Response<List<Chambre>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<Chambre>>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }

    fun getChambreById(id: Long): LiveData<Chambre?> {
        val data = MutableLiveData<Chambre?>()

        apiService.getChambreById(id).enqueue(object : Callback<Chambre> {
            override fun onResponse(call: Call<Chambre>, response: Response<Chambre>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<Chambre>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

    fun getChambresDisponibles(): LiveData<List<Chambre>> {
        val data = MutableLiveData<List<Chambre>>()

        apiService.getChambresDisponibles().enqueue(object : Callback<List<Chambre>> {
            override fun onResponse(call: Call<List<Chambre>>, response: Response<List<Chambre>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<Chambre>>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }
}