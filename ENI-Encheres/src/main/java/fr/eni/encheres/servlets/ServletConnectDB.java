package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;

@WebServlet("/ServletConnectDB")
public class ServletConnectDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupère les paramètres du formulaire de connexion
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Vérifie si l'utilisateur existe
            boolean utilisateurExiste = UtilisateurManager.getInstance().userExists(email, password);

            // Création de la session
            HttpSession session = request.getSession(true);

            if (utilisateurExiste) {
                // Connexion réussie, stocke la variable de session
                session.setAttribute("userConnected", true);
                session.setAttribute("userEmail", email);

                // Récupère le crédit de l'utilisateur
                int credit = UtilisateurManager.getInstance().getCreditUser(email);
                session.setAttribute("userCredit", credit);

                // Réinitialise le message d'erreur
                session.setAttribute("errorMessage", null);

                // Redirection vers index.jsp après connexion réussie
                response.sendRedirect("index.jsp");
            } else {
                // Connexion échouée, stocke le message d'erreur dans la session
                session.setAttribute("userConnected", false);
                session.setAttribute("errorMessage", "Email ou mot de passe incorrect.");
                response.sendRedirect("index.jsp");
            }
        } catch (Exception e) {
            // Connexion échouée, stocke le message d'erreur dans la session
            HttpSession session = request.getSession();
            session.setAttribute("userConnected", false);
            session.setAttribute("errorMessage", "Erreur de connexion à la base de données.");
            response.sendRedirect("index.jsp");
        }
    }
}
