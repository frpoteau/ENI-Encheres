package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

/**
 * Servlet implementation class ServletAddItem
 */
@WebServlet("/addArticle")
public class AddArticleServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException 
	{
        HttpSession session = request.getSession();
        
        // Vérifie si l'utilisateur est connecté
        if (session.getAttribute("userId") == null) 
        {
            // Redirige vers une page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect("/login.jsp");
            return;
        }

        // Récupère les données du formulaire
        String nomArticle = request.getParameter("nomArticle");
        String desc = request.getParameter("desc");
        LocalDate dateD = LocalDate.parse(request.getParameter("dateD"));
        LocalDate dateF = LocalDate.parse(request.getParameter("dateF"));
        int prixInit = Integer.parseInt(request.getParameter("prixInit"));
        int prixVente = Integer.parseInt(request.getParameter("prixVente"));
        int categorie = Integer.parseInt(request.getParameter("categorie"));
        
        // Obtiens l'identifiant de l'utilisateur à partir de la session
        int numeroUtili = (int) session.getAttribute("userId");

        // Création d'un objet Article avec les données
        Article article = new Article(nomArticle, desc, dateD, dateF, prixInit, prixVente, numeroUtili, categorie);

        // Appelle la méthode d'ajout d'article de la couche métier (BLL)
        ArticleManager articleManager = ArticleManager.getArticleManager();
        articleManager.ajouterArticle(article);

        // Redirige l'utilisateur vers une page de confirmation
        response.sendRedirect("additem-success.jsp");
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    response.sendRedirect("userProfil.jsp");
	}
}