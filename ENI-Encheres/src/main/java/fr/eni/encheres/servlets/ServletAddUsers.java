package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

@WebServlet("/ServletAddUsers")
public class ServletAddUsers extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
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

        
        // TODO à finir de brancher = gestion de l'affichage de l'erreur
        boolean emailIsUnique = UtilisateurManager.getInstance().emailIsUnique(email);
        boolean pseudoIsUnique = UtilisateurManager.getInstance().pseudoIsUnique(pseudo);
        
        
        if(emailIsUnique && pseudoIsUnique) {
	       	user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, confirmPassword, 0, false);
	        UtilisateurManager.getInstance().addUser(user);	
            // Redirige vers une page de confirmation ou une autre page après l'inscription
            response.sendRedirect("registration-success.jsp");
        }
        //Gestion email et pseudo déjà existant
        if (!emailIsUnique || !pseudoIsUnique) {
	        if (!emailIsUnique && !pseudoIsUnique){
	        	request.setAttribute("errorMessageEmailPseudo", "L'adresse e-mail et le Pseudo existent déjà, veillez en choisir d'autres.");
	        }
	        else if (!emailIsUnique){
	        	request.setAttribute("errorMessageEmailPseudo", "L'adresse e-mail existe déjà, veuillez en choisir une autre.");
		    }
	        else if(!pseudoIsUnique) {
	        	request.setAttribute("errorMessageEmailPseudo", "Le pseudo existe déjà, veuillez en choisir un autre.");
		    }
	        RequestDispatcher rd = request.getRequestDispatcher("/register-error.jsp");
	    	rd.forward(request, response);
        }
    }
}