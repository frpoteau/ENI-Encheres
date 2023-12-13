package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Article {
    private int idArticle;
    private String nomArticle;
    private String desc;
    private LocalDate dateD;
    private LocalTime heureD;
    private LocalDate dateF;
    private LocalTime heureF;
    private int prixInit;
    private int prixFin;
    private int numeroUtili;
    private String categorie;
    private int numeroCat;
    private String adresseRetrait;

    public Article() {
    }

    public Article(int idArticle, String nomArticle, String desc, LocalDate dateD, LocalTime heureD, LocalDate dateF, LocalTime heureF, int prixInit, int prixVente, int prixFin, int numeroUtili, String categorie, int numeroCat, String adresseRetrait) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.desc = desc;
        this.dateD = dateD;
        this.heureD = heureD;
        this.dateF = dateF;
        this.heureF = heureF;
        this.prixInit = prixInit;
        this.prixFin = prixFin;
        this.numeroUtili = numeroUtili;
        this.categorie = categorie;
        this.numeroCat = numeroCat;
        this.adresseRetrait = adresseRetrait;
    }

    public Article(String nomArticle, String desc, LocalDate dateD, LocalTime heureD, LocalDate dateF, LocalTime heureF, int prixInit, int prixFin, int prixVente, int numeroUtili, String categorie, int numeroCat, String adresseRetrait) {
        this.nomArticle = nomArticle;
        this.desc = desc;
        this.dateD = dateD;
        this.heureD = heureD;
        this.dateF = dateF;
        this.heureF = heureF;
        this.prixInit = prixInit;
        this.prixFin = prixFin;
        this.numeroUtili = numeroUtili;
        this.categorie = categorie;
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

    public LocalDate getDateD() {
        return dateD;
    }

    public void setDateD(LocalDate dateD) {
        this.dateD = dateD;
    }

    public LocalTime getHeureD() {
        return heureD;
    }

    public void setHeureD(LocalTime heureD) {
        this.heureD = heureD;
    }

    public LocalDate getDateF() {
        return dateF;
    }

    public void setDateF(LocalDate dateF) {
        this.dateF = dateF;
    }

    public LocalTime getHeureF() {
        return heureF;
    }

    public void setHeureF(LocalTime heureF) {
        this.heureF = heureF;
    }

    public int getPrixInit() {
        return prixInit;
    }

    public void setPrixInit(int prixInit) {
        this.prixInit = prixInit;
    }
    
    public int getPrixFin() {
    	return prixFin;
    }
    
    public void setPrixFin(int prixFin) {
    	this.prixFin = prixFin;
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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
                + ", numeroUtili=" + numeroUtili + ", categorie=" + categorie + ", adresseRetrait=" + adresseRetrait + "]";
    }
}