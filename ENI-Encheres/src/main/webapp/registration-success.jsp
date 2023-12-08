<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Inscription réussie - ENI-Encheres</title>
	    <link href="css/style.css" rel="stylesheet" />
	    <script src="https://cdn.tailwindcss.com"></script>
	    
	    <script>
		// Redirige l'utilisateur vers la Servlet AccueilServlet.java au bout de 5 secondes
		setTimeout(() => { window.location.href = "AccueilServlet"; }, 3000);		
		</script>
	    
	</head>

	<body>
	
	    <main>
	        <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
	
	            <div class="space-y-12">
	
	                <h2 class="text-3xl font-bold leading-7 text-gray-900 antialiased underline">Inscription réussie</h2>
	
	                <p class="mt-1 leading-6 text-gray-600">Félicitations! Votre compte a été créé avec succès sur
	                    ENI-Enchères. Vous êtes maintenant prêt à découvrir des trésors uniques et à participer à des
	                    enchères passionnantes.</p>
	
	                <p class="mt-4 text-center text-gray-500">
	                    <a href="login.jsp" class="underline text-indigo-500 font-medium">Se connecter</a>
	                </p>
	            </div>
	
	        </div>
	    </main>
	
	</body>

</html>
