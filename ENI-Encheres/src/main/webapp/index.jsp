<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link href="css/index.css" rel="stylesheet" />
	    <title>Plateforme d'enchères d'objets de seconde main - ENI Enchères</title>
	</head>
	
	<!-- Header -->
	<%@ include file="includes/header.jsp" %>
		
	<body class="bg-white h-screen p-4"> <!-- Ajout de la classe p-4 pour la marge -->

		<div class="p-8 my-4 w-full bg-orange-50 text-7xl bg-gradient-to-b from-orange-50 to-white">
			<div class="font-semibold">Adjugé,</div>
			<div class="space">Enchères</div>
			<div class="font-semibold">vendu !</div>
			<div class="flex items-center justify-start mt-7 space-x-4">
			    <!-- Bouton "Retour" -->
			    <a href="encheres.jsp" class="py-2 px-10 border border-neutral rounded-full bg-white text-base">Consultez nos enchères en cours</a>
			</div>
		</div>
	  
		<body>
		
		    <img src="img/Liste_Articles-fictifs.png" alt="Les enchères en cours" class="z-index-2">
		
		</body>
		
		<%@ include file="WEB-INF/includes/footer.jsp" %>

</html>