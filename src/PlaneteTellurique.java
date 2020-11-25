public class PlaneteTellurique extends Planete implements Habitable {

    int totalVisiteurs;
    Vaisseau vaisseauAccoste;


    public PlaneteTellurique(String nom) {

        super(nom);
    }

    public Vaisseau accueillirVaisseau(Vaisseau nouveauVaisseau){

        if(nouveauVaisseau instanceof VaisseauDeGuerre) {
            ((VaisseauDeGuerre) nouveauVaisseau).desactiverArmes();
        }

        totalVisiteurs += nouveauVaisseau.nbPassagers;

        if(vaisseauAccoste == null) {
            System.out.println("Auncun vaisseau de s'en va");
        } else {
            System.out.println("Un vaisseau de type "+ vaisseauAccoste.type + " doit s'en aller.");
        }
        Vaisseau vaisseauPrecedent = vaisseauAccoste;
        vaisseauAccoste = nouveauVaisseau;
        return vaisseauPrecedent;
    }
}
