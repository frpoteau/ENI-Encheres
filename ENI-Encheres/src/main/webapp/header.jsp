<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

	<head>
	    <meta charset="utf-8" />
	    <link href="css/style.css" rel="stylesheet" />
	    <link href="css/header.css" rel="stylesheet" />
	    <link href="css/tailwind.css" rel="stylesheet" />
	</head>
	
	<body>

	    <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
	        <%
	            // Récupère la variable de session
	            Boolean isConnected = (Boolean)session.getAttribute("userConnected");
	
	            // Vérifie si la connexion a échoué et si la variable n'est pas présente pour la première visite
	            if (isConnected != null && !isConnected) {
	        %>
	                <p class="text-red-500">La connexion a échoué : Un problème d'adresse mail ou de mot de passe certainement !?</p>
	        <%
	                // Nettoie la variable de session pour éviter l'affichage répété
	                session.removeAttribute("userConnected");
	            }
	        %>
	        
		    <% 
		        // Vérifie si l'utilisateur est connecté
		        Boolean userConnected = (Boolean) session.getAttribute("userConnected");
		        if (userConnected != null && userConnected) {
		            String userEmail = (String) session.getAttribute("userEmail");
		    %>
	
		    <div class="container">
		        <div class="dropdown">
		            <img src="img/icone_hamburger.png" alt="Description de l'image">
		            <div class="dropdown-content1">
			            <div class="menu-item"><a href="#">Actualité & astuces</a></div>
			            <div class="menu-item"><a href="#">Aide / Contact</a></div>
			            <div class="menu-item"><a href="#">Newsletter</a></div>
		            </div>
		        </div>
		    
			    <div class="text-container">
			        <p>Bienvenue, <%= session.getAttribute("userPseudo") %> ! Vous êtes connecté. Votre crédit actuel est de <span class="credit"><%= session.getAttribute("userCredit") %> points !</span></p>
			    </div>
	
			    <div class="dropdown">
			        <img src="img/icone_perso-mon-compte.png" alt="Mon Compte">
			        <div class="dropdown-content2">
			        	<div class="menu-item"><a href="#">Mes enchères actuelles</a></div>
		                <div class="menu-item"><a href="#">Mes achats</a></div>
		                <div class="menu-item"><a href="#">Mes ventes</a></div>
		                <div class="menu-item"><a href="userProfil.jsp">Mes informations personnelles</a></div>
		                <div class="menu-item"><a href="ServletLogout">Se déconnecter</a></div>
			        </div>
			    </div>
	
				<div class="image-container">
				    <img src="img/icone_mon-panier.png" alt="Mes transactions">
				</div>
	    
	    	</div>
        
		    <%
		        } else {
		    %>
	
			<div class="flex h-20 items-center justify-end">
				<div class="flex">
					<form action="ServletConnectDB" method="post">
						<input
							placeholder="Email"
							class="border py-1.5 rounded-md px-2 shadow-sm text-sm"
							type="email" id="email" name="email" required
						/>
						<input
							placeholder="Mot de passe"
							type="password" id="password" name="password" required
							class="border py-1.5 rounded-md px-2 shadow-sm text-sm"
						/>
						<button type="submit" class="bg-black text-white py-1.5 px-4 rounded-full text-sm">Se connecter</button>
					</form>
					<a href="register.jsp" class="bg-black text-white py-1.5 px-4 rounded-full ml-1 text-sm">S'inscrire</a>
				</div>
			</div>
			<div class="flex items-center justify-end">
				<a href="reinitpassword.jsp" class="text-sm underline -mt-2">Mot de passe oublié ?</a>
			</div>
		
    	</div>
    
    	<% } %>
    
	</body>

</html>