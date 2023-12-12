package fr.eni.encheres.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jdbc.pool.DataSource;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.Article;

@WebServlet("/AddArticleServlet")
public class AddArticleServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        // Vérifie si l'utilisateur est connecté
        if (userId == null) {
            // Redirige vers une page de connexion si l'utilisateur n'est pas connecté
            response.sendRedirect("login.jsp");
            return;
        }

        // Initialise l'objet DataSource
        DataSource ds;
        try {
            ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/auction");
        } catch (NamingException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
            return;
        }

        // Récupère les données du formulaire
        String nomArticle = request.getParameter("nomArticle");
        String desc = request.getParameter("desc");
        int categorie = Integer.parseInt(request.getParameter("categorie"));
        String dateD = request.getParameter("dateD");
        String heureD = request.getParameter("heureD");
        String dateF = request.getParameter("dateF");
        String heureF = request.getParameter("heureF");
        int prixInit = Integer.parseInt(request.getParameter("prixInit"));

        // Convertit les chaînes en objets LocalDate et LocalTime
        LocalDate localDateD = LocalDate.parse(dateD);
        LocalTime localTimeD = LocalTime.parse(heureD);
        LocalDate localDateF = LocalDate.parse(dateF);
        LocalTime localTimeF = LocalTime.parse(heureF);

        // Création d'un objet Article avec les données
        Article article = new Article(nomArticle, desc, localDateD, localTimeD, localDateF, localTimeF, prixInit, userId, categorie, 0);

        // Établit une connexion à la base de données
        try (Connection conn = ds.getConnection()) {

            // Insère l'article dans la base de données
            PreparedStatement ps = conn.prepareStatement("INSERT INTO articles (nomArticle, description, categorie, dateD, heureD, dateF, heureF, prixInit, userId, etat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, nomArticle);
            ps.setString(2, desc);
            ps.setInt(3, categorie);
            ps.setDate(4, Date.valueOf(localDateD));
            ps.setString(5, heureD);
            ps.setDate(6, Date.valueOf(localDateF));
            ps.setString(7, heureF);
            ps.setInt(8, prixInit);
            ps.setInt(9, userId);
            ps.setInt(10, 0); // Etat "en cours"
            ps.executeUpdate();

            // Utilisation du manager pour ajouter l'article à la base de données
            ArticleManager articleManager = ArticleManager.getArticleManager();
            articleManager.ajouterArticle(article);

            // Redirige vers la page de succès après l'ajout réussi de l'article
            response.sendRedirect("additem-success.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // En cas d'erreur, redirige vers la page d'erreur
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userProfil.jsp");
    }
}
