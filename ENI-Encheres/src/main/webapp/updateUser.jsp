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
		
		Pseudo : <input type="text" name="pseudo" value="<%= session.getAttribute("userPseudo") %>">
		<br/>
		Nom <input type="text" name="nom" value="<%= session.getAttribute("userNom")%>">
		<br/>
		Prenom <input type="text" name="prenom" value="<%= session.getAttribute("userPrenom")%>">
		<br/>
		Email <input type="email" name="email" value="<%= session.getAttribute("userEmail")%>">
		<br/>
		Telephone <input type="text" name="telephone" value="<%= session.getAttribute("userTelephone")%>">
		<br/>
		Rue <input type="text" name="rue" value="<%= session.getAttribute("userRue")%>">
		<br/>
		Code Postal <input type="text" name="codePostal" value="<%= session.getAttribute("userCodePostal")%>">
		<br/>
		Ville <input type="text" name="ville" value="<%= session.getAttribute("userVille")%>">
		<br/>
		Mot de passe <input type="password" name="password" value="<%= session.getAttribute("userPassword")%>">
		<br/>
		Confirmer le mot de passe <input type="password" name="confirmPassword" value="<%= session.getAttribute("userPassword")%>">
		<br/>
	
		
		
		
		
		
		<input type="submit" value="Valider" onClick="functionSubmit('')"> <!-- Retour sur la page user avec les modifications -->
		<br/>
		<input type="submit" value="Annuler" onClick="functionSubmit('userProfil.jsp')"> <!-- Retour sur la page user sans les modifications -->
		
	</form>


</body>
</html>