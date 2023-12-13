package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {

    private static final String SQL_INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, no_utilisateur, no_categorie, adresse_retrait) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    //private static final String SQL_UPDATE_IMAGE_PATH = "UPDATE ARTICLES_VENDUS SET image_path=? WHERE no_article=?";

    private static final String SQL_SELECTBY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, prix_vente, adresse_retrait FROM ARTICLES_VENDUS WHERE no_article=? ";

    private static final String SQL_SELECT_ART = "SELECT no_article, nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, prix_vente, adresse_retrait FROM ARTICLES_VENDUS WHERE no_utilisateur=? ";

    private static final String SQL_SELECT_ART_DATE_DEBUT = "SELECT no_article, nom_article, description, date_debut_encheres, heure_debut_encheres, prix_initial, prix_vente WHERE date_debut_encheres=? ";

    private static final String SQL_SELECT_ALL = "SELECT no_article, nom_articles, descriptuion, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, prix_vente, adresse_retrait FROM ARTICLES_VENDUS";

    private static final String SQL_UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, heure_debut_encheres=?,date_fin_encheres=?, heure_fin_encheres=?, prix_initial=?, prix_vente=?, adresse_retrait=? WHERE no_article=?";

    private static final String SQL_DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

    @Override
    public List<Article> selectAll() {
        Connection cnx = null;
        List<Article> articles = new ArrayList<>();
        ResultSet rs;
        Statement rqt;
        try {
            cnx = JdbcTools.getConnection();
            rqt = cnx.createStatement();
            rs = rqt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Article a = new Article();
                a.setIdArticle(rs.getInt("no_article"));
                a.setNomArticle(rs.getString("nom_article"));
                a.setDesc(rs.getString("description"));
                a.setDateD(rs.getDate("date_debut_encheres").toLocalDate());
                a.setHeureD(rs.getTime("heure_debut_encheres").toLocalTime());
                a.setDateF(rs.getDate("date_fin_encheres").toLocalDate());
                a.setHeureD(rs.getTime("heure_fin_encheres").toLocalTime());
                a.setPrixInit(rs.getInt("prix_initial"));
                a.setPrixFin(rs.getInt("prix_vente"));
                a.setNumeroUtili(rs.getInt("no_utilisateur"));
                a.setCategorie(rs.getInt("no_categorie"));
                a.setAdresseRetrait(rs.getString("adresse_retrait"));

                articles.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (cnx != null) {
                try {
                    JdbcTools.closeConnection(cnx);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return articles;
    }

	/**
	 * Permet la mise à jour d'un article
	 */
	@Override
	public void update(Article a) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, a.getNomArticle());
			rqt.setString(2, a.getDesc());
			rqt.setDate(3, Date.valueOf(a.getDateD()));
			rqt.setTime(4, Time.valueOf(a.getHeureD()));
			rqt.setDate(5, Date.valueOf(a.getDateF()));
			rqt.setTime(6, Time.valueOf(a.getHeureF()));
			rqt.setInt(7, a.getPrixInit());
			rqt.setInt(8, a.getCategorie());
			rqt.setString(8, a.getAdresseRetrait());
			rqt.executeUpdate();
			JdbcTools.closeConnection(cnx);			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet la suppression d'un article
	 */
	@Override
	public void delete(Article a) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, a.getIdArticle());
			rqt.executeUpdate();			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(cnx!=null) {
				try {
					JdbcTools.closeConnection(cnx);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void insert(Article a) {
	    Connection cnx = null;
	    PreparedStatement rqt;
	    try {
	        cnx = JdbcTools.getConnection();
	        rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
	        rqt.setString(1, a.getNomArticle());
	        rqt.setString(2, a.getDesc());
	        rqt.setDate(3, Date.valueOf(a.getDateD()));
	        rqt.setTime(4, Time.valueOf(a.getHeureD()));
	        rqt.setDate(5, Date.valueOf(a.getDateF()));
	        rqt.setTime(6, Time.valueOf(a.getHeureF()));
	        rqt.setInt(7, a.getPrixInit());
	        rqt.setInt(8, a.getNumeroUtili());
	        rqt.setInt(9, a.getCategorie());
	        rqt.setString(9, a.getAdresseRetrait());
	        rqt.executeUpdate();

	        // Récupérer la clé générée (ID de l'article)
	        ResultSet generatedKeys = rqt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            a.setIdArticle(generatedKeys.getInt(1));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (cnx != null) {
	            try {
	                JdbcTools.closeConnection(cnx);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	@Override
	public Article selectById(int articleId) {
	    Connection cnx = null;
	    PreparedStatement rqt;
	    ResultSet rs;
	    Article a = null;

	    try {
	        cnx = JdbcTools.getConnection();
	        rqt = cnx.prepareStatement(SQL_SELECTBY_ID);
	        rqt.setInt(1, articleId);
	        rs = rqt.executeQuery();

	        if (rs.next()) {
	            a = new Article();
	            a.setIdArticle(rs.getInt("no_article"));
	            a.setNomArticle(rs.getString("nom_article"));
	            a.setDesc(rs.getString("description"));
	            a.setDateD(rs.getDate("date_debut_encheres").toLocalDate());
	            a.setHeureD(rs.getTime("heure_debut_encheres").toLocalTime());
	            a.setDateF(rs.getDate("date_fin_encheres").toLocalDate());
	            a.setHeureF(rs.getTime("heure_fin_encheres").toLocalTime());
	            a.setPrixInit(rs.getInt("prix_initial"));
	            a.setPrixFin(rs.getInt("prix_vente"));
	            a.setNumeroUtili(rs.getInt("no_utilisateur"));
	            a.setCategorie(rs.getInt("no_categorie"));
	            a.setAdresseRetrait(rs.getString("adresse_retrait"));
	            // Ajoutez les autres attributs de la classe Article ici
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (cnx != null) {
	            try {
	                JdbcTools.closeConnection(cnx);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return a;
	}
	
}
