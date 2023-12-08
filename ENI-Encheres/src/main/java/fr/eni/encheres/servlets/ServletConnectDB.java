package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;

@WebServlet("/ServletConnectDB")
public class ServletConnectDB extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        // Définit le type de contenu de la réponse comme HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Récupère les paramètres du formulaire de connexion
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        try 
        {
        	// Vérifie si l'utilisateur existe
        	boolean utilisateurExiste = UtilisateurManager.getInstance().userExists(email, password);

        	if (utilisateurExiste) 
            {
                // Connexion réussie, stockez la variable de session
                HttpSession session = request.getSession();
                session.setAttribute("userConnected", true);
                session.setAttribute("userEmail", email);

                //Récupère le crédit de l'utilisateur
                int credit = UtilisateurManager.getInstance().getCreditUser(email);
    	        session.setAttribute("userCredit", credit);
                
                
                // Redirection vers index.jsp après connexion réussie
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else 
            {
                // Affiche un message d'erreur si l'email ou le mot de passe est incorrect
                out.println("Email ou mot de passe incorrect.");
            }

        } 
        catch (Exception e) 
        {
            // Affiche les détails de l'erreur en cas de problème de connexion
            e.printStackTrace();
            out.println("Erreur de connexion à la base de données.");
        }
        
    }
}