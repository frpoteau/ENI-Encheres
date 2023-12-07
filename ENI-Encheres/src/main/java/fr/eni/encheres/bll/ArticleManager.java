package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Article;
import fr.eni.encheres.dal.ArticleDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {

	private static ArticleManager instance;
	private ArticleDAO articleDAO;
	
	
	//
	private ArticleManager() {
		articleDAO = DAOFactory.getArticleDAO();
	}
	
	//Obtenir l'instance unique
	public static ArticleManager getArticleManager() {
		if(instance == null) {
			instance = new ArticleManager();
		}
		return instance;
	}
	
	//Ajouter un article
	public void ajouterArticle(Article a) {
		articleDAO.insert(a);
	}
	
	//Selection article par ID
	public Article selectById (Article a) {
		return articleDAO.selectBy(a);
	}
	
	//Selection de la liste de tous les articles
	public List<Article> selectAll () {
		return articleDAO.selectAll();
	}
	
	//Modification d'un article
	public void updateArticle (Article a) {
		articleDAO.update(a);
	}
	
	//Suppression d'un article
	public void deleteArticle (Article a) {
		articleDAO.delete(a);
	}
	
}
