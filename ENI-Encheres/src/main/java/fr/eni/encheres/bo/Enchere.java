package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Enchere {
	
	
	private int idUtilisateur;
	private int idArticle;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	
	public Enchere () {
		
	}
	
	/**
	 * @param idUtilisateur
	 * @param idArticle
	 * @param dateEnchere
	 * @param montantEnchere
	 */
	public Enchere (int idUtilisateur, int idArticle, LocalDate dateEnchere, int montantEnchere) {
		this.idUtilisateur=idUtilisateur;
		this.idArticle=idArticle;
		this.dateEnchere=dateEnchere;
		this.montantEnchere=montantEnchere;
	}

	/**
	 * Permet de récupérer l'ID de l'utilisateur
	 * 
	 * @return the idUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Permet de modifier l'ID de l'utilisateur WARNING !! : cet ID est gérer par la
	 * DB !!
	 * 
	 * @param idUtilisateur the idUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Permet de récupérer l'ID de l'article
	 * 
	 * @return the idArticle
	 */
	public int getIdArticle() {
		return idArticle;
	}

	/**
	 * Permet de modifier l'ID de l'article WARNING !! : cet ID est gérer par la
	 * DB !!
	 * 
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * Permet de récupérer la date d'enchère
	 * 
	 * @return the dateEnchere
	 */
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	/**
	 * Permet de modifier la date d'enchère
	 * 
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	/**
	 * Permet de récupérer le montant de l'enchère
	 * 
	 * @return the montantEnchere
	 */
	public int getMontantEnchere() {
		return montantEnchere;
	}

	/**
	 * Permet de modifier le montant de l'enchère
	 * 
	 * @param montantEnchere the montantEnchere to set
	 */
	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Enchere [idUtilisateur=" + idUtilisateur + ", idArticle=" + idArticle + ", dateEnchere=" + dateEnchere
				+ ", montantEnchere=" + montantEnchere + "]";
	}

}
