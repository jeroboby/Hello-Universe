public class HelloUniverse {
    public static void main(String... args) {
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
        mercure.diametre = 4880;
        mercure.matiere = "Téllurique";

        PlaneteTellurique venus = new PlaneteTellurique("Venus");
        venus.diametre = 12100;
        venus.matiere = "Téllurique";

        PlaneteTellurique mars = new PlaneteTellurique("Mars");
        mars.diametre = 6792;
        mars.matiere = "Téllurique";

        PlaneteTellurique terre = new PlaneteTellurique("Terre");
        terre.diametre = 12756;
        terre.matiere = "Téllurique";

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre=142984;
        jupiter.matiere="Gazeuse";

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.matiere = "Gazeuse";

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.matiere = "Gazeuse";

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.matiere = "Gazeuse";

        System.out.println(Planete.nbPlanetesDecouvertes);

        Planete sedna= new Planete("Sedna");

        System.out.println(jupiter.nom + " est une planète "+ jupiter.matiere+ " avec un diamètre de "+ jupiter.diametre + " kilomètres");
        System.out.println(sedna.nom + " est une planète "+ sedna.matiere+ " avec un diamètre de "+ sedna.diametre + " kilomètres");

        System.out.println(neptune.nom+ " a effectué "+neptune.revolution(-3542)+ " tours complets autour de son étoile.");
        System.out.println(mars.nom + " a effectué " +mars.rotation(-684)+ " tours complets autour d'elle-même.");
        System.out.println(venus.nom + " a effectué " +venus.rotation(1250)+ " tours complets autour d'elle-même.");



        Atmosphere atmosphereUranus = new Atmosphere();
        atmosphereUranus.tauxHydrogene = 83f;
        atmosphereUranus.tauxHelium = 15f;
        atmosphereUranus.tauxMethane = 2.5f;
        uranus.atmosphere = atmosphereUranus;
        System.out.println("L'atmosphère d' "+ uranus.nom+ " est composée :\n D'hydrogène à "+ uranus.atmosphere.tauxHydrogene+ " % \n D'helium à "+ uranus.atmosphere.tauxHelium+ " % \n De méthane à "+ uranus.atmosphere.tauxMethane+ " %");

        Vaisseau fregate = new Vaisseau();
        fregate.type = "FREGATE";
        fregate.nbPassagers = 9;

        Vaisseau croiseur = new Vaisseau();
        croiseur.type = "CROISEUR";
        croiseur.nbPassagers = 42;

        mars.accueillirVaisseau(fregate);
        mars.accueillirVaisseau(croiseur);

        System.out.println("La forme de "+ mars.nom +" est : "+mars.forme);

        Planete.expansion(10.5);
        Planete.expansion(14.2);

        VaisseauDeGuerre chasseur = new VaisseauDeGuerre();
        chasseur.type = "CHASSEUR";
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        VaisseauCivil vaisseauMonde = new VaisseauCivil();
        vaisseauMonde.type = "VAISSEAU-MONDE";
        vaisseauMonde.blindage=4784;
        vaisseauMonde.resistanceDuBouclier=30;

        chasseur.activerBouclier();
        vaisseauMonde.activerBouclier();
        chasseur.attaque(vaisseauMonde, "lasers photoniques", 3);
        vaisseauMonde.desactiverBouclier();
        System.out.println("La durée de protection du bouclier sur le "+ vaisseauMonde.type+ " est de "+ vaisseauMonde.resistanceDuBouclier+ " minutes");
        System.out.println("Le blindage restant sur le "+ vaisseauMonde.type+ " est de "+ vaisseauMonde.blindage);
        mars.accueillirVaisseau(vaisseauMonde);
        jupiter.accueillirVaisseau(chasseur);
        mars.accueillirVaisseau(chasseur);
    }
}
