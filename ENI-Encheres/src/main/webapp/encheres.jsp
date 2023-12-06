<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nos Enchères en cours</title>
</head>
    
<body>

    <% 
        // Vérifie si l'utilisateur est connecté
        Boolean userConnected = (Boolean) session.getAttribute("userConnected");
        if (userConnected != null && userConnected) {
    %>
        <a href="ServletLogout">[Déconnexion]</a>
    <%
        } else {
    %>
        <a href="#">[Déconnecté]</a>
    <% } %>

    <a href="index.jsp" class="home-button">Page d'Accueil</a>
    
    <br><br>
    
    <form action="traitement_recherche.php" method="get">
    
        <label for="nom_article">Nom de l'Article :</label>
        <input type="text" id="nom_article" name="nom_article" placeholder="Entrez le nom de l'article">

        <label for="categorie">Catégorie :</label>
        <select id="categorie" name="categorie">
            <option value="categorie1">Catégorie 1</option>
            <option value="categorie2">Catégorie 2</option>
            <option value="categorie3">Catégorie 3</option>
            <!-- Ajoutez d'autres options de catégorie selon vos besoins -->
        </select>

        <button type="submit">Rechercher</button>
        
    </form>

    <h2>Nos enchères "Coup de Coeur"</h2>
    
	<!-- /ENI-Encheres/ENI-Encheres/build/classes/fr/eni/encheres/ihm/resources/ -->
	
    <img src="img/Article_001.png" alt="Image 1">
    <img src="img/Article_002.png" alt="Image 2">
    <img src="img/Article_003.png" alt="Image 3">
    
</body>

</html>