package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

@WebServlet("/MyItemsServlet")
public class MyItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		// Vérifie si l'utilisateur est connecté
		if (session.getAttribute("userID") != null) {
			// L'utilisateur est connecté
			Integer userId = (Integer) session.getAttribute("userID");

			// Récupère la liste des articles à vendre de l'utilisateur
			List<Article> mesArticles = new ArrayList<>();

			// Log avant la récupération de la liste d'articles
			System.out.println("Avant récupération de la liste d'articles");

			mesArticles = ArticleManager.getInstance().getMesArticles(userId);

			// Log après la récupération de la liste d'articles
			System.out.println("Liste d'articles après récupération : " + mesArticles);

			// Liste des articles mise dans la session pour être utilisée dans la JSP
			request.setAttribute("mesArticles", mesArticles);

			// Log avant la redirection vers la JSP
			System.out.println("Avant redirection vers myItemsForSale.jsp");

			// Redirige vers la page "Mes articles à vendre"
			RequestDispatcher dispatcher = request.getRequestDispatcher("myItemsForSale.jsp");
			dispatcher.forward(request, response);

			// Log après la redirection vers la JSP
			System.out.println("Après redirection vers myItemsForSale.jsp");
		} else {
			// L'utilisateur n'est pas connecté
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}