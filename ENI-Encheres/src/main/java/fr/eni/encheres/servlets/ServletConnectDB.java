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

@WebServlet("/ServletConnectDB")
public class ServletConnectDB extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Charge les propriétés depuis le fichier
        Properties prop = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("/fr/eni/encheres/dal/settings.properties")) {
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            out.println("Erreur de chargement du fichier de configuration.");
            return;
        }

        String dbDriver = prop.getProperty("driverdb");
        String dbUrl = prop.getProperty("urldb");
        String dbUser = prop.getProperty("userdb");
        String dbPassword = prop.getProperty("passworddb");

        try {
            Class.forName(dbDriver);
            Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            PreparedStatement ps = con.prepareStatement("SELECT * FROM UTILISATEURS WHERE email=? AND mot_de_passe=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Connexion réussie, stockez la variable de session
                HttpSession session = request.getSession();
                session.setAttribute("userConnected", true);
                session.setAttribute("userEmail", email);

                // Redirection vers index.jsp après connexion réussie
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else {
                out.println("Email ou mot de passe incorrect.");
            }

            con.close(); // Fermez la connexion après utilisation
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("Erreur de connexion à la base de données.");
        }
    }
}