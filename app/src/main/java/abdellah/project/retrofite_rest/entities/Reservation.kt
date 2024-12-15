package abdellah.project.retrofite_rest.entities

import com.google.gson.annotations.SerializedName

class Reservation(
    @field:SerializedName("id") var id: Long?,  // Ajout du paramètre id au constructeur
    @field:SerializedName("client") private var _client: Client,
    @field:SerializedName("chambre") private var _chambre: Chambre,
    @field:SerializedName("dateDebut") private var _dateDebut: String,
    @field:SerializedName("dateFin") private var _dateFin: String,
    @field:SerializedName("preferences") private var _preferences: String
) {

    // Getter and Setter for client
    var client: Client
        get() = _client
        set(value) {
            _client = value
        }

    // Getter and Setter for chambre
    var chambre: Chambre
        get() = _chambre
        set(value) {
            _chambre = value
        }

    // Getter and Setter for dateDebut
    var dateDebut: String
        get() = _dateDebut
        set(value) {
            _dateDebut = value
        }

    // Getter and Setter for dateFin
    var dateFin: String
        get() = _dateFin
        set(value) {
            _dateFin = value
        }

    // Getter and Setter for preferences
    var preferences: String
        get() = _preferences
        set(value) {
            _preferences = value
        }
}
