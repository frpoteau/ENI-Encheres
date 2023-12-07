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

	
<body class="bg-white h-screen">

  <!-- Header -->
  <div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8 border-b border-neutral-100">
    <div class="flex h-16 items-center justify-between">
      <a class="h-8 w-8 bg-black"></a>
<div class="underline flex items-center space-x-3">
<a href="register.jsp">S'inscrire</a>
<a href="login.jsp">Se connecter</a>
</div>
</div>
</div>


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
    
    <div class="carre">
    <p class="text-2xl font-extrabold italic">FKTY</p>
    </div>
</body>

</html>