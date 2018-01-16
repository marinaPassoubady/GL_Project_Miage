package com.parisdescartes.scrib.entities;



public class Categorie {
	
	private static final String 
	ENVIRONNEMENT = "Environnement",
    HUMANITAIRE = "Humanitaire",
    POLITIQUE  = "Politique",
    DIVERTISSEMENT = "Divertissement",
    ARTISTIQUE = "Artistique",
    AUTRE = "Autre";
	
	public static String getCategoryColor(String c) {
		switch (c) {
		case ENVIRONNEMENT : 
				return "green";
		case HUMANITAIRE :
				return "blue";
		case POLITIQUE : 
				return "red";
	
		case DIVERTISSEMENT : 
				return "violet";

		case ARTISTIQUE : 
				return "yellow";

		case AUTRE : default : 
				return "grey";
		}
	}

}
