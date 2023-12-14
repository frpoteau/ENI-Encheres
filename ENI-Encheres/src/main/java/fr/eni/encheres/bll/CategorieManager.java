package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {

	private static CategorieManager instance;
	private CategorieDAO categorieDAO;

	/**
	 * Constructeur pour instance.
	 */
	private CategorieManager() {
		categorieDAO = DAOFactory.getCategorieDAO();
	}

	/**
	 * Permet la création de l'instance Categorie
	 * 
	 * @return
	 */
	public static CategorieManager getInstance() {
		if (instance == null) {
			instance = new CategorieManager();
		}
		return instance;
	}

	/**
	 * Permet de récupérer la liste des Catégories (libellé).
	 * 
	 * @return la liste
	 */
	public List<String> getValidCategories() {
		return categorieDAO.getValidCategories();
	}

	/**
	 * Permet de récupérer l'ID de la Catégorie via un Libellé.
	 * 
	 * @param categoryLabel
	 * @return ID de la catégorie
	 */
	public int getCategoryIdByLabel(String categoryLabel) {
		return categorieDAO.getCategoryIdByLabel(categoryLabel);
	};

}
