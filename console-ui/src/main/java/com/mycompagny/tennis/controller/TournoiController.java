package com.mycompagny.tennis.controller;

import com.mycompagny.tennis.core.entity.Joueur;
import com.mycompagny.tennis.core.entity.Tournoi;
import com.mycompagny.tennis.core.service.TournoiService;

import java.util.Scanner;

/**
 * @author k.milet
 */
public class TournoiController {

    private final TournoiService tournoiService;

    public TournoiController() {
        this.tournoiService = new TournoiService();
    }

    public void afficherDetailsTournoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est l'identifiant du tournoi dont vous voulez les informations ?");
        long id = scanner.nextLong();
        Tournoi tounoi = tournoiService.getTournoi(id);
        System.out.println("Le touroi sélectionné est " + tounoi.getNom() + " " + tounoi.getCode());
    }

    public void creerTournoi() {
        Tournoi tournoi = new Tournoi();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nom du tournoi ?");
        String nom = scanner.nextLine();
        tournoi.setNom(nom);

        System.out.println("Code du tournoi ?");
        String code = scanner.nextLine();
        tournoi.setCode(code);

        Tournoi nouveauTournoi = tournoiService.createTournoi(tournoi);
        System.out.println("Le tournoi " + nouveauTournoi.getNom() + " " + nouveauTournoi.getCode() + " a été créé");
    }
}
