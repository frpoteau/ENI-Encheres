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
	public Utilisateur selectById(Utilisateur u) {
		return utilisateurDAO.selectBy(u);
	}

	/**
	 * Suppression d'un utilisateur
	 * @param id
	 */
	public void deleteUtilisateur(Utilisateur u) {
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
	public boolean verifierUtilisateur(String email, String password, String dbDriver, String dbUrl, String dbUser, String dbPassword) {
        try {
        	// Charge le pilote JDBC spécifié dans le fichier de configuration
            Class.forName(dbDriver);
            
         // Établit la connexion à la base de données avec les informations fournies
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

         // Prépare une requête SQL pour vérifier les informations de connexion
            PreparedStatement ps = con.prepareStatement("SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?");
            ps.setString(1, email);
            ps.setString(2, password);

         // Exécute la requête et récupère le résultat
            ResultSet rs = ps.executeQuery();
            boolean utilisateurExiste;
            
            if(rs.next()) {
            	utilisateurExiste = true;
            }
            else{
            	utilisateurExiste = false;
            };
            
         // Ferme la connexion après utilisation
            con.close();

            return utilisateurExiste;
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        
    }
	
	/**
	 * Permet de récupérer le nombre de crédit de l'utilisateur
	 * @param email
	 * @param password
	 * @param dbDriver
	 * @param dbUrl
	 * @param dbUser
	 * @param dbPassword
	 * @return
	 */
	public int RecuperationCreditUtilisateur(Utilisateur u) {
		return utilisateurDAO.soldeCredit(u);
	}
}

