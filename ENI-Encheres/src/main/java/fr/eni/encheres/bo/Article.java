package fr.eni.encheres.bo;

import java.time.LocalDate;

public class Article {

	private int idArticle;
	private String nomArticle;
	private String desc;
	private LocalDate dateD;
	private LocalDate dateF;
	private int prixInit;
	private int prixVente;
	private int numeroUtili;
	private int categorie;



	public Article() {

	}


	public Article(int idArticle, String nomArticle, String desc, LocalDate dateD, LocalDate dateF, int prixInit, int prixVente, int numeroUtili, int categorie) {
		this.idArticle=idArticle;
		this.nomArticle=nomArticle;
		this.desc=desc;
		this.dateD=dateD;
		this.dateF=dateF;
		this.prixInit=prixInit;
		this.prixVente=prixVente;
		this.numeroUtili=numeroUtili;
		this.categorie=categorie;
	}


	public Article( String nomArticle, String desc, LocalDate dateD, LocalDate dateF, int prixInit, int prixVente, int numeroUtili, int categorie) {
			this.nomArticle=nomArticle;
			this.desc=desc;
			this.dateD=dateD;
			this.dateF=dateF;
			this.prixInit=prixInit;
			this.prixVente=prixVente;
			this.numeroUtili=numeroUtili;
			this.categorie=categorie;
	}


	public int getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public LocalDate getDateD() {
		return dateD;
	}

	public void setDateD(LocalDate dateD) {
		this.dateD = dateD;
	}

	public LocalDate getDateF() {
		return dateF;
	}

	public void setDateF(LocalDate dateF) {
		this.dateF = dateF;
	}

	public int getPrixInit() {
		return prixInit;
	}

	public void setPrixInit(int prixInit) {
		this.prixInit = prixInit;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNumeroUtili() {
		return numeroUtili;
	}

	public void setNumeroUtili(int numeroUtili) {
		this.numeroUtili = numeroUtili;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", desc=" + desc + ", dateD=" + dateD
				+ ", dateF=" + dateF + ", prixInit=" + prixInit + ", prixVente=" + prixVente + ", numeroUtili="
				+ numeroUtili + ", categorie=" + categorie + "]";
	}

}
