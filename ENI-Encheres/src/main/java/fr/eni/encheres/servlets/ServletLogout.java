package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        // Récupère la session
        HttpSession session = request.getSession(false);

        if (session != null) 
        {
            // Invalide la session
            session.invalidate();
        }

        // Redirige vers la page d'accueil ou une autre page après la déconnexion
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}