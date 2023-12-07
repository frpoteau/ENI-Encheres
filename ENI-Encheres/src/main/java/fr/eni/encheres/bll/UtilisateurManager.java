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

	private static UtilisateurManager instance;
	private UtilisateurDAO utilisateurDAO;
	
	
	/**
	 * Le constructeur permet d'initialiser la variable membre utilisateurDAO pour 
	 * permettre une communication avec la base de données. 
	 */
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
            boolean utilisateurExiste = rs.next();
            
         // Ferme la connexion après utilisation
            con.close();

            return utilisateurExiste;
            
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	
}
