package com.mycompagny.tennis.controller;

import java.util.Scanner;

import com.mycompagny.tennis.core.entity.Score;
import com.mycompagny.tennis.core.service.ScoreService;

/**
 * @author kevin
 *
 */
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController() {
	this.scoreService = new ScoreService();
    }

    public void afficheDetailsScore() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Quel est l'identifiant du score dont vous voulez les informations ?");
	long id = scanner.nextLong();
	Score score = scoreService.getScore(id);
//	System.out.println("Les scores du match sélectionné sont " + score.getSet1() + ", " + score.getSet2()
//		+ (score.getSet3() != null ? ", " + score.getSet3() : "")
//		+ (score.getSet4() != null ? ", " + score.getSet4() : "")
//		+ (score.getSet5() != null ? ", " + score.getSet5() : ""));
	System.out.println("Les scores du match sélectionné sont:");
	System.out.println(score.getSet1());
	System.out.println(score.getSet2());
	System.out.println(score.getSet3() != null ? score.getSet3() : "");
	System.out.println(score.getSet4() != null ? score.getSet4() : "");
	System.out.println(score.getSet5() != null ? score.getSet5() : "");
    }
}
