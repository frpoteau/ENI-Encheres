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

	private static final String SQL_INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, no_utilisateur, no_categorie, adresse_retrait) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// private static final String SQL_UPDATE_IMAGE_PATH = "UPDATE ARTICLES_VENDUS
	// SET image_path=? WHERE no_article=?";

	private static final String SQL_SELECTBY_ID = "SELECT no_article, nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, adresse_retrait FROM ARTICLES_VENDUS WHERE no_article=? ";

	// private static final String SQL_SELECT_ART = "SELECT no_article, nom_article,
	// description, date_debut_encheres, heure_debut_encheres, date_fin_encheres,
	// heure_fin_encheres, prix_initial, adresse_retrait FROM ARTICLES_VENDUS WHERE
	// no_utilisateur=? ";

	// private static final String SQL_SELECT_ART_DATE_DEBUT = "SELECT no_article,
	// nom_article, description, date_debut_encheres, heure_debut_encheres,
	// prix_initial FROM ARTICLES_VENDUS WHERE date_debut_encheres=? ";

	private static final String SQL_SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, heure_debut_encheres, date_fin_encheres, heure_fin_encheres, prix_initial, catégorie, adresse_retrait FROM ARTICLES_VENDUS";

	private static final String SQL_SELECT_ALL_BY_USERID = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ?";

	private static final String SQL_UPDATE = "UPDATE ARTICLES_VENDUS SET nom_article=?, description=?, date_debut_encheres=?, heure_debut_encheres=?,date_fin_encheres=?, heure_fin_encheres=?, prix_initial=?, catégorie=?, adresse_retrait=? WHERE no_article=?";

	private static final String SQL_DELETE = "DELETE FROM ARTICLES_VENDUS WHERE no_article=?";

	@Override
	public void insert(Article a) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

			rqt.setString(1, a.getNomArticle());
			rqt.setString(2, a.getDesc());
			rqt.setDate(3, a.getDateD());
			rqt.setTime(4, a.getHeureD());
			rqt.setDate(5, a.getDateF());
			rqt.setTime(6, a.getHeureF());
			rqt.setInt(7, a.getPrixInit());
			rqt.setInt(8, a.getNumeroUtili());
			rqt.setInt(9, a.getNumeroCat());
			rqt.setString(10, a.getAdresseRetrait());
			rqt.executeUpdate();

			// Récupérer la clé générée (ID de l'article)
			rs = rqt.getGeneratedKeys();
			if (rs.next()) {
				a.setIdArticle(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeResources(cnx, rqt, rs);
		}
	}

	/*
	 * // Préparation de la requête avec les valeurs du formulaire preparedStatement
	 * = connection.prepareStatement(insertQuery); preparedStatement.setString(1,
	 * nomArticle); preparedStatement.setString(2, desc);
	 * preparedStatement.setDate(3, dateDebut); preparedStatement.setTime(4,
	 * formattedHeureDebut); preparedStatement.setDate(5, dateFin);
	 * preparedStatement.setTime(6, formattedHeureFin);
	 * preparedStatement.setString(7, prixInit); preparedStatement.setString(8,
	 * adresseRetrait); preparedStatement.setInt(9, userId); // 'no_utilisateur'
	 * preparedStatement.setInt(10, categorieId); // 'no_categorie'
	 * 
	 * preparedStatement.setBytes(11, imageData);
	 * 
	 */

	@Override
	public List<Article> selectAll() {
		Connection cnx = null;
		List<Article> articles = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_ALL);
			rs = rqt.executeQuery();
			while (rs.next()) {
				Article a = new Article();
				a.setIdArticle(rs.getInt("no_article"));
				a.setNomArticle(rs.getString("nom_article"));
				a.setDesc(rs.getString("description"));
				a.setDateD(rs.getDate("date_debut_encheres"));
				a.setHeureD(rs.getTime("heure_debut_encheres"));
				a.setDateF(rs.getDate("date_fin_encheres"));
				a.setHeureF(rs.getTime("heure_fin_encheres"));
				a.setPrixInit(rs.getInt("prix_initial"));
				a.setNumeroCat(rs.getInt("categorie"));
				a.setAdresseRetrait(rs.getString("adresse_retrait"));

				articles.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeResources(cnx, null, rs);
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
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, a.getNomArticle());
			rqt.setString(2, a.getDesc());
			rqt.setDate(3, a.getDateD());
			rqt.setTime(4, a.getHeureD());
			rqt.setDate(5, a.getDateF());
			rqt.setTime(6, a.getHeureF());
			rqt.setInt(7, a.getPrixInit());
			rqt.setInt(8, a.getNumeroCat());
			rqt.setString(9, a.getAdresseRetrait());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcTools.closeConnection(cnx);
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, a.getIdArticle());
			rqt.executeUpdate();
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
		PreparedStatement rqt = null;
		ResultSet rs = null;
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
				a.setDateD(rs.getDate("date_debut_encheres"));
				a.setHeureD(rs.getTime("heure_debut_encheres"));
				a.setDateF(rs.getDate("date_fin_encheres"));
				a.setHeureF(rs.getTime("heure_fin_encheres"));
				a.setPrixInit(rs.getInt("prix_initial"));
				//a.setPrixFin(rs.getInt("prix_vente"));
				//a.setNumeroUtili(rs.getInt("no_utilisateur"));
				//a.setNumeroCat(rs.getInt("no_categorie"));
				//a.setAdresseRetrait(rs.getString("adresse_retrait"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeResources(cnx, rqt, rs);
		}

		return a;
	}

	@Override
	public List<Article> getMesArticles(int userId) {
		List<Article> mesArticles = new ArrayList<>();

		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_ALL_BY_USERID);
			rqt.setInt(1, userId);
			rs = rqt.executeQuery();

			while (rs.next()) {
				Article article = resultSetToArticle(rs);
				mesArticles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			JdbcTools.closeResources(cnx, rqt, rs);
		}

		return mesArticles;
	}

	/**
	 * Permet la conversion du ResulSet en objet Article.
	 * 
	 * @param resultSet
	 * @return
	 * @throws SQLException
	 */
	private static Article resultSetToArticle(ResultSet resultSet) throws SQLException {
		Article a = new Article();

		a.setIdArticle(resultSet.getInt("no_article"));
		a.setNomArticle(resultSet.getString("nom_article"));
		a.setDesc(resultSet.getString("description"));
		a.setDateD(resultSet.getDate("date_debut_encheres"));
		a.setDateF(resultSet.getDate("date_fin_encheres"));
		a.setPrixInit(resultSet.getInt("prix_initial"));
		// a.setPrixVente(resultSet.getInt("prix_vente"));
		a.setNumeroUtili(resultSet.getInt("no_utilisateur"));
		a.setNumeroCat(resultSet.getInt("no_categorie"));
		// a.setCategorie(resultSet.getString("categorie"));
		a.setHeureD(resultSet.getTime("heure_debut_encheres"));
		a.setHeureF(resultSet.getTime("heure_fin_encheres"));
		a.setAdresseRetrait(resultSet.getString("adresse_retrait"));

		return a;
	}

}
