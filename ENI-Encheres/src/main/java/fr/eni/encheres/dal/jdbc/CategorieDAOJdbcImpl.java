package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;

public class CategorieDAOJdbcImpl implements CategorieDAO {

	private static final String SQL_SELECTBY_LIBELLE = "SELECT no_categorie FROM CATEGORIES WHERE libelle = ?";

	private static final String SQL_SELECT_LIBELLE = "SELECT libelle FROM CATEGORIES";

	/**
	 * Permet de récupérer la liste des Catégories (libellé).
	 * 
	 * @return la liste
	 */
	@Override
	public List<String> getValidCategories() {
		List<String> categories = new ArrayList<>();
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECT_LIBELLE);
			rs = rqt.executeQuery();

			while (rs.next()) {
				String categoryLabel = rs.getString("libelle");
				categories.add(categoryLabel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeResources(cnx, rqt, rs);
		}
		return categories;
	}

	/**
	 * Permet de récupérer l'ID de la Catégorie via un Libellé.
	 * 
	 * @param categoryLabel
	 * @return ID de la catégorie
	 */
	@Override
	public int getCategoryIdByLabel(String categoryLabel) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		int categoryId = -1;

		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBY_LIBELLE);
			rqt.setString(1, categoryLabel);
			rs = rqt.executeQuery();

			if (rs.next()) {
				categoryId = rs.getInt("no_categorie");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcTools.closeResources(cnx, rqt, rs);
		}
		return categoryId;
	}

}
