package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
  
	private static final String SQL_SELECT_CR ="SELECT credit FROM UTILISATEURS WHERE email = ?";
	
  private static final String SQL_SELECT_ALL ="SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
			+ " +\" FROM UTILISATEURS";
	
	private static final String SQL_UPDATE ="UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?";
	
	private static final String SQL_DELETE ="DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	
	

	@Override
	public void insert(Utilisateur u) {
		Connection cnx = null;
		PreparedStatement rqt;
		try {
			cnx = JdbcTools.getConnection();
			rqt = cnx.prepareStatement(SQL_INSERT);
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
		}catch(SQLException e) {
				e.printStackTrace();
		}finally {
				if(cnx!=null) {
					try {
						JdbcTools.closeConnection(cnx);
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
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
	
	public boolean verifierUtilisateur(String email, String password) {
	
		try (Connection con = JdbcTools.getConnection()) 
		{
            PreparedStatement rqt = con.prepareStatement("SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?");
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
	 * Récupère le crédit de l'utilisateur
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
}
