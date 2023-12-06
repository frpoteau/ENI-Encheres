package fr.eni.encheres.dal;

import java.util.List;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO {
	
	public void insert(Utilisateur u);
	
	public Utilisateur selectBy (int id);
	
	public List<Utilisateur> selectAll();
	
	public void update (Utilisateur u);
	
	public void delete (int id);

}
