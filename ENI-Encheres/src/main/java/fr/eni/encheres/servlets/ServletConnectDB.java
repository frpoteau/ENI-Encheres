package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        try {
	            // Charge le pilote JDBC pour Microsoft SQL Server
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            
	            // Établit la connexion à la base de données ENCHERES_DB
	            Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=ENCHERES_DB;encrypt=false;trustservercertificate=true", "sa", "Pa$$w0rd");
	
	            // Prépare une requête SQL pour vérifier les informations de connexion
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?");
	            ps.setString(1, email);
	            ps.setString(2, password);
	
	            // Exécute la requête et récupère le résultat
	            ResultSet rs = ps.executeQuery();
	
	            // Vérifie si l'utilisateur existe dans la base de données
	            if (rs.next()) 
	            {
	                // Connexion réussie, stocke la variable de session
	                HttpSession session = request.getSession();
	                session.setAttribute("userConnected", true);
	                session.setAttribute("userEmail", email);
	
	                // Redirection vers index.jsp après connexion réussie
	                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	                rd.forward(request, response);
	            } 
	            else 
	            {
	                // Affiche un message d'erreur si l'email ou le mot de passe est incorrect
	                out.println("Email ou mot de passe incorrect.");
	            }   
	            
	            // Ferme la connexion après utilisation
	            con.close();
        	} 
        
	        catch (ClassNotFoundException | SQLException e) 
	        {
	            // Affiche les détails de l'erreur en cas de problème de connexion
	            e.printStackTrace();
	            out.println("Erreur de connexion à la base de données.");
	        }
    }
}