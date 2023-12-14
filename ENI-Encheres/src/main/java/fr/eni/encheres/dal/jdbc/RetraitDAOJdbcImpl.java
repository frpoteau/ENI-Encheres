package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO{
	
	private static final String SQL_SELECTBY_ID ="SELECT no_article, rue, code_postal, ville FROM RETRAITS WHERE no_article=? ";

	@Override
	public Retrait selectById(int idArticle) {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Retrait r = null;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBY_ID);
			rqt.setInt(1,  idArticle);
			rs = rqt.executeQuery();
			
			if(rs.next()) {
				r = new Retrait();
				r.setIdArticle(rs.getInt("no_article"));
				r.setRueLivraison(rs.getString("rue"));
				r.setCodePostalLivraison(rs.getString("code_postal"));
				r.setVilleLivraison(rs.getString("ville"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				JdbcTools.closeConnection(cnx);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return r;
	}
	
	

}
