package com.mycompagny.tennis;

import com.mycompagny.tennis.controller.EpreuveController;
import com.mycompagny.tennis.controller.JoueurController;
import com.mycompagny.tennis.controller.ScoreController;
import com.mycompagny.tennis.controller.TournoiController;

/**
 * @author k.milet
 */
public class UI {

	public static void main(String... args) {
		JoueurController joueurController = new JoueurController();
		TournoiController tournoiController = new TournoiController();
		ScoreController scoreController = new ScoreController();
		EpreuveController epreuveController = new EpreuveController();
		// joueurController.afficheDetailsJoueur();
		// joueurController.creerJoueur();
		// joueurController.renommeJoueur();
		// joueurController.changeSexe();
		// joueurController.supprimeJoueur();
		// tournoiController.afficherDetailsTournoi();
		// tournoiController.creerTournoi();
		// tournoiController.supprimeTournoi();
		// scoreController.afficheDetailsScore();
		epreuveController.afficherDetailsEpreuve();
	}
}
