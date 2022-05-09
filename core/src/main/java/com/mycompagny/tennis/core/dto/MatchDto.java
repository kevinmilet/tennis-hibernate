package com.mycompagny.tennis.core.dto;

public class MatchDto {
    private Long id;
    private JoueurDto vainqueur;
    private JoueurDto finaliste;

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public JoueurDto getVainqueur() {
	return vainqueur;
    }

    public JoueurDto getFinaliste() {
	return finaliste;
    }

    public void setFinaliste(JoueurDto finaliste) {
	this.finaliste = finaliste;
    }

    public void setVainqueur(JoueurDto vainqueur) {
	this.vainqueur = vainqueur;
    }

}
