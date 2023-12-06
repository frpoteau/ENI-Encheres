<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Plateforme d'enchères des objets de seconde main</title>
	</head>
	
	<body>
	
		<a href="#">[Déconnecté]</a>
	    
	    <h1>Bienvenue sur la plateforme d'enchères des objets de seconde main</h1>
	    
	    <form action="loginServlet" method="post">
	        <label for="email">Email :</label>
        	<input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$">
	
	        <label for="password">Mot de passe :</label>
	        <input type="password" id="password" name="password" required><br>
	        
	        <label for="rememberMe">Se souvenir de moi</label>
	        <input type="checkbox" id="rememberMe" name="rememberMe"><br>
	        
	       	<a href="register.jsp">Mot de passe oublié ?</a>
	
	        <a href="index.jsp" class="home-button"><button type="submit">Se connecter</button></a>
	    </form>
	    
	    <p><a href="register.jsp">Créer un compte</a></p>
	    
	    <p>En tant qu’utilisateur non connecté, je peux lister les enchères en cours.
	    Je peux filtrer ma recherche par catégorie, et par nom d’article (l’article est affiché si il contient le critère saisi)
	    - Pour consulter le détail des enchères, l’utilisateur doit se connecter.</p>
	    
	    <a href="encheres.jsp" class="home-button">Consultez nos enchères en cours</a>
	    
	</body>

</html>