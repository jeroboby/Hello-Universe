import java.util.*;

public class HelloUniverse {
    public static void main(String... args) {
        Galaxie systemeSolaire = new Galaxie();
        systemeSolaire.nom = "Système Solaire";



        Atmosphere atmosphereMars = new Atmosphere();
        atmosphereMars.constituant.put("CO2", 95f);
        atmosphereMars.constituant.put("N2", 3f);
        atmosphereMars.constituant.put("Ar", 1.5f);
        atmosphereMars.constituant.put("NO", 0.013f);


        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;
        mercure.distanceEtoile = 57.9f;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;
        venus.distanceEtoile = 108.2f;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 3);
        mars.diametre = 6792;
        mars.distanceEtoile = 227.9f;

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 10);
        terre.diametre = 12756;
        terre.distanceEtoile = 149.6f;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre=142984;
        jupiter.distanceEtoile = 778.3f;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;
        saturne.distanceEtoile = 1427.0f;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;
        uranus.distanceEtoile = 2877.38f;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;
        neptune.distanceEtoile = 4497.07f;

        systemeSolaire.planetes.add(jupiter);
        systemeSolaire.planetes.add(saturne);
        systemeSolaire.planetes.add(uranus);
        systemeSolaire.planetes.add(neptune);
        systemeSolaire.planetes.add(mercure);
        systemeSolaire.planetes.add(venus);
        systemeSolaire.planetes.add(terre);
        systemeSolaire.planetes.add(mars);



        for (Planete planete: systemeSolaire.planetes) {
            System.out.println(planete.nom);
        }

        mars.atmosphere = atmosphereMars;

        System.out.println("L'atmosphere de mars est constituée de : ");
        for (Map.Entry<String, Float> constituant: mars.atmosphere.constituant.entrySet()) {
            System.out.println(constituant.getValue() +"% de " +constituant.getKey());
        }

        Vaisseau chasseur = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        chasseur.nbPassagers = 2;

        Vaisseau fregate = new VaisseauDeGuerre(TypeVaisseau.FREGATE);
        fregate.nbPassagers = 25;

        Vaisseau croiseur = new VaisseauDeGuerre(TypeVaisseau.CROISEUR);
        croiseur.nbPassagers = 100;

        Vaisseau cargo = new VaisseauDeGuerre(TypeVaisseau.CARGO);
        cargo.nbPassagers = 500;

        Vaisseau vaisseauMonde = new VaisseauDeGuerre(TypeVaisseau.VAISSEAU_MONDE);
        vaisseauMonde.nbPassagers = 1000;

        Vaisseau chasseur1 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        Vaisseau chasseur2 = new VaisseauDeGuerre(TypeVaisseau.CHASSEUR);
        Vaisseau cargo1 = new VaisseauDeGuerre(TypeVaisseau.CARGO);

        terre.accueillirVaisseaux(chasseur1, chasseur2, cargo1);


        Scanner sc = new Scanner(System.in);
        boolean recommencer = true;

        while(recommencer) {
            System.out.println("Quel vaisseau souhaitez vous manipuler : CHASSEUR, FREGATE, CROISEUR, CARGO ou VAISSEAU-MONDE ?");
            String vaisseauSelectionne = sc.nextLine();
            TypeVaisseau typeVaisseau = TypeVaisseau.valueOf(vaisseauSelectionne);
            Vaisseau vaisseau = null;
            switch (typeVaisseau) {
                case CHASSEUR:
                    vaisseau = chasseur;
                    break;
                case FREGATE:
                    vaisseau = fregate;
                    break;
                case CROISEUR:
                    vaisseau = croiseur;
                    break;
                case CARGO:
                    vaisseau = cargo;
                    break;
                case VAISSEAU_MONDE:
                    vaisseau = vaisseauMonde;
                    break;
            }

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser ?");
            String nomPlanete = sc.nextLine();
            Planete planeteSelectionnee = null;

            for (Planete p : systemeSolaire.planetes) {
                if(p.nom.equals(nomPlanete)) {
                    planeteSelectionnee = p;
                    break;
                }
            }

            if(planeteSelectionnee instanceof PlaneteGazeuse) {
            System.out.println("Desolé, la planète selectionnée n'est pas une planète tellurique, impossible de se poser dessus");
                continue;
            }

            PlaneteTellurique planeteTellurique = (PlaneteTellurique) planeteSelectionnee;

            if (!planeteTellurique.restePlaceDisponible(vaisseau)) {
                System.out.println("Le vaisseau ne peut pas se poser sur la planete par manque de place dans la baie");
            } else {
                planeteTellurique.accueillirVaisseaux(vaisseau);
            }

            System.out.println("Quel tonnage souhaitez-vous emporter ?");
            int tonnageSouhaite = sc.nextInt();
            sc.nextLine();

            System.out.println("Le vaisseau a rejeté : " + vaisseau.emporterCargaison(tonnageSouhaite) + " tonnes.");

            System.out.println("Voulez-vous recommencer ?");
            recommencer = sc.nextLine().equals("oui");
        }
    }
}
