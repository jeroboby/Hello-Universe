public class PlaneteTellurique extends Planete implements Habitable {

    int totalVisiteurs;
    Vaisseau vaisseauAccoste;


    PlaneteTellurique(String nom) {
        super(nom);
    }

    public Vaisseau accueillirVaisseau(Vaisseau nouveauVaisseau){

        totalVisiteurs += nouveauVaisseau.nbPassagers;

        Vaisseau vaisseauPrecedent = vaisseauAccoste;

        vaisseauAccoste = nouveauVaisseau;

        return vaisseauPrecedent;
    }
}
