<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="fr.eni.encheres.bll.CategorieManager" %>
<!DOCTYPE html>

<html lang="fr">
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/encheres.css" rel="stylesheet" />
    <title>Nos Enchères en cours</title>
</head>
	<!-- Header -->
	<%@ include file="includes/header.jsp" %>
<body>

    <% 
        // Vérifie si l'utilisateur est connecté
        Boolean userConnected = (Boolean) session.getAttribute("userConnected");
        if (userConnected != null && userConnected) {

        } 
    %>

    
    <form action="traitement_recherche.php" method="get">
    
        <input type="text" id="nom_article" name="nom_article" placeholder="Entrez le nom de l'article">

        <select id="categorie" name="categorie" required>
	            <% List<String> categories = CategorieManager.getInstance().getValidCategories();
	            for (String category : categories) { %>
	            <option value="<%= category %>"><%= category %></option>
	            <% } %>
	        </select><br>

        <input type="submit" value="Rechercher">
        
    </form>
    
    <br><br>
	<!-- /ENI-Encheres/ENI-Encheres/build/classes/fr/eni/encheres/ihm/resources/ -->
	
    <img src="img/Article_001.png" alt="Image 1" class="mx-auto">
    <img src="img/Article_002.png" alt="Image 2" class="mx-auto">
    <img src="img/Article_003.png" alt="Image 3" class="mx-auto">
    <br>
   	<img src="img/Article_004.png" alt="Image 4" class="mx-auto">
    <img src="img/Article_005.png" alt="Image 5" class="mx-auto">
    <img src="img/Article_006.png" alt="Image 6" class="mx-auto">
    
</body>

</html>