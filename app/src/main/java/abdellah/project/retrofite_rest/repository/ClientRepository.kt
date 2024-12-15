package abdellah.project.retrofite_rest.repository

import abdellah.project.retrofite_rest.entities.Client
import abdellah.project.retrofite_rest.network.RetrofitClient
import abdellah.project.retrofite_rest.network.ApiService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClientRepository {
    private val apiService: ApiService = RetrofitClient.instance.create(ApiService::class.java)

    fun getAllClients(): LiveData<List<Client>> {
        val data = MutableLiveData<List<Client>>()

        apiService.getAllClients().enqueue(object : Callback<List<Client>> {
            override fun onResponse(call: Call<List<Client>>, response: Response<List<Client>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<Client>>, t: Throwable) {
                data.value = emptyList()
            }
        })

        return data
    }

    fun createClient(client: Client): LiveData<Client?> {
        val data = MutableLiveData<Client?>()

        apiService.createClient(client).enqueue(object : Callback<Client> {
            override fun onResponse(call: Call<Client>, response: Response<Client>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                } else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<Client>, t: Throwable) {
                data.value = null
            }
        })

        return data
    }

    // Ajoutez d'autres méthodes CRUD similaires
}