package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;

public class ArticleDAOJdbcImpl implements ArticleDAO {
	
	
	private static final String SQL_INSERT ="INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECTBY_ID ="SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente \"\r\n"
												+ " +\" FROM ARTICLES_VENDUS WHERE no_article=? ";
	private static final String SQL_SELECT_ALL ="SELECT no_article, nom_articles, descriptuion, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente \"\r\n"
												+ " +\" FROM ARTICLES_VENDUS";
	private static final String SQL_UPDATE ="UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=? WHERE no_article=?";
	private static final String SQL_DELETE ="DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	

	@Override
	public void insert(Article a) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_INSERT);
			rqt.setString(1, a.getNomArticle());
			rqt.setString(2,  a.getDesc());
			rqt.setLocalDate(3, a.getDateD());
			rqt.setLocalDate(4, a.getDateF());
			rqt.setInt(5, a.getPrixInit());
			rqt.setInt(6, a.getPrixVente());
			rqt.setInt(7, a.getNumeroUtili());
			rqt.setInt(8, a.getCategorie());
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
	public Article selectBy(Article a) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_SELECTBY_ID);
			rqt.setInt(1, a.getIdArticle());
			rqt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	
	@Override
	public List<Article> selectAll() {
		Connection cnx = null;
		Article a = null;
		List<Article> article = new ArrayList<>();
		ResultSet rs;
		Statement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.createStatement();
			rs=rqt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				article.add(a);
			}
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
		return article;
	}

	
	@Override
	public void update(Article a) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, a.getNomArticle());
			rqt.setString(2, a.getDesc());
			rqt.setLocalDate(3, a.getDateD());
			rqt.setLocalDate(4, a.getDateF());
			rqt.setInt(5, a.getPrixInit());
			rqt.setInt(6, a.getPrixVente());
			rqt.executeUpdate();
			JdbcTools.closeConnection(cnx);			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

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
	
	
}
