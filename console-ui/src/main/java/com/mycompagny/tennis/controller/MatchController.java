package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.dto.MatchDto;
import com.mycompagny.tennis.core.service.MatchService;

public class MatchController {

    private final MatchService matchService;

    public MatchController() {
	this.matchService = new MatchService();
    }

    public void afficherDetailsMatch() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant du match dont vous voulez les informations ?");
	long id = scanner.nextLong();
	scanner.close();
	MatchDto matchDto = matchService.getMatch(id);
	System.out.println("Le vainqueur du match est " + matchDto.getVainqueur().getNom() + " et le finaliste est "
		+ matchDto.getFinaliste().getNom());
    }

}
