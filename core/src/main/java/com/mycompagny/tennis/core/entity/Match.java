package com.mycompagny.tennis.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "MATCH_TENNIS")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VAINQUEUR")
    private Joueur vainqueur;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_FINALISTE")
    private Joueur finaliste;
    @Transient
    private Epreuve epreuve;
    @Transient
    private Score score;

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Joueur getVainqueur() {
	return this.vainqueur;
    }

    public void setVainqueur(Joueur vainqueur) {
	this.vainqueur = vainqueur;
    }

    public Joueur getFinaliste() {
	return this.finaliste;
    }

    public void setFinaliste(Joueur finaliste) {
	this.finaliste = finaliste;
    }

    public Epreuve getEpreuve() {
	return this.epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
	this.epreuve = epreuve;
    }

    public Score getScore() {
	return this.score;
    }

    public void setScore(Score score) {
	this.score = score;
    }

}
