package com.mycompagny.tennis.core.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.dto.TournoiDto;
import com.mycompagny.tennis.core.entity.Tournoi;
import com.mycompagny.tennis.core.repository.TournoiRepositoryImpl;

public class TournoiService {

    private TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
	this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public void createTournoi(TournoiDto dto) {
	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    Tournoi tournoi = new Tournoi();
	    tournoi.setId(dto.getId());
	    tournoi.setNom(dto.getNom());
	    tournoi.setCode(dto.getCode());
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

    public TournoiDto getTournoi(Long id) {
	Session session = null;
	Transaction tx = null;
	Tournoi tournoi = null;
	TournoiDto dto = null;

	try {
	    session = HibernateUtil.getSessionFactory().getCurrentSession();
	    tx = session.beginTransaction();
	    tournoi = tournoiRepository.getById(id);
	    dto = new TournoiDto();
	    dto.setId(tournoi.getId());
	    dto.setNom(tournoi.getNom());
	    dto.setCode(tournoi.getCode());
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

//    public void renomme(Long id, String nouveauNom) {
//	Tournoi tournoi = this.getTournoi(id);
//
//	Session session = null;
//	Transaction tx = null;
//
//	try {
//	    session = HibernateUtil.getSessionFactory().getCurrentSession();
//	    tx = session.beginTransaction();
//	    tournoi.setNom(nouveauNom);
//	    session.merge(tournoi);
//
//	    tx.commit();
//	} catch (Exception e) {
//	    if (tx != null) {
//		tx.rollback();
//	    }
//	    e.printStackTrace();
//	} finally {
//	    if (session != null) {
//		session.close();
//	    }
//	}
//    }

//    public void changeCode(Long id, String code) {
//	Tournoi tournoi = this.getTournoi(id);
//
//	Session session = null;
//	Transaction tx = null;
//
//	try {
//	    session = HibernateUtil.getSessionFactory().getCurrentSession();
//	    tx = session.beginTransaction();
//	    tournoi.setCode(code);
//	    session.merge(tournoi);
//
//	    tx.commit();
//	} catch (Exception e) {
//	    if (tx != null) {
//		tx.rollback();
//	    }
//	    e.printStackTrace();
//	} finally {
//	    if (session != null) {
//		session.close();
//	    }
//	}
//    }

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
