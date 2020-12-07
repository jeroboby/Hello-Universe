package com.espacex.decouverte.enginsspaciaux;

public abstract class Vaisseau {
    public final TypeVaisseau type;
    public int nbPassagers;
    int blindage;
    int resistanceDuBouclier;
    int tonnageMax;
    protected int tonnageActuel;

    protected Vaisseau(TypeVaisseau type) {
        this.type = type;
    }

    void desactiverBouclier() {
        System.out.println("Désactivation du bouclier d'un vaisseau de type "+type);
    }

    void activerBouclier() {
        System.out.println("Activation du bouclier d'un vaisseau de type "+ type);
    }

    public abstract int emporterCargaison(int tonnage);
}
