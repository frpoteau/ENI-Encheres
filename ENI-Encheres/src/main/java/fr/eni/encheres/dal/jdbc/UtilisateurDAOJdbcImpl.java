package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SQL_INSERT = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String SQL_SELECTBY_ID = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
			+ "	+\"	FROM UTLISATEURS WHERE no_utilisateur = ?";

	private static final String SQL_VERIF_USER = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";
	private static final String SQL_VERIF_EMAIL = "SELECT COUNT(*) AS email_count FROM UTILISATEURS WHERE email = ?";
	private static final String SQL_VERIF_PSEUDO = "SELECT COUNT(*) AS pseudo_count FROM UTILISATEURS WHERE pseudo = ?";

	private static final String SQL_SELECT_EMAIL = "SELECT * FROM UTILISATEURS WHERE email = ?";

	private static final String SQL_SELECT_ALL = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
			+ " +\" FROM UTILISATEURS";

	private static final String SQL_UPDATE_USER = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";

	private static final String SQL_DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";

	/**
	 * Permet l'ajout d'un utilisateur dans la base de donnée
	 */
	@Override
	public void insert(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			cnx.setAutoCommit(false);
			rqt = cnx.prepareStatement(SQL_INSERT);
			rqt.setString(1, u.getPseudo());
			rqt.setString(2, u.getNom());
			rqt.setString(3, u.getPrenom());
			rqt.setString(4, u.getEmail());
			rqt.setString(5, u.getTelephone());
			rqt.setString(6, u.getRue());
			rqt.setString(7, u.getCodePostal());
			rqt.setString(8, u.getVille());
			rqt.setString(9, Utilisateur.hashPwd(u.getMotDePasse()));
			rqt.setInt(10, u.getCredit());
			rqt.setBoolean(11, u.getAdministrateur());

			int rowsAffected = rqt.executeUpdate();
			if (rowsAffected == 1) {
				// Succès de l'insertion, commit de la transaction
				cnx.commit();
			} else {
				// Échec de l'insertion, rollback
				cnx.rollback();
				return;
			}
			rqt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet la sélection de l'utilisateur à partir de son ID
	 * 
	 * @return Utilisateur
	 */
	@Override
	public Utilisateur selectBy(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBY_ID);
			rqt.setInt(1, u.getIdUtilisateur());
			rqt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	/**
	 * Permet de vérifier si l'utilisateur existe ou non dans la DB en contrôlant le
	 * duo email/mot de passe
	 * 
	 * @return si Utilisateur existe = True
	 */
	public boolean verifierUtilisateur(String email, String password) {

		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(SQL_VERIF_USER);
			rqt.setString(1, email);
			rqt.setString(2, password);

			ResultSet rs = rqt.executeQuery();
			boolean utilisateurExiste = rs.next();

			return utilisateurExiste;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Récupère les informations de l'utilisateur dans la DB et crée un
	 * "Utilisateur".
	 * 
	 * @param email
	 * @return Utilisateur
	 */
	@Override
	public Utilisateur createUserFromDB(String email) {
		Utilisateur u = null;
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(SQL_SELECT_EMAIL);
			rqt.setString(1, email);
			ResultSet rs = rqt.executeQuery();

			if (rs.next()) {
				u = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			u.toString();

			return u;
		} catch (SQLException e) {
			e.printStackTrace();
			return u;
		}
	}

	/**
	 * Permet la sélection de tous les utilisateurs sous forme de liste
	 */
	@Override
	public List<Utilisateur> selectAll() {
		Connection cnx = null;
		List<Utilisateur> utilisateurs = new ArrayList<>();
		ResultSet rs;
		Statement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SQL_SELECT_ALL);
			while (rs.next()) {
				Utilisateur u = new Utilisateur();

				u.setIdUtilisateur(rs.getInt("no_utilisateur"));
				u.setPseudo(rs.getString("pseudo"));
				u.setNom(rs.getString("nom"));
				u.setPrenom(rs.getString("prenom"));
				u.setEmail(rs.getString("email"));
				u.setTelephone(rs.getString("telephone"));
				u.setRue(rs.getString("rue"));
				u.setCodePostal(rs.getString("code_postal"));
				u.setVille(rs.getString("ville"));
				u.setMotDePasse(rs.getString("mot_de_passe"));
				u.setCredit(rs.getInt("credit"));
				u.setAdministrateur(rs.getBoolean("administrateur"));

				utilisateurs.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cnx != null) {
				try {
					JdbcTools.closeConnection(cnx);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return utilisateurs;
	}

	/**
	 * Permet la mise à jour d'un utilisateur
	 */
	@Override
	public void update(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_UPDATE_USER);
			// "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?,
			// rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";

			rqt.setString(1, u.getPseudo());
			rqt.setString(2, u.getNom());
			rqt.setString(3, u.getPrenom());
			rqt.setString(4, u.getEmail());
			rqt.setString(5, u.getTelephone());
			rqt.setString(6, u.getRue());
			rqt.setString(7, u.getCodePostal());
			rqt.setString(8, u.getVille());
			rqt.setString(9, u.getMotDePasse());
			rqt.setInt(10, u.getIdUtilisateur());
			rqt.executeUpdate();
			JdbcTools.closeConnection(cnx);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permet la suppression d'un utilisateur
	 */
	@Override
	public void delete(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, u.getIdUtilisateur());
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cnx != null) {
				try {
					JdbcTools.closeConnection(cnx);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Vérifie si l'email est unique ou non si emailUnique est true alors il est
	 * unique
	 * 
	 * @return emailUnique
	 */
	@Override
	public boolean singleEmailVerification(String email) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_VERIF_EMAIL);

			rqt.setString(1, email);

			ResultSet rs = rqt.executeQuery();

			int verifEmail = 0; // si email_count est différent de 0 alors il existe déjà

			if (rs.next()) { // Déplace le curseur vers la première ligne du résultat
				verifEmail = rs.getInt("email_count"); // Récupère la valeur de "email_count", si elle est différent de
														// 0 alors il existe déjà
			}
			boolean emailIsUnique = true;
			if (verifEmail > 0) {
				emailIsUnique = false; // email existe déjà
			} else {
				emailIsUnique = true; // email n'existe pas
			}
			return emailIsUnique;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Vérifie si le pseudo est unique ou non si pseudoUnique est true alors il est
	 * unique
	 * 
	 * @return pseudoUnique
	 */
	@Override
	public boolean singlePseudoVerification(String pseudo) {
		try (Connection cnx = JdbcTools.getConnection()) {
			PreparedStatement rqt = cnx.prepareStatement(SQL_VERIF_PSEUDO);
			rqt.setString(1, pseudo);

			ResultSet rs = rqt.executeQuery();
			int verifPseudo = 0;

			if (rs.next()) {
				verifPseudo = rs.getInt("pseudo_count"); // si pseudo_count est différent de 0 alors il existe déjà
			}
			boolean pseudoIsUnique;

			if (verifPseudo > 0) {
				pseudoIsUnique = false;
			} else {
				pseudoIsUnique = true;
			}
			return pseudoIsUnique;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
