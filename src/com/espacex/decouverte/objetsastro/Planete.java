package com.espacex.decouverte.objetsastro;

public abstract class Planete implements Comparable {
    public String nom;
    public long diametre;
    public Atmosphere atmosphere;
    public float distanceEtoile;
    static String forme = "Sphérique";
    static int nbPlanetesDecouvertes;

    Planete(String nom) {
        this.nom = nom;
        nbPlanetesDecouvertes++;
    }

    final int revolution(int angle) {
        return angle/360;
    }

    final int rotation(int angle) {
        return angle/360;
    }


    static void expansion(double distance) {
        if(distance < 14) {
            System.out.println("Oh la la mais c'est super rapide !");
        } else {
            System.out.println("Je rêve ou c'est plus rapide que la lumière ?");
        }
    }

    @Override
    public int compareTo(Object o) {
        Planete autrePlanete = (Planete)o;
        return ((Float)distanceEtoile).compareTo(autrePlanete.distanceEtoile);
    }
}
