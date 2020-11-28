import java.util.Scanner;

public class HelloUniverse {
    public static void main(String... args) {
        PlaneteTellurique mercure = new PlaneteTellurique("Mercure", 1);
        mercure.diametre = 4880;

        PlaneteTellurique venus = new PlaneteTellurique("Venus", 2);
        venus.diametre = 12100;

        PlaneteTellurique mars = new PlaneteTellurique("Mars", 3);
        mars.diametre = 6792;

        PlaneteTellurique terre = new PlaneteTellurique("Terre", 10);
        terre.diametre = 12756;

        PlaneteGazeuse jupiter = new PlaneteGazeuse("Jupiter");
        jupiter.diametre=142984;

        PlaneteGazeuse saturne = new PlaneteGazeuse("Saturne");
        saturne.diametre = 120536;

        PlaneteGazeuse uranus = new PlaneteGazeuse("Uranus");
        uranus.diametre = 51118;

        PlaneteGazeuse neptune = new PlaneteGazeuse("Neptune");
        neptune.diametre = 49532;

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

        Scanner sc = new Scanner(System.in);
        String recommmencer;

        do
        {
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

            System.out.println("Sur quelle planète tellurique du systeme solaire voulez-vous vous poser : Mercure, Venus, Terre ou Mars ?");
            String nomPlanete = sc.nextLine();
            PlaneteTellurique planeteSelectionnee = null;
            switch (nomPlanete) {
                case "Mercure":
                    planeteSelectionnee = mercure;
                    break;
                case "Venus":
                    planeteSelectionnee = venus;
                    break;
                case "Terre":
                    planeteSelectionnee = terre;
                    break;
                case "Mars":
                    planeteSelectionnee = mars;
                    break;

            }

            if (!planeteSelectionnee.restePlaceDisponible()) {
                System.out.println("Le vaisseau ne peut pas se poser sur la planete par manque de place dans la baie");
            } else {
                planeteSelectionnee.accueillirVaisseau(vaisseau);
            }

            System.out.println("Quel tonnage souhaitez-vous emporter ?");
            int tonnageSouhaite = sc.nextInt();
            sc.nextLine();

            System.out.println("Le vaisseau a rejeté : " + vaisseau.emporterCargaison(tonnageSouhaite) + " tonnes.");

            System.out.println("Voulez-vous recommencer ?");
            recommmencer = sc.nextLine();

        } while(recommmencer.equalsIgnoreCase("oui"));
    }
}
