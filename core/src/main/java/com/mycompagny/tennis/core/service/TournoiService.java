package com.mycompagny.tennis.core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Tournoi;
import com.mycompagny.tennis.core.repository.TournoiRepositoryImpl;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
	this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public void createTournoi(Tournoi tournoi) {
	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoiRepository.create(tournoi);
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
    }

    public Tournoi getTournoi(Long id) {
	Session session = null;
	Transaction tx = null;
	Tournoi tournoi = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoi = tournoiRepository.getById(id);
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
	return tournoi;
    }

    public void renomme(Long id, String nouveauNom) {
	Tournoi tournoi = this.getTournoi(id);

	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoi.setNom(nouveauNom);
	    session.merge(tournoi);

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
    }

    public void changeCode(Long id, String code) {
	Tournoi tournoi = this.getTournoi(id);

	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoi.setCode(code);
	    session.merge(tournoi);

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
    }

    public void deleteTournoi(Long id) {
	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoiRepository.delete(id);

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
    }
}
