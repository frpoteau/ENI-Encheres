package fr.eni.encheres.bo;

public class Retrait {
	
	private int idArticle;
	private String rueLivraison;
	private String codePostalLivraison;
	private String villeLivraison;
	
	public Retrait() {
		
	}
	
	
	/**
	 * @param idArticle
	 * @param rueLivraison
	 * @param codePostalLivraison
	 * @param villeLivraison
	 */
	public Retrait (int idArticle, String rueLivraison, String codePostalLivraison, String villeLivraison) {
		this.idArticle=idArticle;
		this.rueLivraison = rueLivraison;
		this.codePostalLivraison = codePostalLivraison;
		this.villeLivraison = villeLivraison;
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
	 * Permet de modifier l'ID l'article. WARNING !! : cet ID est gérer par la
	 * DB !!
	 * 
	 * @param idArticle the idArticle to set
	 */
	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}


	/**
	 * Permet de récupérer le nom de la rue de livraison
	 * 
	 * @return the rue
	 */
	public String getRueLivraison() {
		return rueLivraison;
	}


	/**
	 * Permet de modifier le nom de la rue de livraison
	 * 
	 * @param rue the rue to set
	 */
	public void setRueLivraison(String rueLivraison) {
		this.rueLivraison = rueLivraison;
	}


	/**
	 * Permet de récupérer le code postal de livraison
	 * 
	 * @return the codePostal
	 */
	public String getCodePostalLivraison() {
		return codePostalLivraison;
	}


	/**
	 * Permet de modifier le code postal de livraison
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostalLivraison(String codePostalLivraison) {
		this.codePostalLivraison = codePostalLivraison;
	}


	/**
	 * Permet de récupérer la ville de livraison
	 * 
	 * @return the ville
	 */
	public String getVilleLivraison() {
		return villeLivraison;
	}


	/**
	 * Permet de modifier la ville de livraison
	 * 
	 * @param ville the ville to set
	 */
	public void setVilleLivraison(String villeLivraison) {
		this.villeLivraison = villeLivraison;
	}


	@Override
	public String toString() {
		return "Retrait [idArticle=" + idArticle + ", rueLivraison=" + rueLivraison + ", codePostalLivraison="
				+ codePostalLivraison + ", villeLivraison=" + villeLivraison + "]";
	}
	

	
}
