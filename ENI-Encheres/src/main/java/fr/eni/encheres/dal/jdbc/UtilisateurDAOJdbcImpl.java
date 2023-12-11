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

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{
	
	
	private static final String SQL_INSERT ="INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String SQL_SELECTBY_ID ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
												+ "	+\"	FROM UTLISATEURS WHERE no_utilisateur = ?";
  
	private static final String SQL_VERIF_USER = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";
	private static final String SQL_VERIF_EMAIL = "SELECT COUNT(*) AS email_count FROM user WHERE email = ?";
	private static final String SQL_VERIF_PSEUDO = "SELECT COUNT(*) AS pseudo_count FROM user WHERE pseudo = ?";
	
	private static final String SQL_SELECT_CR ="SELECT credit FROM UTILISATEURS WHERE email = ?";
	
	private static final String SQL_SELECT_PSEUDO ="SELECT pseudo FROM UTILISATEURS WHERE email = ?";
	
	private static final String SQL_SELECT_ALL ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
			+ " +\" FROM UTILISATEURS";

	private static final String SQL_SELECT_COORDONNEES ="SELECT rue, code_postal, ville FROM UTILISATEURS WHERE email = ?";
	
	private static final String SQL_UPDATE ="UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	
	private static final String SQL_DELETE ="DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	
	

	@Override
	public void insert(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
			try {
				cnx=JdbcTools.getConnection();
				cnx.setAutoCommit(false);
				rqt=cnx.prepareStatement(SQL_INSERT);
				rqt.setString(1, u.getPseudo());
				rqt.setString(2, u.getNom());
				rqt.setString(3, u.getPrenom());
				rqt.setString(4, u.getEmail());
				rqt.setString(5, u.getTelephone());
				rqt.setString(6, u.getRue());
				rqt.setString(7, u.getCodePostal());
				rqt.setString(8, u.getVille());
				rqt.setString(9, u.getMotDePasse());
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
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Utilisateur selectBy(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_SELECTBY_ID);
			rqt.setInt(1, u.getIdUtilisateur());
			rqt.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	/**
	 * Permet de vérifier si l'utilisateur existe ou non dans la DB
	 * en contrôlant le duo email/mot de passe
	 * @return si Utilisarteur existe  = True
	 */
	public boolean verifierUtilisateur(String email, String password) {
	
		try (Connection cnx = JdbcTools.getConnection()) 
		{
            PreparedStatement rqt = cnx.prepareStatement(SQL_VERIF_USER);
            rqt.setString(1, email);
            rqt.setString(2, password);

            ResultSet rs = rqt.executeQuery();
            boolean utilisateurExiste = rs.next();
            
            return utilisateurExiste;
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Permet de récupérer le Pseudo de l'utilisateur
	 * à partir de son email
	 * @return Pseudo
	 */
    @Override
    public String getPseudo(String email) {
        String pseudo = null;
        try (Connection con = JdbcTools.getConnection()) {
            PreparedStatement rqt = con.prepareStatement(SQL_SELECT_PSEUDO);
            rqt.setString(1, email);
            ResultSet rs = rqt.executeQuery();
            if (rs.next()) {
                pseudo = rs.getString("pseudo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pseudo;
    }
	
	/**
	 * Récupère le crédit de l'utilisateur
	 * @return Credit
	 */
	@Override
	public int soldeCredit(String email) {
		int credit = 0;
		try (Connection con = JdbcTools.getConnection()) 
		{
			PreparedStatement rqt = con.prepareStatement(SQL_SELECT_CR); 
			rqt.setString(1, email);
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
                credit = rs.getInt("credit");
            }
			
		}catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return credit; 
	}
	
	/**
	 * Permet la sélection de touts les utilisateurs sous forme de liste
	 */
	@Override
	public String getCoordonnees(String email) {
	    String coordonnees = null;
	    try (Connection con = JdbcTools.getConnection()) {
	        PreparedStatement rqt = con.prepareStatement(SQL_SELECT_COORDONNEES);
	        rqt.setString(1, email);
	        ResultSet rs = rqt.executeQuery();

	        if (rs.next()) {
	            String rue = rs.getString("rue");
	            String codePostal = rs.getString("code_postal");
	            String ville = rs.getString("ville");

	            // Concaténation des coordonnées
	            coordonnees = rue + ", " + codePostal + " " + ville;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return coordonnees;
	}
	
	@Override
	public List<Utilisateur> selectAll() {
		Connection cnx = null;
		Utilisateur u = null;
		List<Utilisateur> utilisateur = new ArrayList<>();
		ResultSet rs;
		Statement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.createStatement();
			rs=rqt.executeQuery(SQL_SELECT_ALL);
			while(rs.next()) {
				utilisateur.add(u);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(cnx!=null) {
				try {
				JdbcTools.closeConnection(cnx);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return utilisateur;
	}
	
	/**
	 * Permet la mise à jour d'un utilisateur
	 */
	@Override
	public void update(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, u.getPseudo());
			rqt.setString(2, u.getNom());
			rqt.setString(3, u.getPrenom());
			rqt.setString(4, u.getEmail());
			rqt.setString(5,  u.getTelephone());
			rqt.setString(6,  u.getRue());
			rqt.setString(7,  u.getCodePostal());
			rqt.setString(8,  u.getVille());
			rqt.executeUpdate();
			JdbcTools.closeConnection(cnx);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Permet la suppremssion d'un utilisateur
	 */
	@Override
	public void delete(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx=JdbcTools.getConnection();
			rqt=cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, u.getIdUtilisateur());
			rqt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(cnx!= null) {
				try {
					JdbcTools.closeConnection(cnx);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Vérifie si l'email est unique ou non
	 * si emailUnique est true alors il est unique
	 * @return emailUnique
	 */
	@Override
	public boolean singleEmailVerification (String email) {
		
		try(Connection cnx = JdbcTools.getConnection()) 
		{
			PreparedStatement rqt = cnx.prepareStatement(SQL_VERIF_EMAIL);
			rqt.setString(1, email);
			
			ResultSet rs = rqt.executeQuery();
			int email_count = rs.getInt("email_count"); //si email_count est différent de 0 alors il existe déjà
			boolean emailIsUnique;
			
			if(email_count > 0) {
				emailIsUnique = false;
			}else {
				emailIsUnique = true;
			}
			
			return emailIsUnique;
			
		}catch (SQLException e) {
		
		e.printStackTrace();
		return false;
		}
	}
	
	/**
	 * Vérifie si le pseudo est unique ou non
	 * si pseudoUnique est true alors il est unique
	 * @return pseudoUnique
	 */
	@Override
	public boolean singlePseudoVerification (String pseudo) {
	try(Connection cnx = JdbcTools.getConnection()) 
	{
		PreparedStatement rqt = cnx.prepareStatement(SQL_VERIF_PSEUDO);
		rqt.setString(1, pseudo);
		
		ResultSet rs = rqt.executeQuery();
		int pseudo_count = rs.getInt("pseudo_count"); //si pseudo_count est différent de 0 alors il existe déjà
		boolean pseudoIsUnique;
		
		if(pseudo_count > 0) {
			pseudoIsUnique = false;
		}else {
			pseudoIsUnique = true;
		}
		
		return pseudoIsUnique;
		
	}catch (SQLException e) {
	
	e.printStackTrace();
	return false;
	}
}
	
	
	
	
}
