package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager 
{
	private static ArticleManager instance;
	private ArticleDAO articleDAO;
	
	
	private ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}

	//Obtenir l'instance unique
	/**
	 * Obtenir l'instance unique
	 * @return
	 */
	public static ArticleManager getArticleManager() {
		if(instance == null) 
		{			
			instance = new ArticleManager();
		}
		return instance;
	}

	/**
	 * Ajouter un article
	 * @param a
	 */
	public void ajouterArticle(Article a) {
		articleDAO.insert(a);
	}

	//Selection article par ID
	/**
	 * Selection article par ID
	 * @param articleId L'ID de l'article à sélectionner
	 * @return L'article correspondant à l'ID
	 */
	public Article selectById(int articleId) {
	    return articleDAO.selectById(articleId);
	}

	//Selection de la liste de tous les articles
	/**
	 * Selection de la liste de tous les articles
	 * @return
	 */
	public List<Article> selectAll () {
		return articleDAO.selectAll();
	}

	//Modification d'un article
	/**
	 * Modification d'un article
	 * @param a
	 */
	public void updateArticle (Article a) {
		articleDAO.update(a);
	}

	//Suppression d'un article
	/**
	 * Suppression d'un article
	 * @param a
	 */
	public void deleteArticle (Article a) {
		articleDAO.delete(a);
	}
	
}