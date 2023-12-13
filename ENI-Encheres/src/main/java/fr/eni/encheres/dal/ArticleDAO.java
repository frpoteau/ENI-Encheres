package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {

	/**
	 * Permet l'ajout d'un article dans la DB.
	 * 
	 * @param a
	 */
	public void insert(Article a);

	/**
	 * Permet la sélection d'un article à partir de son ID.
	 * 
	 * @param articleId
	 * @return
	 */
	public Article selectById(int articleId);

	// public Article selectByArt(Article a); //TODO à voir si utile sinon à supprimer

	// public Article selectByArtDateDebut(Article a); //TODO à voir si utile sinon à supprimer

	/**
	 * Permet la sélection de tous les articles.
	 * 
	 * @return
	 */
	public List<Article> selectAll();

	/**
	 * Permet la modification d'un article à partir de son ID.
	 * 
	 * @param a
	 */
	public void update(Article a);

	/***
	 * Permet la suppression d'un article.
	 * 
	 * @param a
	 */
	public void delete(Article a);

	/**
	 * Permet la sélection de tous les articles d'un utilisateur à partir de son ID.
	 * 
	 * @param userId
	 * @return
	 */
	public List<Article> getMesArticles(int userId);

}
