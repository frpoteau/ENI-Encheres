<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Plateforme d'enchères d'objets de seconde main - ENI Enchères</title>
	    <link href="css/index.css" rel="stylesheet" />
	    <link href="css/style.css" rel="stylesheet" />
	    <link href="css/header.css" rel="stylesheet" />
	    <link href="css/footer.css" rel="stylesheet" />
	    <script src="https://cdn.tailwindcss.com"></script>
	</head>
  
	<body class="bg-white h-screen">
	
		<!-- Header -->
		<%@ include file="header.jsp" %>	

		<div class="p-8 my-4 w-full bg-orange-50 text-7xl bg-gradient-to-b from-orange-50 to-white">
			<div class="font-semibold">Adjugé,</div>
			<div class="space">Enchères</div>
			<div class="font-semibold">vendu !</div>
			<div class="flex items-center justify-start mt-7 space-x-4">
			    <!-- Bouton "Retour" -->
			    <a href="encheres.jsp" class="py-2 px-10 border border-neutral rounded-full bg-white text-base">Consultez nos enchères en cours</a>
			  	<!--<button type="submit" class="py-2 px-10 border border-neutral rounded-full bg-black text-white text-base">Vendre un article</button>-->
			</div>
		</div>
	  
		<body>
		
		    <img src="img/Liste_Articles-fictifs.png" alt="Les enchères en cours" class="z-index-2">
		
		</body>
		
		<%@ include file="WEB-INF/includes/footer.jsp" %>

</html>