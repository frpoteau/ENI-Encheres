<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <link href="css/style.css" rel="stylesheet" />
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
</body>
</html>
