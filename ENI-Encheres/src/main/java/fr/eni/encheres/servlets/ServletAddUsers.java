package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAddUsers")
public class ServletAddUsers extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String pseudo = request.getParameter("pseudo");
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String rue = request.getParameter("rue");
        String codePostal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        // Valider les données (ajouter vos propres validations)

        // Vérifier si les mots de passe correspondent
        if (!password.equals(confirmPassword)) {
            // Gérer l'erreur
            response.sendRedirect("register.jsp"); // Rediriger vers la page d'inscription avec un message d'erreur si nécessaire
            return;
        }

        // Charger les paramètres de connexion depuis le fichier settings.properties
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("/fr/eni/encheres/dal/settings.properties"))  {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace(); // Gérer l'erreur
            return;
        }

        // Charger le pilote JDBC SQL Server
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gérer l'erreur
            return;
        }

        // Établir la connexion à la base de données
        Connection connection = null;
        try {
        	// Établir la connexion à la base de données avec l'encodage spécifié
        	connection = DriverManager.getConnection(
        	        properties.getProperty("urldb") +
        	        ";user=" + properties.getProperty("userdb") +
        	        ";password=" + properties.getProperty("passworddb") +
        	        ";useUnicode=yes;characterEncoding=UTF-8;sendStringParametersAsUnicode=false");

        	// Désactiver le commit automatique
        	connection.setAutoCommit(false);

            // Préparer la requête d'insertion
            String sql = "INSERT INTO UTILISATEURS (pseudo, prenom, nom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, pseudo);
                preparedStatement.setString(2, prenom);
                preparedStatement.setString(3, nom);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, telephone);
                preparedStatement.setString(6, rue);
                preparedStatement.setString(7, codePostal);
                preparedStatement.setString(8, ville);
                preparedStatement.setString(9, password);

                // Exécuter la requête
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected == 1) {
                    // Succès de l'insertion, commit de la transaction
                    connection.commit();
                } else {
                    // Échec de l'insertion, rollback
                    connection.rollback();
                    response.sendRedirect("register.jsp"); // Rediriger vers la page d'inscription avec un message d'erreur si nécessaire
                    return;
                }
            }

            // Rediriger vers une page de confirmation ou une autre page après l'inscription
            response.sendRedirect("registration-success.jsp");

        } catch (SQLException e) {
            try {
                if (connection != null) {
                    connection.rollback(); // En cas d'erreur, effectuer un rollback pour annuler la transaction
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace(); // Gérer l'erreur lors du rollback
            }
            e.printStackTrace(); // Gérer l'erreur
            response.sendRedirect("register.jsp"); // Rediriger vers la page d'inscription avec un message d'erreur si nécessaire
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Rétablir le commit automatique
                    connection.close();
                }
            } catch (SQLException closeException) {
                closeException.printStackTrace(); // Gérer l'erreur lors de la fermeture de la connexion
            }
        }
    }
}