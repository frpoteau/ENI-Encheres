<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Connexion - ENI Encheres</title>
<link href="css/style.css" rel="stylesheet" />
<script src="https://cdn.tailwindcss.com"></script>
</head>
	
<body>
<div class="h-screen">
	  
<div class="flex min-h-full flex-col justify-center px-6 py-12 lg:px-8">
  <div class="sm:mx-auto sm:w-full sm:max-w-sm">
    <h2 class="text-5xl text-center">Connexion</h2>
    <div class="mt-3 text-center">
      <p class="text-gray-700">Connectez-vous pour découvrir des enchères exclusives et des trésors uniques.</p>
    </div>
  </div>
<div class="mt-7 sm:mx-auto sm:w-full md:max-w-xl">
	      
<% String error = request.getParameter("error");
if (error != null) { %>
<p style="color: red;">Error: <%= error %></p>
<% } %>
	       
<form action="ServletConnectDB" method="post">
	      
<!-- Container du formulaire avec espacement vertical -->
<div class="p-8 space-y-6 bg-white rounded-xl border border-neutral-100">
    <!-- Section pour l'e-mail -->
    <div>
        <label for="email">E-mail</label>
        <div class="mt-1">
            <!-- Champ de saisie de l'e-mail -->
            <input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required
                   class="mt-2 w-full border py-1.5 rounded-md px-2 shadow-sm">
        </div>
    </div>

<!-- TO-DO Partie Tom -->
    <!-- Section pour le mot de passe -->
    <div>
        <!-- Label du champ de saisie du mot de passe -->
        <label for="password">Password</label>
        <div class="mt-2">
            <!-- Champ de saisie du mot de passe -->
            <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required
                   class="mt-2 w-full border py-1.5 rounded-md px-2 shadow-sm">
        </div>
    </div>
    
    <div class="flex items-center justify-between">
        <div class="flex items-center">
            <!-- Checkbox "Se souvenir de moi" à gauche -->
            <input type="checkbox" id="rememberMe" name="rememberMe" class="mr-2">
            <label for="rememberMe">Se souvenir de moi</label>
        </div>
        <div>
            <!-- lien "Mot de passe oublié" à droite -->
            <a href="register.jsp" class="underline">
                Mot de passe oublié ?
            </a>
        </div>
    </div>
</div>
<!-- TO-DO Partie Yo -->
	    <h2>Page de Connexion</h2>
	
	    <form action="ServletConnectDB" method="post">
	    
	        <label for="email">E-mail :</label>
	        <input type="email" id="email" name="email" placeholder="Entrez votre adresse e-mail" required>
	
	        <label for="password">Mot de Passe :</label>
	        <input type="password" id="password" name="password" placeholder="Entrez votre mot de passe" required>
		        
		    <label for="rememberMe">Se souvenir de moi</label><!-- TODO -->
		    <input type="checkbox" id="rememberMe" name="rememberMe"><br>	        
	        
	        <a href="reinitpassword.jsp">Mot de passe oublié ?</a>
	
	        <button type="submit">Se Connecter</button>
	        
	    </form>
	
	    <% String error = request.getParameter("error");
	       if (error != null) { %>
	        <p style="color: red;">Error: <%= error %></p>
	    <% } %>

<!-- fin TO-DO -->       

	       
<div class="flex items-center justify-center mt-7 space-x-4">
    <!-- Bouton "Retour" -->
    <a href="#" class="py-2 px-10 border border-neutral rounded-full bg-white">
        Retour
    </a>

    <!-- Bouton "Se connecter" avec arrière-plan noir et texte blanc -->
    <button type="submit" class="py-2 px-10 border border-neutral rounded-full bg-black text-white">
        Se connecter
    </button>
</div>
</form>
</div>
</div>
</body>
</html>
