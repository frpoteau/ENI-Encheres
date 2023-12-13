<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.eni.encheres.bo.Article" %>

<!DOCTYPE html>

<html lang="fr">
    
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/form_userProfil.css" rel="stylesheet" />
        <title>Mes articles à vendre</title>
    </head>
    
    <!-- Header -->
    <%@ include file="includes/header.jsp" %>
    
    <body>
    
        <h2>Mes articles à vendre</h2>
        
        <%
            // Utilise <jsp:useBean> pour récupérer la liste d'articles depuis la requête
            List<Article> mesArticles = (List<Article>) request.getAttribute("mesArticles");
            
            // Log pour vérifier si la liste d'articles est présente dans la requête
            System.out.println("Liste d'articles dans la JSP : " + mesArticles);
            
            // Si la liste d'articles n'est pas présente, essaie de la créer
            if (mesArticles == null) {
                mesArticles = new java.util.ArrayList<Article>();
            }
        %>
        
        <table class="table">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Prix de départ</th>
                    <th>Date de début</th>
                    <th>Date de fin</th>
                </tr>
            </thead>
            <tbody>
                <% for (Article article : mesArticles) { %>
                    
                    <!-- Log pour vérifier les détails de chaque article -->
                    <%
                        System.out.println("Détails de l'article : " + article);
                    %>
                    
                    <tr>
                        <td><%= article.getNomArticle() %></td>
                        <td><%= article.getDesc() %></td>
                        <td><%= article.getPrixInit() %></td>
                        <td><%= article.getDateD() %></td>
                        <td><%= article.getDateF() %></td>
                    </tr>
                <% } // Fin de la boucle for %>
            </tbody>
        </table>
        
        <% if (mesArticles.isEmpty()) { %>
            <p>Vous n'avez aucun article à vendre.</p>
        <% } %>
        
    </body>
    
</html>