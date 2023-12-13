<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.eni.encheres.bo.Article" %>

<!DOCTYPE html>

<html lang="fr">

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="css/myItemsForSale.css" rel="stylesheet" />
	    <title>Mes articles à vendre</title>
	</head>

	<!-- Header -->
	<%@ include file="includes/header.jsp" %>

<body>

        <h2 class="table-title">Mes articles à vendre</h2>

        <%-- Vérifier si la liste d'articles n'est pas null avant de l'afficher --%>
        <c:if test="${not empty mesArticles}">
        <table class="styled-table">
            <thead>
                <tr>
                    <th>ID Article</th>
                    <th>Nom Article</th>
                    <th>Description</th>
                    <th>Date de début</th>
                    <th>Heure de début</th>
                    <th>Date de fin</th>
                    <th>Heure de fin</th>
                    <th>Prix Initial</th>
                    <th>Adresse de retrait</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="article" items="${mesArticles}">
                    <tr>
                        <td>${article.idArticle}</td>
                        <td>${article.nomArticle}</td>
                        <td>${article.desc}</td>
                        <td>${article.dateD}</td>
                        <td>${article.heureD}</td>
                        <td>${article.dateF}</td>
                        <td>${article.heureF}</td>
                        <td>${article.prixInit}</td>
                        <td>${article.adresseRetrait}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        </c:if>


    <!-- Log pour vérifier si la liste d'articles est correctement transmise à la JSP -->
    <%
        System.out.println("Liste d'articles dans la JSP : ");
        List<Article> articles = (List<Article>) request.getAttribute("mesArticles");
        if (articles != null) {
            for (Article article : articles) {
                System.out.println(article);
            }
        } else {
            System.out.println("La liste d'articles est null.");
        }
    %>

</body>
</html>