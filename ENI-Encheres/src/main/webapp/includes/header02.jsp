<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">

	<head>		    
		<meta name="viewport" content="width=device-width, initial-scale=1.0">    
		<link href="css/header02.css" rel="stylesheet" />
	</head>		    

	<header>
	
	    <div class="header_content">
	
		    <% 
		        Boolean isConnected = (Boolean) session.getAttribute("userConnected"); 
		        String creditText = "";
		
		        if (Boolean.TRUE.equals(isConnected)) {
		            int userCredit = (session.getAttribute("userCredit") != null)
		                    ? Integer.parseInt(session.getAttribute("userCredit").toString())
		                    : 0;
		            
		            creditText = (userCredit == 0) ? "0 point" : userCredit + " point" + (userCredit != 1 ? "s" : "");
		        }
		    %>
		    
			<div class="menu-container_general">
			
			    <input type="checkbox" id="menu-toggle">
			    <label for="menu-toggle" class="menu-icon">&#9776;</label>		    
			    <ul class="menu">
			        <li><a href="#">Actualité & astuces</a></li>
			        <li><a href="#">Aide / Contact</a></li>
			        <li><a href="#">Newsletter</a></li>
			        <li><a href="#">Conditions générales de vente</a></li>
			    </ul>
			    
			</div>
			
			

		
			<% if (Boolean.TRUE.equals(isConnected)) { %>
		        
	
			<p class="userConnect">Bienvenue, <%= session.getAttribute("userPseudo") %> ! Vous êtes connecté. Votre crédit actuel est de <span class="credit"><%= creditText %>.</span></p>
	
			<div class="menu-container_user">
		    
				<img src="img/icone_perso-mon-compte.png" alt="Image de déclenchement" class="image-trigger">
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
				      	 <li><a href="#"></a></li>
				         <li><a href="#">Mon profil</a></li>
				      </ul>
				   </li>
					<li><a href="#"></a></li>
					<li><a href="#"></a></li>
					<li><a href="#">Se déconnecter</a></li>
					<li><a href="#"></a></li>
				</ul>
				<script type="text/javascript">
				    $(document).ready(function(){
				        $('#menu-accordeon>li').click(function(){
				            $(this).toggleClass('active');
				            $(this).siblings().removeClass('active');
				        })   
				    });
				</script>
					    
			</div>
			
			<div class="image-container_panier">
				<img src="img/icone_mon-panier.png" alt="Mes transactions">
			</div>
		            
		        <% } else { %>
		        
		            <!-- Ajoutez ici le contenu à afficher lorsque l'utilisateur n'est pas connecté -->
		            <form action="ServletConnectDB" method="post">
		            	<!-- Le reste du formulaire pour la connexion -->
		                <input placeholder="Email" type="email" id="email" name="email" required/>
		                <input class="" placeholder = "Mot de passe" type="password" id="password" name="password" required/>
		                <button type="submit" class="">Se connecter</button>
		            </form>
		                
		            <a href="register.jsp" class="">S'inscrire</a>
		            <!-- Fin du contenu pour l'utilisateur non connecté -->
	           
		        <% } %>
	        
		</div>	 
		       
	</header>