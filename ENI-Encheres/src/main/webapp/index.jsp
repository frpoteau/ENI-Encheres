<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<html lang="fr">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/index.css" rel="stylesheet" />
<title>Plateforme d'enchères d'objets de seconde main - ENI
	Enchères</title>
<style>
/* Style pour ajouter de l'espace entre les colonnes du tableau */
.styled-table th {
	padding: 12px; /* Ajustez la valeur de la marge selon vos besoins */
}

.styled-table td {
	padding: 8px; /* Ajustez la valeur de la marge selon vos besoins */
	text-align: center;
}
</style>
</head>

<!-- Header -->
<%@ include file="includes/header.jsp"%>

<body class="bg-white h-screen p-4">
	<!-- Ajout de la classe p-4 pour la marge -->

	<div
		class="p-8 my-4 w-full bg-orange-50 text-7xl bg-gradient-to-b from-orange-50 to-white">
		<div class="font-semibold">Adjugé,</div>
		<div class="space">Enchères</div>
		<div class="font-semibold">vendu !</div>
		<div class="flex items-center justify-start mt-7 space-x-4">
			<!-- Bouton "Retour" -->
			<a href="encheres.jsp"
				class="py-2 px-10 border border-neutral rounded-full bg-white text-base">Consultez
				nos enchères en cours</a>
		</div>
	</div>
<body>


	<div class="table-container">
		<h2 class="table-title" style="text-align: center; font-weight: bold; font-size: 24px;">Articles à vendre</h2>
		<br>

		<%-- Vérifier si la liste d'articles n'est pas null avant de l'afficher --%>
		<c:if test="${not empty tousArticles}">
			<div style="display: flex; justify-content: center;">
				<table class="styled-table">
					<thead>
						<!-- ... (en-têtes de colonnes) ... -->
						<tr>

							<th>Nom Article</th>
							<th>Description</th>
							<th>Date de début</th>
							<th>Heure de début</th>
							<th>Prix Initial</th>
							<th>Adresse de retrait</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="article" items="${tousArticles}">
							<tr>

								<td>${article.nomArticle}</td>
								<td>${article.desc}</td>
								<td>${article.dateD}</td>
								<td>${article.heureD}</td>
								<td>${article.prixInit}</td>
								<td>${article.adresseRetrait}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:if>
	</div>


	<img src="img/Liste_Articles-fictifs.png" alt="Les enchères en cours"
		class="z-index-2">

</body>

<%@ include file="WEB-INF/includes/footer.jsp"%>

</html>