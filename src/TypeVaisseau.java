public enum TypeVaisseau {
    CHASSEUR("Chasseur"),
    FREGATE("Fregate"),
    CROISEUR("Croiseur"),
    CARGO("Cargo"),
    VAISSEAU_MONDE("Vaisseau-Monde");

    String nom;

    TypeVaisseau(String nom) {
        this.nom = nom;
    }


}
