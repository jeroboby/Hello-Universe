package com.espacex.decouverte.enginsspaciaux;

public class VaisseauCivil extends Vaisseau{

    VaisseauCivil(TypeVaisseau type) {
        super(type);
        switch (type) {
            case CARGO:
                tonnageMax = 500;
                break;
            case VAISSEAU_MONDE:
                tonnageMax = 2000;
                break;
        }
    }

    @Override
    public int emporterCargaison(int cargaison) {
        tonnageActuel = tonnageActuel + cargaison;
        if(tonnageActuel > tonnageMax) {
            return tonnageActuel - tonnageMax;
        } else {
            return 0;
        }
    }
}
