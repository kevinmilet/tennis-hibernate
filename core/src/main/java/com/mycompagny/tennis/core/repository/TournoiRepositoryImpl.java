package com.mycompagny.tennis.core.repository;

import org.hibernate.Session;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Tournoi;

/**
 * @author k.milet
 */
public class TournoiRepositoryImpl {

    public Tournoi getById(Long id) {
	Tournoi tournoi = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	tournoi = session.get(Tournoi.class, id);
	System.out.println("Tournoi lu");
	return tournoi;
    }

    public Tournoi create(Tournoi tournoi) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.persist(tournoi);
	System.out.println("Tournoi créé");
	return tournoi;
    }

    public void delete(Long id) {
//	Tournoi tournoi = getById(id);
	Tournoi tournoi = new Tournoi();
	tournoi.setId(id);
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.delete(tournoi);
	System.out.println("Tournoi supprimé");
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
