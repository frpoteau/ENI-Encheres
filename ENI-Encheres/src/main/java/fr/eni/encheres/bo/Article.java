package fr.eni.encheres.bo;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Article {
	private int idArticle;
	private String nomArticle;
	private String desc;
	private Date dateD;
	private Time heureD;
	private Date dateF;
	private Time heureF;
	private int prixInit;
	private int prixVente;
	private int numeroUtili;
	private int numeroCat;
	private String adresseRetrait;

	public Article() {
	}

	/**
	 * Constructeur Article SANS ID de l'article.
	 * 
	 * @param nomArticle
	 * @param desc
	 * @param dateD
	 * @param heureD
	 * @param dateF
	 * @param heureF
	 * @param prixInit
	 * @param prixVente
	 * @param numeroUtili
	 * @param categorie
	 * @param numeroCat
	 * @param adresseRetrait
	 */
	public Article(String nomArticle, String desc, Date dateD, Time heureD, Date dateF, Time heureF,
			int prixInit, int prixVente, int numeroUtili, int numeroCat, String adresseRetrait) {
		this.nomArticle = nomArticle;
		this.desc = desc;
		this.dateD = dateD;
		this.heureD = heureD;
		this.dateF = dateF;
		this.heureF = heureF;
		this.prixInit = prixInit;
		this.prixVente = prixVente;
		this.numeroUtili = numeroUtili;
		this.numeroCat = numeroCat;
		this.adresseRetrait = adresseRetrait;
	}

	/**
	 * Constructeur Article AVEC ID de l'article.
	 * 
	 * @param idArticle
	 * @param nomArticle
	 * @param desc
	 * @param dateD
	 * @param heureD
	 * @param dateF
	 * @param heureF
	 * @param prixInit
	 * @param prixVente
	 * @param numeroUtili
	 * @param categorie
	 * @param numeroCat
	 * @param adresseRetrait
	 */
	public Article(int idArticle, String nomArticle, String desc, Date dateD, Time heureD, Date dateF,
			Time heureF, int prixInit, int prixVente, int numeroUtili, int numeroCat, String adresseRetrait) {
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.desc = desc;
		this.dateD = dateD;
		this.heureD = heureD;
		this.dateF = dateF;
		this.heureF = heureF;
		this.prixInit = prixInit;
		this.prixVente = prixVente;
		this.numeroUtili = numeroUtili;
		this.numeroCat = numeroCat;
		this.adresseRetrait = adresseRetrait;

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

	public Date getDateD() {
		return dateD;
	}

	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}

	public Time getHeureD() {
		return heureD;
	}

	public void setHeureD(Time heureD) {
		this.heureD = heureD;
	}

	public Date getDateF() {
		return dateF;
	}

	public void setDateF(Date dateF) {
		this.dateF = dateF;
	}

	public Time getHeureF() {
		return heureF;
	}

	public void setHeureF(Time heureF) {
		this.heureF = heureF;
	}

	public int getPrixInit() {
		return prixInit;
	}

	public void setPrixInit(int prixInit) {
		this.prixInit = prixInit;
	}

	public int getPrixFin() {
		return prixVente;
	}

	public void setPrixFin(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getNumeroUtili() {
		return numeroUtili;
	}

	public void setNumeroUtili(int numeroUtili) {
		this.numeroUtili = numeroUtili;
	}

	public int getNumeroCat() {
		return numeroCat;
	}

	public void setNumeroCat(int numeroCat) {
		this.numeroCat = numeroCat;
	}

	public String getAdresseRetrait() {
		return adresseRetrait;
	}

	public void setAdresseRetrait(String adresseRetrait) {
		this.adresseRetrait = adresseRetrait;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle + ", desc=" + desc + ", dateD=" + dateD
				+ ", heureD=" + heureD + ", dateF=" + dateF + ", heureF=" + heureF + ", prixInit=" + prixInit
				+ ", prixVente=" + prixVente + ", numeroUtili=" + numeroUtili + ", numeroCat=" + numeroCat
				+ ", adresseRetrait=" + adresseRetrait + "]";
	}

}