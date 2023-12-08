<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification des informations de votre profil - ENI-Encheres</title>
</head>
<body>
	<h1>Modification de votre profil</h1>
	
	<form method="post" action="ServletUpdateUser">
		
		Pseudo : <input type="text" name="pseudo">
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
		Mot de passe <input type="text" name="password">
		<br/>
		Confirmer le mot de passe <input type="text" name="confirmPassword">
		<br/>
		<input type="submit" value="Valider" onClick="functionSubmit('')"> <!-- Retour sur la page user avec les modifications -->
		<br/>
		<input type="submit" value="Annuler" onClick="functionSubmit('userProfil.jsp')"> <!-- Retour sur la page user sans les modifications -->
		
	</form>


</body>
</html>