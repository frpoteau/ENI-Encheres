<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Création de compte</title>
	</head>
	
	<body>
	    <h1>Création de compte</h1>
	    
	    <form action="registrationServlet" method="post">
	        <label for="pseudo">Pseudo :</label>
	        <input type="text" id="pseudo" name="pseudo" required><br>
	
	        <label for="nom">Nom :</label>
	        <input type="text" id="nom" name="nom" required><br>
	
	        <label for="prenom">Prénom :</label>
	        <input type="text" id="prenom" name="prenom" required><br>
	
	        <label for="email">Email :</label>
	        <input type="email" id="email" name="email" required><br>
	
	        <label for="telephone">Numéro de téléphone :</label>
	        <input type="tel" id="telephone" name="telephone" required><br>
	
	        <label for="rue">Rue :</label>
	        <input type="text" id="rue" name="rue" required><br>
	
	        <label for="codePostal">Code Postal :</label>
	        <input type="text" id="codePostal" name="codePostal" required><br>
	
	        <label for="ville">Ville :</label>
	        <input type="text" id="ville" name="ville" required><br>
	
	        <label for="password">Mot de passe :</label>
	        <input type="password" id="password" name="password" required><br>
	
	        <label for="confirmPassword">Confirmer le mot de passe :</label>
	        <input type="password" id="confirmPassword" name="confirmPassword" required><br>
	
	        <button type="submit">Créer un compte</button>
	    </form>
	</body>
	
</html>