package com.mycompagny.tennis.core.dto;

/**
 * @author kevin
 *
 */
public class EpreuveFullDto {
    private Long id;
    private Short annee;
    private TournoiDto tournoi;
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

    public TournoiDto getTournoi() {
	return tournoi;
    }

    public void setTournoi(TournoiDto tournoi) {
	this.tournoi = tournoi;
    }

    public Character getTypeEpreuve() {
	return this.typeEpreuve;
    }

    public void setTypeEpreuve(Character typeEpreuve) {
	this.typeEpreuve = typeEpreuve;
    }

}
