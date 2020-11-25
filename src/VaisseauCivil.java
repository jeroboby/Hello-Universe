public class VaisseauCivil extends Vaisseau{

    VaisseauCivil(String type) {
        super.type = type;
    if(type.equals("CARGO")) {
        tonnageMax = 500;
    } else if (type.equals("VAISSEAU-MONDE")) {
        tonnageMax = 2000;
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
