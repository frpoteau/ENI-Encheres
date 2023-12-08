package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur u);
	
	public Utilisateur selectBy (Utilisateur u);
	
	public List<Utilisateur> selectAll();
	
	public void update (Utilisateur u);
	
	public void delete (Utilisateur u);
	
	public boolean verifierUtilisateur(String email, String password);
	
	public int soldeCredit(String email);
	


}
