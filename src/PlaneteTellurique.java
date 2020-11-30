public class PlaneteTellurique extends Planete implements Habitable {

    int totalVisiteurs;
    Vaisseau[][] vaisseauAccostes;


    public PlaneteTellurique(String nom, int tailleBaie) {
        super(nom);
        this.vaisseauAccostes = new Vaisseau[tailleBaie][tailleBaie];
    }

    public void accueillirVaisseaux(Vaisseau... nouveauVaisseau){



        for(int i =0; i< nouveauVaisseau.length; i++) {

            int indexZone=0;

            switch (nouveauVaisseau[i].type) {
                case CARGO:
                case VAISSEAU_MONDE:
                    indexZone=1;
            }

            for(int index = 0; index < vaisseauAccostes[indexZone].length; index++) {
                    if(vaisseauAccostes[indexZone][index] == null) {
                        vaisseauAccostes[indexZone][index] = nouveauVaisseau[i];
                        break;
                }
            }

            if(nouveauVaisseau[i] instanceof VaisseauDeGuerre) {
                ((VaisseauDeGuerre) nouveauVaisseau[i]).desactiverArmes();
            }
            totalVisiteurs += nouveauVaisseau[i].nbPassagers;

        }

    }

    boolean restePlaceDisponible(Vaisseau vaisseau) {

        int indexZone=0;

        switch (vaisseau.type) {
            case CARGO:
            case VAISSEAU_MONDE:
                indexZone=1;
        }
        for(int index = 0; index < vaisseauAccostes[indexZone].length; index++) {
                if(vaisseauAccostes[indexZone][index] == null) {
                    return true;
            }
        }
        return false;
    }
}
