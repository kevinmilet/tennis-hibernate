package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.entity.Tournoi;
import com.mycompagny.tennis.core.service.TournoiService;

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
	Tournoi tournoi = tournoiService.getTournoi(id);
	System.out.println("Le touroi sélectionné est " + tournoi.getNom() + " " + tournoi.getCode());
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

	tournoiService.createTournoi(tournoi);
	System.out.println("Le tournoi " + tournoi.getNom() + " " + tournoi.getCode() + " a été créé avec l'id "
		+ tournoi.getId());
    }

    public void renommeTournoi() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant du tournoi que vous voulez renommer ?");
	long id = scanner.nextLong();
	scanner.nextLine();
	System.out.println("Nouveau nom ?");
	String nom = scanner.nextLine();
	tournoiService.renomme(id, nom);
    }

    public void changeCode() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant du tournoi dont vous voulez changer le code ?");
	long id = scanner.nextLong();
	scanner.nextLine();
	System.out.println("Nouveau code ?");
	String code = scanner.nextLine();
	tournoiService.changeCode(id, code);
    }

    public void supprimeTournoi() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant du tournoi à supprimer ?");
	long id = scanner.nextLong();
	tournoiService.deleteTournoi(id);
    }
}
