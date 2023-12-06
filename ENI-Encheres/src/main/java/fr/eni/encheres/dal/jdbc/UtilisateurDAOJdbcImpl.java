package fr.eni.encheres.dal.jdbc;

import java.util.List;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO{
	
	private static final String SQL_INSERT ="INSERT INTO Utilisateur (no_Utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_SELECTEDBY_ID ="SELECT no_Utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur \"\r\n"
												+ "	+\"	FROM Utilisateur WHERE noUtilisateur = ?";
	private static final String SQL_SELECT_ALL
	
	
	
	
	

	@Override
	public void insert(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectBy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utilisateur u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
