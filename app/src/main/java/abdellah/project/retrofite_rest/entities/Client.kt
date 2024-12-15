package abdellah.project.retrofite_rest.entities

import com.google.gson.annotations.SerializedName

class Client(
    @field:SerializedName("id") private var _id: Long,
    @field:SerializedName("nom") private var _nom: String,
    @field:SerializedName("prenom") private var _prenom: String,
    @field:SerializedName("email") private var _email: String,
    @field:SerializedName("telephone") private var _telephone: String
) {

    // Getter and Setter for id
    var id: Long
        get() = _id
        set(value) {
            _id = value
        }

    // Getter and Setter for nom
    var nom: String
        get() = _nom
        set(value) {
            _nom = value
        }

    // Getter and Setter for prenom
    var prenom: String
        get() = _prenom
        set(value) {
            _prenom = value
        }

    // Getter and Setter for email
    var email: String
        get() = _email
        set(value) {
            _email = value
        }

    // Getter and Setter for telephone
    var telephone: String
        get() = _telephone
        set(value) {
            _telephone = value
        }

    // Override toString method
    override fun toString(): String {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}'
    }
}
