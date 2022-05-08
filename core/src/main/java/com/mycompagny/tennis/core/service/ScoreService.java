package com.mycompagny.tennis.core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Score;
import com.mycompagny.tennis.core.repository.ScoreRepositoryImpl;

/**
 * @author kevin
 *
 */
public class ScoreService {
    private final ScoreRepositoryImpl scoreRepository;

    public ScoreService() {
	this.scoreRepository = new ScoreRepositoryImpl();
    }

    public Score getScore(Long id) {
	Session session = null;
	Transaction tx = null;
	Score score = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    score = scoreRepository.getById(id);
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
	return score;
    }
}
