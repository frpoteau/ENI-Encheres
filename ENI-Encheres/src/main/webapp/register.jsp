<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<title>Inscription</title>
	</head>

	<body>
	
		<a href="#">[Déconnecté]</a>
		
	    <h1>Créer un compte</h1>
	    
	    <form action="registrationServlet" method="post">
	
	        <label for="pseudo">Pseudo :</label>
	        <input type="text" id="pseudo" name="pseudo" required><br>
	        
	        <label for="nom">Nom :</label>
        	<input type="text" id="nom" name="nom" required>	
	        
	        <label for="prenom">Prénom :</label>
	        <input type="text" id="prenom" name="prenom" required>
	
	        <label for="email">Email :</label>
        	<input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$">
		
	        <label for="telephone">Numéro de téléphone :</label>
	        <input type="tel" id="telephone" name="telephone" required>
	
	        <label for="rue">Rue :</label>
	        <input type="text" id="rue" name="rue" required>
	
	        <label for="code_postal">Code Postal :</label>
	        <input type="text" id="code_postal" name="code_postal" required>
	
	        <label for="ville">Ville :</label>
	        <input type="text" id="ville" name="ville" required>
	        
	        <label for="password">Mot de passe :</label>
	        <input type="password" id="password" name="password" required><br>
	
	        <label for="confirmPassword">Confirmer le mot de passe :</label>
	        <input type="password" id="confirmPassword" name="confirmPassword" required><br>
	
	        <button type="submit">Créer un compte</button>
	        
	    </form>
	    
	    <p>Déjà un compte ? <a href="login.jsp" class="home-button"><button type="submit">Se connecter</button></a>
	    
	    <a href="index.jsp" class="home-button">Page d'Accueil</a>
	    
	</body>
	
</html>
