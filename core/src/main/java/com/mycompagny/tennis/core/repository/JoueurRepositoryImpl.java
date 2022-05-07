package com.mycompagny.tennis.core.repository;

import org.hibernate.Session;

import com.mycompagny.tennis.core.HibernateUtil;
import com.mycompagny.tennis.core.entity.Joueur;

/**
 * @author k.milet
 */
public class JoueurRepositoryImpl {

    public Joueur getById(Long id) {
	Joueur joueur = null;
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	joueur = session.get(Joueur.class, id);
	System.out.println("Joueur lu");
	return joueur;
    }

    public Joueur create(Joueur joueur) {
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	session.persist(joueur);
	System.out.println("Joueur créé");
	return joueur;
    }

//    public void update(Joueur joueur) {
//        Connection conn = null;
//        try {
//            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
//
//            conn = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE JOUEUR SET NOM = ? , PRENOM = ?, SEXE = ? WHERE ID = ?");
//
//            preparedStatement.setString(1, joueur.getNom());
//            preparedStatement.setString(2, joueur.getPrenom());
//            preparedStatement.setString(3, joueur.getSexe().toString());
//            preparedStatement.setLong(4, joueur.getId());
//
//            preparedStatement.executeUpdate();
//
//            System.out.println("Joueur modifié");
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
//
//    public void delete(Long id) {
//        Connection conn = null;
//        try {
//            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
//
//            conn = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM JOUEUR WHERE ID = ?");
//
//            preparedStatement.setLong(1, id);
//
//            preparedStatement.executeUpdate();
//
//            System.out.println("Joueur supprimé");
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

//    public List<Joueur> getAll() {
//        Connection conn = null;
//        List<Joueur> joueurs = new ArrayList<>();
//
//        try {
//            DataSource dataSource =  DataSourceProvider.getSingleDataSourceInstance();
//
//            conn = dataSource.getConnection();
//
//            PreparedStatement preparedStatement = conn.prepareStatement("SELECT ID, NOM, PRENOM, SEXE FROM JOUEUR");
//
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                Joueur joueur = new Joueur();
//                joueur.setId(rs.getLong("ID"));
//                joueur.setNom(rs.getString("NOM"));
//                joueur.setPrenom(rs.getString("PRENOM"));
//                joueur.setSexe(rs.getString("SEXE").charAt(0));
//                joueurs.add(joueur);
//            }
//
//            System.out.println("Joueurs lus");
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
//        return joueurs;
//    }
}
