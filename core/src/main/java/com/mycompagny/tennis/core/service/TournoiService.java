package com.mycompagny.tennis.core.service;

import com.mycompagny.tennis.core.entity.Tournoi;
import com.mycompagny.tennis.core.repository.TournoiRepositoryImpl;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
	this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public Tournoi createTournoi(Tournoi tournoi) {
	tournoiRepository.create(tournoi);
	return tournoi;
    }

    public Tournoi getTournoi(Long id) {
	return tournoiRepository.getById(id);
    }
}
