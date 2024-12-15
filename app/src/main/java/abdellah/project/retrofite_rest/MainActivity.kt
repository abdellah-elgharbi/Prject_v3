package abdellah.project.retrofite_rest

import abdellah.project.retrofite_rest.adapters.ReservationAdapter
import abdellah.project.retrofite_rest.entities.Chambre
import abdellah.project.retrofite_rest.entities.Client
import abdellah.project.retrofite_rest.entities.Reservation
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ReservationAdapter.OnDeleteClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var reservationAdapter: ReservationAdapter
    private val reservationList = mutableListOf<Reservation>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Populate dummy data
        populateReservations()

        // Initialize adapter with the list and delete click listener
        reservationAdapter = ReservationAdapter(reservationList, this)
        recyclerView.adapter = reservationAdapter
    }

    private fun populateReservations() {
        // Create some dummy data
        val client1 = Client(1L, "John", "Doe", "john.doe@example.com", "123456789")
        val client2 = Client(2L, "Jane", "Doe", "jane.doe@example.com", "987654321")

        val chambre1 = Chambre(101L, "Single", 100.0, true)
        val chambre2 = Chambre(102L, "Double", 150.0, false)

        // Create reservations and add to the list
        val reservation1 = Reservation(1L, client1, chambre1, "2024-12-15", "2024-12-20", "No preferences")
        val reservation2 = Reservation(2L, client2, chambre2, "2024-12-16", "2024-12-18", "Near window")

        reservationList.add(reservation1)
        reservationList.add(reservation2)
    }

    override fun onDeleteClick(reservation: Reservation) {
        // Handle delete button click
        reservationList.remove(reservation)
        reservationAdapter.notifyDataSetChanged()
        Toast.makeText(this, "Reservation deleted", Toast.LENGTH_SHORT).show()
    }
}
