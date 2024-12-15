package abdellah.project.retrofite_rest.adapters

import abdellah.project.retrofite_rest.R
import abdellah.project.retrofite_rest.entities.Reservation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservationAdapter(
    private val userList: List<Reservation>, // La liste des réservations
    private val onDeleteClickListener: OnDeleteClickListener? // L'écouteur pour le bouton de suppression
) : RecyclerView.Adapter<ReservationAdapter.RViewHolder>() {

    // Interface pour gérer le clic sur le bouton de suppression
    interface OnDeleteClickListener {
        fun onDeleteClick(reservation: Reservation)
    }

    // Crée une nouvelle vue pour chaque élément de la liste
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RViewHolder {
        // Gonfle la vue de l'élément de la liste
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_resevation, parent, false)
        return RViewHolder(itemView) // Retourne une nouvelle instance de RViewHolder
    }

    // Remplie chaque vue avec les données de l'élément actuel
    override fun onBindViewHolder(holder: RViewHolder, position: Int) {
        val currentRes = userList[position]

        // Affiche les informations de la réservation dans les vues
        holder.textName.text = "Nom: ${currentRes.client.nom}"
        holder.textEmail.text = "Email: ${currentRes.client.email}"
        holder.textRoom.text = "Chambre: ${currentRes.chambre.id}"

        // Gère le clic sur le bouton de suppression
        holder.deleteButton.setOnClickListener {
            onDeleteClickListener?.onDeleteClick(currentRes)
        }
    }

    // Retourne la taille de la liste
    override fun getItemCount(): Int {
        return userList.size
    }

    // Classe ViewHolder pour chaque élément de la liste
    class RViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Déclare les vues
        var textName: TextView = itemView.findViewById(R.id.textName)
        var textEmail: TextView = itemView.findViewById(R.id.textEmail)
        var textRoom: TextView = itemView.findViewById(R.id.textRoom)
        var deleteButton: Button = itemView.findViewById(R.id.deleteButton)
    }
}
