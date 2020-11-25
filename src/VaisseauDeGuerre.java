public class VaisseauDeGuerre extends Vaisseau{

    boolean armesDesactivees;

    VaisseauDeGuerre(String type) {
        super.type = type;
        if(type.equals("CHASSEUR")) {
            tonnageMax = 0;
        } else if(type.equals("FREGATE")) {
            tonnageMax = 50;
        } else if (type.equals("CROISEUR")) {
            tonnageMax = 100;
        }
    }

    void attaque(Vaisseau cible, String arme, int duree) {
        if(armesDesactivees) {
            System.out.println("Attaque impossible, l'armement a été désactivée");
        } else {
            System.out.println("Un vaisseau de type "+ type+" attaque un vaisseau de type "+ cible.type +" en utilisant l'arme " + arme + " pendant "+duree +" minutes.");
            cible.resistanceDuBouclier = 0;
            cible.blindage = cible.blindage/2;
        }
    }
    @Override
    void activerBouclier() {
        desactiverArmes();
        super.activerBouclier();
    }

    @Override
    public int emporterCargaison(int cargaison) {
        tonnageActuel += cargaison;
        if(type.equals("CHASSEUR")) {
            return cargaison;
        } else if(nbPassagers >= 12) {
            int tonnageMaxPassager = 2 * nbPassagers;
            if(tonnageActuel > tonnageMax) {
                return tonnageActuel - tonnageMax;
            } else if(tonnageActuel > tonnageMaxPassager) {
                return tonnageActuel - tonnageMaxPassager;
            } else {
                return 0;
            }

        } else {
            return cargaison;
        }
    }


    void desactiverArmes() {
        armesDesactivees = true;
        System.out.println("Desactivation des armes d'un vaisseau de type "+ type);
    }
}
