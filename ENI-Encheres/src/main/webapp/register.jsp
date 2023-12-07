<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="fr">
	
	<head>
	
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<title>Inscription - ENI-Encheres</title>
    	<link href="css/style.css" rel="stylesheet" />
    	<script src="https://cdn.tailwindcss.com"></script>
    	
		 <style>
		    .error {
		        border: 1px solid #e53e3e; /* Rouge pour indiquer l'erreur */
		        background-color: #fed7d7; /* Fond rouge pour indiquer l'erreur */
		    }
		
		    .error-message {
		        color: #e53e3e; /* Couleur du texte en rouge pour les messages d'erreur */
		        font-size: 0.75rem; /* Taille de police plus petite pour les messages d'erreur */
		        margin-top: 0.25rem; /* Marge au-dessus du message d'erreur */
		    }
		</style>

		<script>
		  document.addEventListener("DOMContentLoaded", function () {
		    const passwordInput = document.getElementById("password");
		    const confirmPasswordInput = document.getElementById("confirmPassword");
		    const confirmPasswordError = document.getElementById("confirmPasswordError");
		
		    function validatePassword() {
		      const password = passwordInput.value;
		      const confirmPassword = confirmPasswordInput.value;
		
		      if (password !== confirmPassword) {
		        confirmPasswordError.textContent = "Les mots de passe ne correspondent pas";
		      } else {
		        confirmPasswordError.textContent = "";
		      }
		    }
		
		    passwordInput.addEventListener("input", validatePassword);
		    confirmPasswordInput.addEventListener("input", validatePassword);
		    
		    const form = document.querySelector("form");

            // Function to save form data to local storage
            function saveFormData() {
                const formData = {
                    pseudo: document.getElementById("pseudo").value,
                    prenom: document.getElementById("prenom").value,
                    nom: document.getElementById("nom").value,
                    email: document.getElementById("email").value,
                    telephone: document.getElementById("telephone").value,
                    rue: document.getElementById("rue").value,
                    code_postal: document.getElementById("code_postal").value,
                    ville: document.getElementById("ville").value,
                    password: document.getElementById("password").value,
                    confirmPassword: document.getElementById("confirmPassword").value,
                };

                localStorage.setItem("formData", JSON.stringify(formData));
            }

            // Function to load form data from local storage
            function loadFormData() {
                const savedData = localStorage.getItem("formData");
                if (savedData) {
                    const formData = JSON.parse(savedData);
                    document.getElementById("pseudo").value = formData.pseudo || "";
                    document.getElementById("prenom").value = formData.prenom || "";
                    document.getElementById("nom").value = formData.nom || "";
                    document.getElementById("email").value = formData.email || "";
                    document.getElementById("telephone").value = formData.telephone || "";
                    document.getElementById("rue").value = formData.rue || "";
                    document.getElementById("code_postal").value = formData.code_postal || "";
                    document.getElementById("ville").value = formData.ville || "";
                    document.getElementById("password").value = formData.password || "";
                    document.getElementById("confirmPassword").value = formData.confirmPassword || "";
                }
            }

            // Load form data on page load
            loadFormData();

            // Add submit event listener to the form
            form.addEventListener("submit", function () {
                // Save form data to local storage when the form is submitted
                saveFormData();
            });
		    
		  });
		</script>
		
	</head>

	<body>
	
		<main>
		  <div class="mx-auto max-w-7xl py-6 sm:px-6 lg:px-8">
		  
		    <form action="ServletAddUsers" method="post" accept-charset="UTF-8">
		      <div class="space-y-12">
		        
		        
		          <h2 class="text-3xl font-bold leading-7 text-gray-900 antialiased underline">Créer un compte</h2>
		          
		          <p class="mt-1 leading-6 text-gray-600">Bienvenue sur ENI-Enchères, votre portail exclusif pour 
		          découvrir des trésors uniques et participer à des enchères passionnantes. La première étape pour plonger 
		          dans cet univers excitant est de créer votre compte personnel.</p>
		          
		            <div class="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
		            
		              <div class="sm:col-span-4">
		                <label for="pseudo" class="block leading-6 text-gray-900">
		                   Pseudo
		                </label>
		                <input type="text" id="pseudo" name="pseudo" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
		              </div>
		              
		            </div>
		            
		            <div class="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
		            
		              <div class="sm:col-span-3">
		                <label for="first-name" class="block leading-6 text-gray-900">
		                   Prénom
		                </label>
		                <input type="text" id="prenom" name="prenom" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
		              </div>
		              
		              <div class="sm:col-span-3">
		                <label for="first-name" class="block leading-6 text-gray-900">
		                   Nom
		                </label>
		                <input type="text" id="nom" name="nom" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
		              </div>
		              
		              
		              <div class="sm:col-span-4">
		                <label for="first-name" class="block leading-6 text-gray-900">
		                   Email
		                </label>
		                <input type="email" id="email" name="email" required placeholder="Entrez votre adresse e-mail" required 
		                pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
		              </div>
		              
		              <div class="sm:col-span-4">
		                <label for="first-name" class="block leading-6 text-gray-900">
		                   Numéro de téléphone
                        </label>
                        <input type="tel" id="telephone" name="telephone" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
                      </div>
                      
                      <div class="sm:col-span-6">
                        <label for="rue" class="block leading-6 text-gray-900">
                           Rue
                        </label>
                        <input type="text" id="rue" name="rue" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
                      </div>
                      
                      <div class="sm:col-span-3">
                        <label for="code_postal" class="block leading-6 text-gray-900">
                           Code Postal
                        </label>
                        <input type="text" id="code_postal" name="code_postal" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
                      </div>
                      
                      <div class="sm:col-span-3">
                        <label for="first-name" class="block leading-6 text-gray-900">
                           Ville
                        </label>
                        <input type="text" id="ville" name="ville" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
                      </div>
                      
                      <div class="sm:col-span-4">
                        <label for="password" class="block leading-6 text-gray-900">
                           Mot de passe
                        </label>
                        <input type="password" id="password" name="password" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
                      </div>
		   
					<div class="sm:col-span-4">
					  <label for="confirmPassword" class="block leading-6 text-gray-900">
					    Confirmer le mot de passe
					  </label>
					  <input type="password" id="confirmPassword" name="confirmPassword" required class="mt-2 w-full border py-1.5 rounded-md px-2" charset="UTF-8">
					  <div id="confirmPasswordError" class="text-red-500 text-sm"></div>
					</div>
                      
                   </div>
	    		   
	    		   <div>
	    		   
	    		   <button type="submit"class="flex w-full justify-center rounded-md bg-indigo-600 px-3 py-1.5 leading-6 text-white shadow-sm">
                Créer un compte
              </button>
            </div>
            
	    		   </div>
	    
	 
	    </form>
	    
	    <p class="mt-10 text-center text-gray-500">
	    Déjà un compte ?
	    <a href="login.jsp" class="underline text-indigo-500 font-medium">Se connecter</a></p>
	    </div>
	  </main>
	    
	    
	</body>
	
</html>
