package com.mycompagny.tennis.core.repository;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Epreuve;

import org.hibernate.Session;

public class EpreuveRepositoryImpl {

    public Epreuve getById(Long id) {
        Epreuve epreuve = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        epreuve = session.get(Epreuve.class, id);
        System.out.println("Epreuve lu");
        return epreuve;
    }
}
