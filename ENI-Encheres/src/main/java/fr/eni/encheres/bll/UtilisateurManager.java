package fr.eni.encheres.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	
	// L'instance unique est stockée en tant que variable privée statique
	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	
	
	/**
	 * Le constructeur est privé pour éviter la création d'instances via l'opérateur new
	 */
	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	/**
	 * Méthode statique pour obtenir l'instance unique de la classe
	 * @return instance si existante ou création d'une nouvelle le cas échéant
	 */
	public static UtilisateurManager getInstance() {
		// Si l'instance n'a pas encore été créée, on en crée une nouvelle
		if(instance==null) {
			instance = new UtilisateurManager();
		}
	// On retourne l'instance unique
	return instance;
	}
	
	/**
	 * Ajouter utilisateur
	 * @param u
	 */
	public void addUser(Utilisateur u) {
		utilisateurDAO.insert(u);
	}
	
	/**
	 * Modifier un utilisateur
	 * @param c
	 */
	public void updateUser(Utilisateur u) {
		utilisateurDAO.update(u);
	}

	/**
	 * Selectionner un utilisateur par son ID
	 * @param id
	 * @return ID de l'utilisateur
	 */
	public Utilisateur selectById(Utilisateur u) {
		return utilisateurDAO.selectBy(u);
	}

	/**
	 * Suppression d'un utilisateur
	 * @param id
	 */
	public void deleteUser(Utilisateur u) {
		utilisateurDAO.delete(u);
	}
	
	/**
	 * Permet de vérifier que l'email contient bien un @
	 * @param email
	 * @return
	 */
	public boolean verificationEmail(String email) {
		if (email.contains("@")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Permet de vérifier si l'utilisateur existe dans la base de donnée
	 * @param email
	 * @param password
	 * @param dbDriver
	 * @param dbUrl
	 * @param dbUser
	 * @param dbPassword
	 * @return
	 */
	public boolean userExists(String email, String password) {
        boolean utilisateurExiste = utilisateurDAO.verifierUtilisateur(email, password);
		return utilisateurExiste;
	}
	
	/**
	 * Permet de récupérer le nombre de crédit de l'utilisateur
	 * @param email
	 * @param password
	 * @param dbDriver
	 * @param dbUrl
	 * @param dbUser
	 * @param dbPassword
	 * @return la valeur du credit
	 */
	public int getCreditUser(String email) {
		int credit = utilisateurDAO.soldeCredit(email);
		return credit;
	}
}

