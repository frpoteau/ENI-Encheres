package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {

	/**
	 * Permet l'ajout d'un utilisateur dans la base de donnée
	 * 
	 * @param u
	 */
	public void insert(Utilisateur u);

	/**
	 * Permet la sélection de l'utilisateur à partir de son ID
	 * 
	 * @param u
	 * @return
	 */
	public Utilisateur selectBy(Utilisateur u);

	/**
	 * Permet la sélection de tous les utilisateurs sous forme de liste
	 * 
	 * @return
	 */
	public List<Utilisateur> selectAll();

	/**
	 * Permet la mise à jour d'un utilisateur
	 * 
	 * @param u
	 */
	public void update(Utilisateur u);

	/**
	 * Permet la suppression d'un utilisateur
	 * 
	 * @param u
	 */
	public void delete(int id);

	/**
	 * Permet de vérifier si l'utilisateur existe ou non dans la DB en contrôlant le
	 * duo email/mot de passe
	 * 
	 * @param email
	 * @param password
	 * @return
	 */

	public boolean verifierUtilisateur(String email, String password);

	/**
	 * Vérifie si l'email est unique ou non si emailUnique est true alors il est
	 * unique
	 * 
	 * @param email
	 * @return
	 */
	public boolean singleEmailVerification(String email);

	/**
	 * Vérifie si le pseudo est unique ou non si pseudoUnique est true alors il est
	 * unique
	 * 
	 * @param pseudo
	 * @return
	 */
	public boolean singlePseudoVerification(String pseudo);

	/**
	 * Récupère les informations de l'utilisateur dans la DB et crée un
	 * "Utilisateur".
	 * 
	 * @param email
	 * @return
	 */
	public Utilisateur createUserFromDB(String email);

}
