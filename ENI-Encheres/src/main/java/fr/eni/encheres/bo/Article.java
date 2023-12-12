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
    private int numeroUtili;
    private int categorie;

    public Article() {
    }

    public Article(int idArticle, String nomArticle, String desc, LocalDate dateD, LocalTime heureD, LocalDate dateF, LocalTime heureF, int prixInit, int prixVente, int numeroUtili, int categorie) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.desc = desc;
        this.dateD = dateD;
        this.heureD = heureD;
        this.dateF = dateF;
        this.heureF = heureF;
        this.prixInit = prixInit;
        this.numeroUtili = numeroUtili;
        this.categorie = categorie;
    }

    public Article(String nomArticle, String desc, LocalDate dateD, LocalTime heureD, LocalDate dateF, LocalTime heureF, int prixInit, int prixVente, int numeroUtili, int categorie) {
        this.nomArticle = nomArticle;
        this.desc = desc;
        this.dateD = dateD;
        this.heureD = heureD;
        this.dateF = dateF;
        this.heureF = heureF;
        this.prixInit = prixInit;
        this.numeroUtili = numeroUtili;
        this.categorie = categorie;
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
                + ", heureD=" + heureD + ", dateF=" + dateF + ", heureF=" + heureF + ", prixInit=" + prixInit
                + ", numeroUtili=" + numeroUtili + ", categorie=" + categorie + "]";
    }
}