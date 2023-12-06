<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<title>Connexion</title>
	</head>
	
	<body>
	
		<a href="#">[Déconnecté]</a>
		
	    <h1>Se connecter</h1>
	    
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
	    
	    <p>Pas encore de compte ? <a href="register.jsp">Créer un compte</a></p>
	    
		<a href="index.jsp" class="home-button">Page d'Accueil</a>
	    
	</body>

</html>
