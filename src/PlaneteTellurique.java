public class PlaneteTellurique extends Planete implements Habitable {

    int totalVisiteurs;
    Vaisseau[] vaisseauAccostes;


    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom);
        this.vaisseauAccostes = new Vaisseau[tailleBaie];
    }

    public void accueillirVaisseau(Vaisseau nouveauVaisseau){

        if(nouveauVaisseau instanceof VaisseauDeGuerre) {
            ((VaisseauDeGuerre) nouveauVaisseau).desactiverArmes();
        }

        totalVisiteurs += nouveauVaisseau.nbPassagers;

        for(int i = 0; i < vaisseauAccostes.length; i++) {
            if(vaisseauAccostes[i] == null) {
                vaisseauAccostes[i] = nouveauVaisseau;
                break;
            }
        }

    }

    boolean restePlaceDisponible() {
        for(int i = 0; i < vaisseauAccostes.length; i++) {
            if(vaisseauAccostes[i] == null) {
                return true;
           }
        }
        return false;
    }
}
