package fr.eni.encheres.bo;

public class Categorie {
	private int idCategories;
	private String libelle;

	public Categorie() {
	}

	/**
	 * constructeur sans ID catégories
	 * 
	 * @param libelle
	 */
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}

	/**
	 * Constructeur AVEC ID categories
	 * 
	 * @param idCategories
	 * @param libelle
	 */
	public Categorie(int idCategories, String libelle) {
		this(libelle);
		this.idCategories = idCategories;
	}

	/**
	 * @return the idCategories
	 */
	public int getIdCategories() {
		return idCategories;
	}

	/**
	 * @param idCategories the idCategories to set
	 */
	public void setIdCategories(int idCategories) {
		this.idCategories = idCategories;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Categories [idCategories=" + idCategories + ", libelle=" + libelle + "]";
	}

}
