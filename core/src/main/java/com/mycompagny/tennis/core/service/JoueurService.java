package com.mycompagny.tennis.core.service;

import com.mycompagny.tennis.core.entity.Joueur;
import com.mycompagny.tennis.core.repository.JoueurRepositoryImpl;

public class JoueurService {

    private final JoueurRepositoryImpl joueurRepository;

    public JoueurService() {
	this.joueurRepository = new JoueurRepositoryImpl();
    }

    public Joueur createJoueur(Joueur joueur) {
	return joueurRepository.create(joueur);
    }

    public Joueur getJoueur(Long id) {
	return joueurRepository.getById(id);
    }

    public void renomme(Long id, String nouveauNom) {
	joueurRepository.renomme(id, nouveauNom);
    }
}
