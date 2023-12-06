package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		try 
		{
			InitialContext context = new InitialContext();
			//Recherche de la DataSource
			DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			//Demande une connexion. Demande en attente tant qu'il n'y a pas de connexion disponible dans le pool. 
			Connection cnx = datasource.getConnection();
			out.print ("La connexion est " + (cnx.isClosed()?" fermée":"ouverte")+".");
			//Libérer la connexion lorsqu'on n'en a plus besoin :
			cnx.close();//La connexion n'est pas fermée mais remise dans le pool.
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
