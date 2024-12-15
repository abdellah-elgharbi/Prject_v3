package abdellah.project.retrofite_rest

import abdellah.project.retrofite_rest.adapters.ReservationAdapter
import abdellah.project.retrofite_rest.entities.Chambre
import abdellah.project.retrofite_rest.entities.Client
import abdellah.project.retrofite_rest.entities.Reservation
import abdellah.project.retrofite_rest.repository.ReservationRepository
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), ReservationAdapter.OnDeleteClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var reservationAdapter: ReservationAdapter
    private val reservationList = mutableListOf<Reservation>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialiser le RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Remplir avec des données fictives

        // Initialiser l'adaptateur avec la liste et le gestionnaire de suppression
        reservationAdapter = ReservationAdapter(reservationList, this)
        recyclerView.adapter = reservationAdapter

        // Initialiser le bouton "Ajouter" et afficher le AlertDialog au clic
        val btnAjouter: Button = findViewById(R.id.myButton)
        btnAjouter.setOnClickListener {
            showAddReservationDialog()
        }
    }



    private fun showAddReservationDialog() {
        // Gonfler la vue personnalisée
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.add_alert, null)

        // Créer le AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ajouter une réservation")
        builder.setView(dialogView)

        // Action pour "Ajouter"
        builder.setPositiveButton("Ajouter") { dialog, which ->
            // Récupérer les données saisies par l'utilisateur
            val firstName = dialogView.findViewById<TextInputEditText>(R.id.editTextFirstName).text.toString()
            val lastName = dialogView.findViewById<TextInputEditText>(R.id.editTextLastName).text.toString()
            val email = dialogView.findViewById<TextInputEditText>(R.id.editTextEmail).text.toString()

            // Ajouter une nouvelle réservation avec les données saisies
            val newReservation = createNewReservation(firstName, lastName, email)
            reservationList.add(newReservation)
            reservationAdapter.notifyDataSetChanged()
            Toast.makeText(this, "Réservation ajoutée", Toast.LENGTH_SHORT).show()
        }

        // Action pour "Annuler"
        builder.setNegativeButton("Annuler") { dialog, which ->
            dialog.dismiss()
        }

        // Afficher le dialog
        builder.show()
    }

    private fun createNewReservation(firstName: String, lastName: String, email: String): Reservation {
        val client = Client(3L, firstName, lastName, email, "1122334455")
        val chambre = Chambre(103L, "Suite", 200.0, true)
        return Reservation(3L, client, chambre, "2024-12-17", "2024-12-18", "No preferences")
    }

    override fun onDeleteClick(reservation: Reservation) {

        reservationList.remove(reservation)
        val reservationRepository = ReservationRepository()
        reservation.id?.let { reservationRepository.deleteReservation(it) }
        reservationAdapter.notifyDataSetChanged()
        Toast.makeText(this, "Réservation supprimée", Toast.LENGTH_SHORT).show()
    }


    fun getAll(): LiveData<List<Reservation>> {
        val reservationRepository = ReservationRepository()
        return reservationRepository.getAllReservations()
    }

}
