<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 		<title>Page de Connexion</title>
	</head>
	
	<body>

	    <h2>Page de Connexion</h2>
	
	    <form action="ServletConnectDB" method="post">
	    
	        <label for="email">E-mail :</label>
	        <input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required>
	
			<button type="submit">Envoyer une demande de réinitialisation de mot de passe</button>
	
	        <button type="submit">Se Connecter</button>
	        
	    </form>
	
	    <% String error = request.getParameter("error");
	       if (error != null) { %>
	        <p style="color: red;">Error: <%= error %></p>
	    <% } %>

	</body>
	
</html>
