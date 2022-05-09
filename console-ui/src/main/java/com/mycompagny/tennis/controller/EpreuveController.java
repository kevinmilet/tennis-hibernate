package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.dto.EpreuveFullDto;
import com.mycompagny.tennis.core.dto.EpreuveLightDto;
import com.mycompagny.tennis.core.service.EpreuveService;

public class EpreuveController {
    private final EpreuveService epreuveService;

    public EpreuveController() {
	this.epreuveService = new EpreuveService();
    }

    public void afficherDerniereEpreuve() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant de l'épreuve dont vous voulez les informations ?");
	long id = scanner.nextLong();
	scanner.close();
	EpreuveFullDto epreuve = epreuveService.getEpreuveAvecTournoi(id);
	System.out.println("Le nom du tournoi est " + epreuve.getTournoi().getNom());
    }

    public void afficherRolandGarros() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant de l'épreuve dont vous voulez les informations ?");
	long id = scanner.nextLong();
	scanner.close();
	EpreuveLightDto epreuve = epreuveService.getEpreuveSansTournoi(id);
//	System.out.println("Le nom du tournoi est " + epreuve.getTournoi().getNom());
    }
}
