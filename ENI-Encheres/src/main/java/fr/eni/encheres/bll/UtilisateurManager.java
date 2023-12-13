package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	// L'instance unique est stockée en tant que variable privée statique
	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;

	/**
	 * Le constructeur est privé pour éviter la création d'instances via l'opérateur
	 * new
	 */
	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	/**
	 * Méthode statique pour obtenir l'instance unique de la classe
	 * 
	 * @return instance si existante ou création d'une nouvelle le cas échéant
	 */
	public static UtilisateurManager getInstance() {
		// Si l'instance n'a pas encore été créée, on en crée une nouvelle
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		// On retourne l'instance unique
		return instance;
	}

	/**
	 * Ajouter utilisateur
	 * 
	 * @param u
	 */
	public void addUser(Utilisateur u) {
		utilisateurDAO.insert(u);
	}

	/**
	 * Modifier un utilisateur
	 * 
	 * @param c
	 */
	public void updateUser(Utilisateur u, boolean n) {
		String password = u.getMotDePasse();
		boolean nP = n;
		if (nP == true) {
			u.setMotDePasse(Utilisateur.hashPwd(password));
		}
		utilisateurDAO.update(u);
	}

	/**
	 * Selectionner un utilisateur par son ID
	 * 
	 * @param id
	 * @return ID de l'utilisateur
	 */
	public Utilisateur selectById(Utilisateur u) {
		return utilisateurDAO.selectBy(u);
	}

	/**
	 * Suppression d'un utilisateur
	 * 
	 * @param id
	 */
	public void deleteUser(int id) {
		utilisateurDAO.delete(id);
	}

	/**
	 * Permet de vérifier si l'utilisateur existe dans la base de donnée
	 * 
	 * @param email
	 * @param password
	 * @param dbDriver
	 * @param dbUrl
	 * @param dbUser
	 * @param dbPassword
	 * @return
	 */
	public boolean userExists(String email, String password) {
		boolean utilisateurExiste = utilisateurDAO.verifierUtilisateur(email, Utilisateur.hashPwd(password));
		return utilisateurExiste;
	}

	/**
	 * Permet de vérifier si l'email renseigné est unique
	 * 
	 * @param email
	 * @return emailExists (true or false)
	 */
	public boolean emailIsUnique(String email) {
		boolean emailIsUnique = utilisateurDAO.singleEmailVerification(email);
		return emailIsUnique;
	}

	/**
	 * Permet de vérifier si le pseudo renseigné est unique
	 * 
	 * @param pseudo
	 * @return pseudoExists (true or false)
	 */
	public boolean pseudoIsUnique(String pseudo) {
		boolean pseudoIsUnique = utilisateurDAO.singlePseudoVerification(pseudo);
		return pseudoIsUnique;
	}

	/**
	 * Permet la création d'un objet Utilisateur à partir des informations de la DB.
	 * La récupération est faite à partir de son email (String).
	 * 
	 * @param email
	 * @return
	 */
	public Utilisateur createUserFromDB(String email) {
		Utilisateur u = utilisateurDAO.createUserFromDB(email);
		return u;
	}

}
