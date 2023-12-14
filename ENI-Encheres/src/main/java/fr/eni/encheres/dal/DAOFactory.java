package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.RetraitDAOJdbcImpl;
import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {

	
		public static ArticleDAO getArticleDAO() {
			
			return new ArticleDAOJdbcImpl();
		}
		
		public static UtilisateurDAO getUtilisateurDAO(){
			
			return new UtilisateurDAOJdbcImpl();
		}
		/**
		public static EnchereDAO getEnchereDAO() {
			
			return new EnchereDAOJdbcImpl();
		}
		*/
	
		public static RetraitDAO getRetraitDAO() {
			
			return new RetraitDAOJdbcImpl();
		}
	
}
