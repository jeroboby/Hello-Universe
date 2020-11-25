public abstract class Vaisseau {
    String type;
    int nbPassagers;
    int blindage;
    int resistanceDuBouclier;
    int tonnageMax;
    int tonnageActuel;

    void desactiverBouclier() {
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type);
    }

    void activerBouclier() {
        System.out.println("Activation du bouclier d'un vaisseau de type "+ type);
    }

    abstract int emporterCargaison(int tonnage);
}
