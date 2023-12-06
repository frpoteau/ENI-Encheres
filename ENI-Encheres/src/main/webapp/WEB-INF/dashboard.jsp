<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
	
	<head>

		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Tableau de bord</title>
	</head>
	
	<body>
		
	    <h1>Bienvenue sur votre tableau de bord</h1>

	    <p>Connecté en tant que : <%= session.getAttribute("username") %></p>
	    
	    <h2>Fonctionnalités du tableau de bord :</h2>
	    <ul>
	        <li><a href=".html">Modifier le profil</a></li>
	        <li><a href=".html">Consulter les enchères en cours</a></li>
	    </ul>
	
	    <p><a href="logoutServlet">Se déconnecter</a></p>
	    
	</body>
	
</html>
