package com.mycompagny.tennis;

import com.mycompagny.tennis.controller.JoueurController;
import com.mycompagny.tennis.controller.TournoiController;

/**
 * @author k.milet
 */
public class UI {

    public static void main(String... args) {
	JoueurController joueurController = new JoueurController();
	TournoiController tournoiController = new TournoiController();
//	joueurController.afficheDetailsJoueur();
//	joueurController.creerJoueur();
	joueurController.renommeJoueur();
//	tournoiController.afficherDetailsTournoi();
//	tournoiController.creerTournoi();
    }
}
