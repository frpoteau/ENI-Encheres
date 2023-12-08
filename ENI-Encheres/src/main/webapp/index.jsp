<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Plateforme d'enchères d'objets de seconde main - ENI Enchères</title>
    <link href="css/index.css" rel="stylesheet" />
        <script src="https://cdn.tailwindcss.com"></script>
</head>

	
<!--DEBUT TO-DO -->
  
<body class="bg-white h-screen">

  <!-- Header -->
 <%@ include file="/WEB-INF/includes/header.jsp" %>


<div class="p-8 my-4 w-full bg-orange-50 text-7xl bg-gradient-to-b from-orange-50 to-white">
  <div class="font-semibold">Adjugé,</div>
  <div class="space">Enchères</div>
  <div class="font-semibold">vendu !</div>
  <div class="flex items-center justify-start mt-7 space-x-4">
    <!-- Bouton "Retour" -->
    <a href="encheres.jsp" class="py-2 px-10 border border-neutral rounded-full bg-white text-base">
       Consultez nos enchères en cours
    </a>
  <button type="submit" class="py-2 px-10 border border-neutral rounded-full bg-black text-white text-base">
        Vendre un article
    </button>
    </div>
</div>

  <!-- POINT DE COMPARAISON -->
  
<body>
    <% 
        // Vérifie si l'utilisateur est connecté
        Boolean userConnected = (Boolean) session.getAttribute("userConnected");
        if (userConnected != null && userConnected) {
            String userEmail = (String) session.getAttribute("userEmail");
    %>
    
        <p>Bienvenue, <%= userEmail %> ! Vous êtes connecté. Votre crédit actuel est de : <%= session.getAttribute("userCredit") %> points [<a href="ServletLogout">Déconnexion</a>]</p>
    <%
        } else {
    %>
        <a href="#">[Déconnecté]</a>
    
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
        
        <p><a href="register.jsp">Créer un compte</a></p>
        
    <% } %>			       
        
    <h1>Bienvenue sur la plateforme d'enchères des objets de seconde main</h1>
    
    <!-- Condition pour cacher le paragraphe lorsque l'utilisateur est connecté -->
    <% if (userConnected == null || !userConnected) { %>
        <p>En tant qu’utilisateur non connecté, je peux lister les enchères en cours.
            Je peux filtrer ma recherche par catégorie, et par nom d’article (l’article est affiché si il contient le critère saisi)
            - Pour consulter le détail des enchères, l’utilisateur doit se connecter.</p>
    <% } %>
    
    <a href="encheres.jsp" class="home-button">Consultez nos enchères en cours</a>

  <!-- FIN TO-DO -->
    
    <div class="carre">
    <p class="text-2xl font-extrabold italic">FKTY</p>
    </div>
</body>

</html>