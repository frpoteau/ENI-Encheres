package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletTestPoolConnexion
 */
@WebServlet("/ServletTestPoolConnexion")
public class ServletTestPoolConnexion extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();

        try {
	            InitialContext context = new InitialContext();
	
	            DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
	
	            Connection cnx = datasource.getConnection();
	            out.print("La connexion est " + (cnx.isClosed() ? " fermée" : "ouverte") + ".");
	
	            // Vérification de l'email et du mot de passe
	            String enteredEmail = "admin@example.com";
	            String enteredPassword = "eni";
	
	            String query = "SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?";
	            
	            try (PreparedStatement preparedStatement = cnx.prepareStatement(query)) 
	            {
	                preparedStatement.setString(1, enteredEmail);
	                preparedStatement.setString(2, enteredPassword);
	
	                ResultSet resultSet = preparedStatement.executeQuery();
	
	                if (resultSet.next()) 
	                {
	                    // Login successful
	                    out.print(" Connexion réussie.");
	                } 
	                else 
	                {
	                    // Invalid email or password
	                    out.print(" Identifiants invalides.");
	                }
	            }

	            cnx.close();

        	} 
        
        catch (NamingException | SQLException e) 
        {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.println("Une erreur est survenue lors de l'utilisation de la base de données : " + e.getMessage());
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        doGet(request, response);
    }
}