<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>

<html lang="fr">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/form_add-item.css" rel="stylesheet" />
    <title>Ajouter un nouvel article</title>

    <script>

        document.addEventListener("DOMContentLoaded", function () {
            // Récupérer les champs du formulaire
            var nomArticleInput = document.getElementById("nomArticle");
            var descInput = document.getElementById("desc");
            var categorieInput = document.getElementById("categorie");
            var dateDInput = document.getElementById("dateD");
            var heureDInput = document.getElementById("heureD");
            var dateFInput = document.getElementById("dateF");
            var heureFInput = document.getElementById("heureF");
            var prixInitInput = document.getElementById("prixInit");

            // Charger les données du localStorage si elles existent
            nomArticleInput.value = localStorage.getItem("nomArticle") || "";
            descInput.value = localStorage.getItem("desc") || "";
            categorieInput.value = localStorage.getItem("categorie") || "";
            dateDInput.value = localStorage.getItem("dateD") || "";
            heureDInput.value = localStorage.getItem("heureD") || "";
            dateFInput.value = localStorage.getItem("dateF") || "";
            heureFInput.value = localStorage.getItem("heureF") || "";
            prixInitInput.value = localStorage.getItem("prixInit") || "";

            // Ajouter des écouteurs d'événements pour détecter les changements dans les champs
            nomArticleInput.addEventListener("input", function () {
                localStorage.setItem("nomArticle", nomArticleInput.value);
            });
            descInput.addEventListener("input", function () {
                localStorage.setItem("desc", descInput.value);
            });
            categorieInput.addEventListener("input", function () {
                localStorage.setItem("categorie", categorieInput.value);
            });
            dateDInput.addEventListener("input", function () {
                localStorage.setItem("dateD", dateDInput.value);
            });
            heureDInput.addEventListener("input", function () {
                localStorage.setItem("heureD", heureDInput.value);
            });
            dateFInput.addEventListener("input", function () {
                localStorage.setItem("dateF", dateFInput.value);
            });
            heureFInput.addEventListener("input", function () {
                localStorage.setItem("heureF", heureFInput.value);
            });
            prixInitInput.addEventListener("input", function () {
                localStorage.setItem("prixInit", prixInitInput.value);
            });
        });

    </script>

</head>

<!-- Header -->
<%@ include file="includes/header.jsp" %>

<body>

<%@ page session="true" %>

    <h2>Ajouter un nouvel article</h2>

    <form action="AddArticleServlet" method="post">

        <label for="nomArticle">Nom de l'article :</label>
        <input type="text" id="nomArticle" name="nomArticle" required><br>

        <label for="desc">Description :</label>
        <textarea id="desc" name="desc" rows="4" cols="50" required></textarea><br>

        <!-- <label for="images">Ajouter des images :</label>
        <input type="file" id="images" name="images" accept="image/*" multiple><br> -->

        <label for="categorie">Catégorie:</label>
        <select id="categorie" name="categorie" required>
            <option value="1">Electronique</option>
            <option value="2">Maison et Jardin</option>
            <option value="3">Véhicules</option>
            <option value="3">Vélos</option>
            <option value="4">Mode</option>
            <option value="5">Loisirs</option>
            <option value="6">Animaux</option>
            <option value="7">Matériel professionnel</option>
            <option value="7">Autres</option>
        </select><br>

        <label for="dateD">Date de début de l'enchère :</label>
        <input type="date" id="dateD" name="dateD">
        <label for="heureD">Heure de début :</label>
        <input type="time" id="heureD" name="heureD"><br>

        <label for="dateF">Date de fin de l'enchère :</label>
        <input type="date" id="dateF" name="dateF">
        <label for="heureF">Heure de fin:</label>
        <input type="time" id="heureF" name="heureF"><br>

        <label for="prixInit">Prix initial :</label>
        <input type="number" id="prixInit" name="prixInit" required><br>

        <label for="desc">Adresse de retrait (<em>Par défaut, celle de votre profil</em>) :</label>
        <textarea name="adresseRetrait" id="adresseRetrait" rows="4" cols="50">
            <%= session.getAttribute("userCoordonnees") %>
        </textarea>

        <input type="submit" value="Ajouter l'article (En construction)">

    </form>

</body>

</html>
