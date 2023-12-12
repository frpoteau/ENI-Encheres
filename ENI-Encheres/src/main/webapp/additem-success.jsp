<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Message d'ajout du nouvel article</title>
	    <link href="css/index.css" rel="stylesheet" />
	</head>
	
	<body>
	
	    <div>
	    
	        <h2>Ajout d'article</h2>
	        
	        <% String successMessage = (String) request.getAttribute("successMessage"); %>
	        
	        <% if (successMessage != null && !successMessage.isEmpty()){ %>
	            <p class="success-message"><%= successMessage %></p>
	        <% } else {%>
	        
				<p class="error-message">Échec de l'ajout de l'article.</p>
	            
	        <% } %>
	        
	    </div>
	    
	</body>

</html>