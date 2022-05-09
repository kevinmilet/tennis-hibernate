package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.entity.Joueur;
import com.mycompagny.tennis.core.service.JoueurService;

/**
 * @author k.milet
 */
public class JoueurController {

	private final JoueurService joueurService;

	public JoueurController() {
		this.joueurService = new JoueurService();
	}

	public void afficheDetailsJoueur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est l'identifiant du joueur dont vous voulez les informations ?");
		long id = scanner.nextLong();
		Joueur joueur = joueurService.getJoueur(id);
		System.out.println("Le joueur sélectionné s'appelle " + joueur.getPrenom() + " " + joueur.getNom());
		scanner.close();
	}

	public void creerJoueur() {
		Joueur joueur = new Joueur();

		Scanner scanner = new Scanner(System.in);

		System.out.println("Nom du joueur ?");
		String nom = scanner.nextLine();
		joueur.setNom(nom);

		System.out.println("Prénom du joueur ?");
		String prenom = scanner.nextLine();
		joueur.setPrenom(prenom);

		System.out.println("Sexe du joueur ?");
		Character sexe = scanner.nextLine().charAt(0);
		joueur.setSexe(sexe);

		joueurService.createJoueur(joueur);
		System.out.println(
				"Le joueur " + joueur.getPrenom() + " " + joueur.getNom() + " a été créé avec l'id " + joueur.getId());
		scanner.close();
	}

	public void renommeJoueur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est l'identifiant du joueur que vous voulez renommer ?");
		long id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Nouveau nom ?");
		String nom = scanner.nextLine();
		joueurService.renomme(id, nom);
		scanner.close();
	}

	public void changeSexe() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est l'identifiant du joueur dont vous voulez changer le sexe ?");
		long id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Nouveau sexe ?");
		Character sexe = scanner.nextLine().charAt(0);
		joueurService.changeSexe(id, sexe);
		scanner.close();
	}

	public void supprimeJoueur() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Quel est l'identifiant du joueur à supprimer ?");
		long id = scanner.nextLong();
		joueurService.deleteJoueur(id);
		scanner.close();
	}
}
