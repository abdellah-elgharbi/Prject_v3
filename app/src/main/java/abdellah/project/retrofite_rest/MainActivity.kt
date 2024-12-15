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
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ajouterReservationsAvecBoucle(3)

    }



    fun ajouterReservationsAvecBoucle(nombreReservations: Int) {
        val reservationRepository = ReservationRepository() // Instance du repository

        for (i in 1..nombreReservations) {
            // Créer un client fictif
            val client = Client(
                i.toLong(),
                "ClientPrenom$i",
                "ClientNom$i",
                "client$i@example.com",
                "12345678$i"
            )

            // Créer une chambre fictive
            val chambre = Chambre(
                id = i.toLong(),
                type = if (i % 2 == 0) "Single" else "Double",
                prix = 100.0 + i * 10,
                disponible = i % 2 == 0
            )

            // Créer une réservation fictive
            val reservation = Reservation(
                id = i.toLong(),
                client,
                chambre,
                "2024-12-1$i",
                "2024-12-${10 + i}",
                "Préférence pour réservation $i"
            )

            // Ajouter la réservation au repository
            reservationRepository.createReservation(reservation).observe(this) { newReservation ->
                if (newReservation != null) {
                    Toast.makeText(this, "Réservation $i ajoutée avec succès", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Erreur lors de l'ajout de la réservation $i", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}
