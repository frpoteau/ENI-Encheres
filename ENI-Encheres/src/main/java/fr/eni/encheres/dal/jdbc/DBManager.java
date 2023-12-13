package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import fr.eni.encheres.bo.Article;

public class DBManager {

    private static final String URL = "jdbc:sqlserver://localhost;databasename=ENCHERES_DB;encrypt=false;trustservercertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "Pa$$w0rd";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Gérer l'exception selon votre logique
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<String> getValidCategories() throws SQLException {
        List<String> categories = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT libelle FROM CATEGORIES";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String categoryLabel = resultSet.getString("libelle");
                categories.add(categoryLabel);
            }

        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }

        return categories;
    }

    public static int getCategoryIdByLabel(String categoryLabel) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int categoryId = -1;

        try {
            connection = getConnection();
            String query = "SELECT no_categorie FROM CATEGORIES WHERE libelle = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoryLabel);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                categoryId = resultSet.getInt("no_categorie");
            }
        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }

        return categoryId;
    }

    public static void closeResources(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Article> getMesArticles(int userId) throws SQLException {
        List<Article> mesArticles = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM ARTICLES_VENDUS WHERE no_utilisateur = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Article article = resultSetToArticle(resultSet);
                mesArticles.add(article);
            }

        } finally {
            closeResources(connection, preparedStatement, resultSet);
        }

        return mesArticles;
    }

    	// Méthode utilitaire pour convertir un ResultSet en objet Article
    	private static Article resultSetToArticle(ResultSet resultSet) throws SQLException {
        Article article = new Article();
        article.setIdArticle(resultSet.getInt("no_article"));
        article.setNomArticle(resultSet.getString("nom_article"));
        article.setDesc(resultSet.getString("description"));
        article.setDateD(resultSet.getDate("date_debut_encheres").toLocalDate());
        article.setHeureD(resultSet.getTime("heure_debut_encheres").toLocalTime());
        article.setDateF(resultSet.getDate("date_fin_encheres").toLocalDate());
        article.setHeureF(resultSet.getTime("heure_fin_encheres").toLocalTime());
        article.setPrixInit(resultSet.getInt("prix_initial"));
        article.setNumeroUtili(resultSet.getInt("no_utilisateur"));
        article.setCategorie(resultSet.getInt("no_categorie"));

        return article;
    }


}