<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil - ENI-ENCHERE</title>
</head>
<body>

	<h1>Mon Profil</h1>
	
	<form method="get" action="ServletUserProfil">
	
		Pseudo : <% request.getAttribute("pseudo"); %>
		<br/>
		Nom <input type="text" name="nom">
		<br/>
		Prenom <input type="text" name="prenom">
		<br/>
		Email <!--A verifier pour la modification de l'adresse mail-->
		<br/>
		Telephone <input type="text" name="telephone">
		<br/>
		Rue <input type="text" name="rue">
		<br/>
		Code Postal <input type="text" name="codePostal">
		<br/>
		Ville <input type="text" name="ville">
		<br/>
		Credit <input type="text" name="credit">
	
	</form>

</body>
</html>