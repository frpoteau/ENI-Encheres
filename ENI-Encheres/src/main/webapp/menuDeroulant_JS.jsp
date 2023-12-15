<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">

	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="stylesheet" href="css/menuDeroulant_JS.css">
		<title>Menu déroulant JS</title>
	</head>
	
	<body>
		
		<img src="votre-image.jpg" alt="Image de déclenchement" class="image-trigger">
		<ul id="menu-accordeon">
		   <li><a href="#">Mes enchères actuelles</a></li>
		    <li><a href="#">Mes achats</a></li>
		   <li><a href="#">Mes ventes</a>
		      <ul>
		         <li><a href="#">Mes articles</a></li>
		         <li><a href="#">Créer un nouvel article</a></li>
		      </ul>
		   </li>
		   <li><a href="#">Mes informations personnelles</a>
		      <ul>
		         <li><a href="#">Mon profil</a></li>
		      </ul>
		   </li>
		   <li><a href="#">Se déconnecter</a></li>
		</ul>
		<script type="text/javascript">
		    $(document).ready(function(){
		        $('#menu-accordeon>li').click(function(){
		            $(this).toggleClass('active');
		            $(this).siblings().removeClass('active');
		        })   
		    });
		</script>
		
	</body>

</html>