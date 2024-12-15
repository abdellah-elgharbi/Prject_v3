package abdellah.project.retrofite_rest.entities

import com.google.gson.annotations.SerializedName

class Chambre {
    // Getters et setters
    @SerializedName("id")
    var id: Long? = null

    @SerializedName("type")
    var type: String? = null

    @SerializedName("prix")
    var prix: Double? = null

    @SerializedName("disponible")
    var disponible: Boolean? = null

    // Constructeur par défaut
    constructor()

    // Constructeur avec paramètres
    constructor(id: Long?, type: String?, prix: Double?, disponible: Boolean?) {
        this.id = id
        this.type = type
        this.prix = prix
        this.disponible = disponible
    }

    override fun toString(): String {
        return "Chambre{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", prix=" + prix +
                ", disponible=" + disponible +
                '}'
    }
}