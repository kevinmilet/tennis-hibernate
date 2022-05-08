package com.mycompagny.tennis.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short annee;
    @Transient
    private Tournoi tournoi;
    @Column(name = "TYPE_EPREUVE")
    private Character typeEpreuve;

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Short getAnnee() {
	return this.annee;
    }

    public void setAnnee(Short annee) {
	this.annee = annee;
    }

    public Tournoi getTournoi() {
	return this.tournoi;
    }

    public void setTournoi(Tournoi tournoi) {
	this.tournoi = tournoi;
    }

    public Character getTypeEpreuve() {
	return this.typeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
	this.typeEpreuve = typeEpreuve;
    }

}
