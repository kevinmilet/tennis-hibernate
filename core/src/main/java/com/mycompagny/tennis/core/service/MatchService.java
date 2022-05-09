package com.mycompagny.tennis.core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.dto.JoueurDto;
import com.mycompagny.tennis.core.dto.MatchDto;
import com.mycompagny.tennis.core.entity.Match;
import com.mycompagny.tennis.core.repository.MatchRepositoryImpl;
import com.mycompagny.tennis.core.repository.ScoreRepositoryImpl;

public class MatchService {

    private final ScoreRepositoryImpl scoreRepository;
    private final MatchRepositoryImpl matchRepository;

    public MatchService() {
	this.scoreRepository = new ScoreRepositoryImpl();
	this.matchRepository = new MatchRepositoryImpl();
    }

    public MatchDto getMatch(Long id) {
	Session session = null;
	Transaction tx = null;
	Match match = null;
	MatchDto dto = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    match = matchRepository.getById(id);

	    JoueurDto vainqueurDto = new JoueurDto();
	    vainqueurDto.setId(match.getVainqueur().getId());
	    vainqueurDto.setNom(match.getVainqueur().getNom());
	    vainqueurDto.setPrenom(match.getVainqueur().getPrenom());
	    vainqueurDto.setSexe(match.getVainqueur().getSexe());

	    JoueurDto finalisteDto = new JoueurDto();
	    finalisteDto.setId(match.getFinaliste().getId());
	    finalisteDto.setNom(match.getFinaliste().getNom());
	    finalisteDto.setPrenom(match.getFinaliste().getPrenom());
	    finalisteDto.setSexe(match.getFinaliste().getSexe());

	    dto = new MatchDto();
	    dto.setId(match.getId());
	    dto.setVainqueur(vainqueurDto);
	    dto.setFinaliste(finalisteDto);

	    tx.commit();
	} catch (Exception e) {
	    if (tx != null) {
		tx.rollback();
	    }
	    e.printStackTrace();
	} finally {
	    if (session != null) {
		session.close();
	    }
	}
	return dto;
    }

    public void enregistrerNouveauMatch(Match match) {
	matchRepository.create(match);
	scoreRepository.create(match.getScore());
    }

}
