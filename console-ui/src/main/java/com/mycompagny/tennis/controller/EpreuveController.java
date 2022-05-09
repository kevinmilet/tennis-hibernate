package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.entity.Epreuve;
import com.mycompagny.tennis.core.service.EpreuveService;

public class EpreuveController {
    private final EpreuveService epreuveService;

    public EpreuveController() {
        this.epreuveService = new EpreuveService();
    }

    public void afficherDetailsEpreuve() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifiant de l'épreuve dont vous voulez les informations ?");
        long id = scanner.nextLong();
        scanner.close();
        Epreuve epreuve = epreuveService.getEpreuve(id);
        System.out.println("L'épreuve sélectionnée se déroule en " + epreuve.getAnnee() + " et il s'agit du tournoi "
                + epreuve.getTournoi().getNom());
    }

}
