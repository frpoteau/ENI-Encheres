package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.ArticleDAOJdbcImpl;

import fr.eni.encheres.dal.jdbc.RetraitDAOJdbcImpl;

import fr.eni.encheres.dal.jdbc.CategorieDAOJdbcImpl;

import fr.eni.encheres.dal.jdbc.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {

		/*
		public static EnchereDAO getEnchereDAO() {
			
			return new EnchereDAOJdbcImpl();
		}
		*/
	
		public static RetraitDAO getRetraitDAO() {
			
			return new RetraitDAOJdbcImpl();
		}
	

	/**
	 * Permet la création d'une instance ArticleDAOJdbcImpl.
	 * 
	 * @return
	 */
	public static ArticleDAO getArticleDAO() {

		return new ArticleDAOJdbcImpl();
	}

	/**
	 * Permet la création d'une instance UtilisateurDAOJdbcImpl.
	 * 
	 * @return
	 */
	public static UtilisateurDAO getUtilisateurDAO() {

		return new UtilisateurDAOJdbcImpl();
	}

	/**
	 * Permet la création d'une instance CategorieDAOJdbcImpl.
	 */
	public static CategorieDAO getCategorieDAO() {

		return new CategorieDAOJdbcImpl();
	}

}
