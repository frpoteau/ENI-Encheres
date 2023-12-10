	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
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

    <div class="container">
        <div class="dropdown">
            <img src="img/icone_hamburger.png" alt="Description de l'image">
            <div class="dropdown-content1">
                <div class="menu-item"><a href="#">Actualité & astuces</a></div>
                <div class="menu-item"><a href="#">Aide / Contact</a></div>
                <div class="menu-item"><a href="#">Newsletter</a></div>
            </div>
        </div>

        <% if (Boolean.TRUE.equals(isConnected)) { %>
            <div class="text-container">
                <p>Bienvenue, <%= session.getAttribute("userPseudo") %> ! Vous êtes connecté. Votre crédit actuel est de 
                    <span class="credit"><%= creditText %></span>
                </p>
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
        <% } else { %>
            <!-- Ajoutez ici le contenu à afficher lorsque l'utilisateur n'est pas connecté -->
            <div class="flex h-20 items-center justify-end mx-auto">
                <form action="ServletConnectDB" method="post">
                    <!-- Le reste du formulaire pour la connexion -->
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
            <!-- Fin du contenu pour l'utilisateur non connecté -->
        <% } %>
    </div>
</div>
