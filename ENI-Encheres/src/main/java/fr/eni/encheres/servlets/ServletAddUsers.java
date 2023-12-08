package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/ServletAddUsers")
public class ServletAddUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	Utilisateur user;
    	
        // Récupérer les données du formulaire
        String pseudo = request.getParameter("pseudo");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");


        // Vérifier si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            // Gérer l'erreur
            response.sendRedirect("register.jsp"); // Rediriger vers la page d'inscription avec un message d'erreur si nécessaire
            return;
        }
        
        // TODO à finir de brancher = gestion de l'affichage de l'erreur
        //boolean emailIsUnique = UtilisateurManager.getInstance().emailIsUnique(email);
        //boolean pseudoIsUnique = UtilisateurManager.getInstance().pseudoIsUnique(pseudo);
        
        //if(emailIsUnique && pseudoIsUnique) {
	        try {
		        user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, confirmPassword, 0, false);
		        UtilisateurManager.getInstance().addUser(user);	
		
	            // Rediriger vers une page de confirmation ou une autre page après l'inscription
	            response.sendRedirect("registration-success.jsp");
	        }catch (Exception e) {
	            response.sendRedirect("register.jsp"); // Rediriger vers la page d'inscription avec un message d'erreur si nécessaire
	        }
        //}
      
        	
	      
    }
}