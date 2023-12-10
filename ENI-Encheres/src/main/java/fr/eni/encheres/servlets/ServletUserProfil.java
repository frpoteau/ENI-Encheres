package fr.eni.encheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletUserProfil
 */
@WebServlet("/ServletUserProfil")
public class ServletUserProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUserProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo");
		request.setAttribute("pseudo", pseudo);
		String prenom = request.getParameter("prenom");
		request.setAttribute("prenom", prenom);
		String nom = request.getParameter("nom");
		request.setAttribute("nom", nom);
		String email = request.getParameter("email");
		request.setAttribute("email", email);
		String telephone = request.getParameter("telephone");
		request.setAttribute("telephone", telephone);
		String rue = request.getParameter("rue");
		request.setAttribute("rue", rue);
		String CodePostal = request.getParameter("codePostal");
		request.setAttribute("codePostal", CodePostal);
		String ville = request.getParameter("ville");
		request.setAttribute("ville", ville);
		int credit = Integer.valueOf(request.getParameter("credit"));
		request.setAttribute("credit", credit);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
