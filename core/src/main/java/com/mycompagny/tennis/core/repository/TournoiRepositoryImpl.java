package com.mycompagny.tennis.core.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Tournoi;

/**
 * @author k.milet
 */
public class TournoiRepositoryImpl {

    public Tournoi getById(Long id) {
	Tournoi tournoi = null;
	Session session = null;

	try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    tournoi = session.get(Tournoi.class, id);
	    System.out.println("Tournoi lu");
	} catch (Throwable t) {
	    t.printStackTrace();
	} finally {
	    if (session != null) {
		session.close();
	    }
	}
	return tournoi;
    }

    public void create(Tournoi tournoi) {
	Session session = null;
	Transaction tx = null;

	try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    tx = session.beginTransaction();
	    session.persist(tournoi);
	    tx.commit();

	    System.out.println("Tournoi créé");
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

//    public void update(Tournoi tournoi) {
//        Connection conn = null;
//        try {
//            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
//
//            conn = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE TOURNOI SET NOM = ? , CODE = ? WHERE ID = ?");
//
//            preparedStatement.setString(1, tournoi.getNom());
//            preparedStatement.setString(2, tournoi.getCode());
//            preparedStatement.setLong(3, tournoi.getId());
//
//            preparedStatement.executeUpdate();
//
//            System.out.println("Tournoi modifié");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                if (conn != null) conn.rollback();
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public void delete(Long id) {
	Session session = null;
	Tournoi tournoi = new Tournoi();
	tournoi.setId(id);
	try {
	    session = HibernateUtil.getSessionFactory().openSession();
	    session.delete(tournoi);
	    System.out.println("Tournoi supprimé");
	} catch (Throwable t) {
	    t.printStackTrace();

	} finally {
	    if (session != null) {
		session.close();
	    }
	}
    }

//    public List<Tournoi> getAll() {
//        Connection conn = null;
//        List<Tournoi> tournois = new ArrayList<>();
//
//        try {
//            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
//
//            conn = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM, CODE FROM TOURNOI");
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                Tournoi tournoi = new Tournoi();
//                tournoi.setId(rs.getLong("ID"));
//                tournoi.setNom(rs.getString("NOM"));
//                tournoi.setCode(rs.getString("CODE"));
//                tournois.add(tournoi);
//            }
//
//            System.out.println("Tournois lus");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                if (conn != null) conn.rollback();
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return tournois;
//    }
}
