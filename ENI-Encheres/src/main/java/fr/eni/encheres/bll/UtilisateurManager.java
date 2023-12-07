package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	
	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public static UtilisateurManager getInstance() {
		if(instance==null) {
			instance = new UtilisateurManager();
		}
	return instance;
	}
	
	/**
	 * Ajouter utilisateur
	 * @param u
	 */
	public void ajouterUtilisateur(Utilisateur u) {
		utilisateurDAO.insert(u);
	}
	
	/**
	 * Modifier un utilisateur
	 * @param c
	 */
	public void modifierUtilisateur(Utilisateur u) {
		utilisateurDAO.update(u);
	}

	/**
	 * Selectionner un utilisateur par son ID
	 * @param id
	 * @return ID de l'utilisateur
	 */
	public Utilisateur selectById(int id) {
		return utilisateurDAO.selectBy(id);
	}

	/**
	 * Suppression d'un utilisateur
	 * @param id
	 */
	public void deleteUtilisateur(int id) {
		utilisateurDAO.delete(id);
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
}
