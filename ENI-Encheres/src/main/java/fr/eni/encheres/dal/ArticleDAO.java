package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.Article;

public interface ArticleDAO {

	public void insert(Article a);
	
	Article selectById(int articleId);
	
	public Article selectByArt(Article a);
	
	public Article selectByArtDateDebut(Article a);
	
	public List<Article> selectAll();
	
	public void update(Article a);
	
	public void delete(Article a);
	
}
