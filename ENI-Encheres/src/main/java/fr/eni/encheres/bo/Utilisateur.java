package fr.eni.encheres.bo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utilisateur {
	private int idUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private Boolean administrateur;

	public Utilisateur() {
	}

	/**
	 * @param noUtilisateur
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(int idUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, Boolean administrateur) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	/**
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param motDePasse
	 * @param credit
	 * @param administrateur
	 */
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String codePostal, String ville, String motDePasse, int credit, Boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.administrateur = administrateur;
	}

	/**
	 * Permet de récupérer l'ID de l'utilisateur
	 * 
	 * @return the noUtilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Permet de modifier l'ID l'utilisateur. WARNING !! : cet ID est gérer par la
	 * DB !!
	 * 
	 * @param noUtilisateur the noUtilisateur to set
	 */
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	/**
	 * Permet de récupérer le Pseudo de l'utilisateur
	 * 
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Permet de modifier le Pseudo de l'utilisateur.
	 * 
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Permet de récupérer le Nom de l'utilisateur
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Permet de modifier le Nom de l'utilisateur.
	 * 
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Permet de récupérer le Prenom de l'utilisateur
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Permet de modifier le Prenom de l'utilisateur.
	 * 
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Permet de récupérer l'email de l'utilisateur
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Permet de modifier l'Email de l'utilisateur.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Permet de récupérer le Numéro de Télephone de l'utilisateur
	 * 
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Permet de modifier le Numéro de Téléphone de l'utilisateur.
	 * 
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Permet de récupérer la Rue de l'utilisateur
	 * 
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Permet de modifier la Rue de l'utilisateur.
	 * 
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Permet de récupérer le Code Postal de l'utilisateur
	 * 
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Permet de modifier le Code Posatal de l'utilisateur.
	 * 
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Permet de récupérer la Ville de l'utilisateur
	 * 
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Permet de modifier la Ville de l'utilisateur.
	 * 
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Permet de récupérer le Mot de Passe de l'utilisateur
	 * 
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}

	/**
	 * Permet de modifier le Mot de Passe de l'utilisateur.
	 * 
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	/**
	 * Permet de récupérer le Nombre de Credit de l'utilisateur
	 * 
	 * @return the credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Permet de modifier la Valeur du Crédit de l'utilisateur.
	 * 
	 * @param credit the credit to set
	 */
	public void setCredit(int credit) {
		this.credit = credit;
	}

	/**
	 * Permet de savoir si l'utilisateur est Administrateur (1) ou non (0).
	 * 
	 * @return the administrateur
	 */
	public Boolean getAdministrateur() {
		return administrateur;
	}

	/**
	 * Permet de modifier l'état Administrateur.
	 * 
	 * @param administrateur the administrateur to set
	 */
	public void setAdministrateur(Boolean administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [noUtilisateur=" + idUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", rue=" + rue + ", codePostal="
				+ codePostal + ", ville=" + ville + ", motDePasse=" + motDePasse + ", credit=" + credit
				+ ", administrateur=" + ((administrateur == true) ? 0 : 1) + "]";
	}

	/**
	 * Permet le hachage du mot de passe afin de le sécuriser dans la DB
	 * 
	 * @param motDePasse
	 * @return
	 */
	public static String hashPwd(String motDePasse) {
		// Initialise une instance de MessageDigest pour l'algorithme de hachage
		MessageDigest md = null;
		try {
			// Tente d'obtenir une instance de l'algorithme de hachage SHA-256
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// En cas d'erreur lors de la récupération de l'algorithme, affiche l'erreur
			e.printStackTrace();
		}

		// Met à jour l'algorithme de hachage avec les octets du mot de passe
		md.update(motDePasse.getBytes());

		// Effectue le hachage et stocke le résultat dans un tableau de bytes
		byte byteData[] = md.digest();

		// Convertit le tableau de bytes en une chaîne hexadécimale
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			// Convertit chaque byte en une représentation hexadécimale et l'ajoute à la
			// chaîne
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		// Retourne la représentation hexadécimale du hachage du mot de passe
		return sb.toString();
	}

}
