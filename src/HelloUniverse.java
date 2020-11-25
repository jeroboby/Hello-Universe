import java.sql.SQLOutput;

public class HelloUniverse {
    public static void main(String... args) {
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure");
        mercure.diametre = 4880;

        PlaneteTellurique venus = new PlaneteTellurique("Venus");
        venus.diametre = 12100;

        PlaneteTellurique mars = new PlaneteTellurique("Mars");
        mars.diametre = 6792;

        PlaneteTellurique terre = new PlaneteTellurique("Terre");
        terre.diametre = 12756;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre=142984;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

        System.out.println(Planete.nbPlanetesDecouvertes);


        System.out.println(jupiter.nom + " est une planète avec un diamètre de "+ jupiter.diametre + " kilomètres");

        System.out.println(neptune.nom+ " a effectué "+neptune.revolution(-3542)+ " tours complets autour de son étoile.");
        System.out.println(mars.nom + " a effectué " +mars.rotation(-684)+ " tours complets autour d'elle-même.");
        System.out.println(venus.nom + " a effectué " +venus.rotation(1250)+ " tours complets autour d'elle-même.");



        Atmosphere atmosphereUranus = new Atmosphere();
        atmosphereUranus.tauxHydrogene = 83f;
        atmosphereUranus.tauxHelium = 15f;
        atmosphereUranus.tauxMethane = 2.5f;
        uranus.atmosphere = atmosphereUranus;
        System.out.println("L'atmosphère d' "+ uranus.nom+ " est composée :\n D'hydrogène à "+ uranus.atmosphere.tauxHydrogene+ " % \n D'helium à "+ uranus.atmosphere.tauxHelium+ " % \n De méthane à "+ uranus.atmosphere.tauxMethane+ " %");

        Vaisseau fregate = new VaisseauDeGuerre("FREGATE");
        fregate.nbPassagers = 9;

        Vaisseau croiseur = new VaisseauDeGuerre("CROISEUR");
        croiseur.nbPassagers = 42;

        System.out.println("La forme de "+ mars.nom +" est : "+mars.forme);

        Planete.expansion(10.5);
        Planete.expansion(14.2);

        Vaisseau chasseur = new VaisseauDeGuerre("CHASSEUR");
        chasseur.blindage = 156;
        chasseur.resistanceDuBouclier = 2;

        Vaisseau vaisseauMonde = new VaisseauCivil("VAISSEAU-MONDE");
        vaisseauMonde.blindage=4784;
        vaisseauMonde.resistanceDuBouclier=30;

        ((VaisseauDeGuerre) chasseur).activerBouclier();
        vaisseauMonde.activerBouclier();
        ((VaisseauDeGuerre)chasseur).attaque(vaisseauMonde, "lasers photoniques", 3);
        vaisseauMonde.desactiverBouclier();
        System.out.println("La durée de protection du bouclier sur le "+ vaisseauMonde.type+ " est de "+ vaisseauMonde.resistanceDuBouclier+ " minutes");
        System.out.println("Le blindage restant sur le "+ vaisseauMonde.type+ " est de "+ vaisseauMonde.blindage);
        mars.accueillirVaisseau(vaisseauMonde);
        mars.accueillirVaisseau(chasseur);

        Vaisseau chasseurSurTerre= new VaisseauDeGuerre("CHASSEUR");
        terre.accueillirVaisseau(chasseurSurTerre);
        System.out.println(chasseurSurTerre.emporterCargaison(20));

        Vaisseau fregate100 = new VaisseauDeGuerre("FREGATE");
        fregate100.nbPassagers = 100;
        System.out.println(fregate100.emporterCargaison(45));
        System.out.println(fregate100.emporterCargaison(12));

        Vaisseau fregate14 = new VaisseauDeGuerre("FREGATE");
        fregate14.nbPassagers = 14;
        System.out.println(fregate14.emporterCargaison(30));

        Vaisseau vaisseauMonde1 = new VaisseauCivil("VAISSEAU-MONDE");
        System.out.println(vaisseauMonde1.emporterCargaison(1560));
        System.out.println(vaisseauMonde1.emporterCargaison(600));

    }
}
