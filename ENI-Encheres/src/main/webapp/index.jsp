<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plateforme d'enchères des objets de seconde main</title>
</head>
	
<body>
    <% 
        // Vérifie si l'utilisateur est connecté
        Boolean userConnected = (Boolean) session.getAttribute("userConnected");
        if (userConnected != null && userConnected) {
            String userEmail = (String) session.getAttribute("userEmail");
    %>
    
        <p>Bienvenue, <%= userEmail %> ! Vous êtes connecté. Votre crédit actuel est de : <%= session.getAttribute("userCredit") %> points [<a href="ServletLogout">Déconnexion</a>]</p>
    <%
        } else {
    %>
        <a href="#">[Déconnecté]</a>
    
        <form action="ServletConnectDB" method="post">
            <label for="email">E-mail :</label>
            <input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required>
    
            <label for="password">Mot de Passe :</label>
            <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required>
                
            <label for="rememberMe">Se souvenir de moi</label><!-- TODO -->
            <input type="checkbox" id="rememberMe" name="rememberMe"><br>        
            
            <a href="reinitpassword.jsp">Mot de passe oublié ?</a>
    
            <button type="submit">Se Connecter</button>
        
        </form>
        
        <p><a href="register.jsp">Créer un compte</a></p>
        
    <% } %>			       
        
    <h1>Bienvenue sur la plateforme d'enchères des objets de seconde main</h1>
    
    <!-- Condition pour cacher le paragraphe lorsque l'utilisateur est connecté -->
    <% if (userConnected == null || !userConnected) { %>
        <p>En tant qu’utilisateur non connecté, je peux lister les enchères en cours.
            Je peux filtrer ma recherche par catégorie, et par nom d’article (l’article est affiché si il contient le critère saisi)
            - Pour consulter le détail des enchères, l’utilisateur doit se connecter.</p>
    <% } %>
    
    <a href="encheres.jsp" class="home-button">Consultez nos enchères en cours</a>
    
</body>

</html>