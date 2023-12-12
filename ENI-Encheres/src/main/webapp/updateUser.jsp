<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    // Récupération des valeurs des champs de mot de passe depuis la requête
    String newPassword = request.getParameter("userPassword");
    String confirmerNewPassword = request.getParameter("confirmerUserPassword");

    if (newPassword != null && confirmerNewPassword != null) {
        if (newPassword.equals(confirmerNewPassword)) {
            out.println("Les mots de passe correspondent !");
        } else {
            out.println("Les mots de passe ne correspondent pas !");
        }
    }
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/form_add-item.css" rel="stylesheet" />
<title>Modification des informations de votre profil - ENI-Encheres</title>
</head>
<body>

	<!-- Header -->
	<%@ include file="includes/header.jsp" %>

	<h2>Modification de votre profil</h2>
	
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
		<label for="newPassword">Mot de passe :</label>
        <input type="password" id="newPassword" name="newPassword" placeholder="Vide, si vous ne mofifiez pas le mot de passe">
		<br/>
        <label for="confirmerNewPassword">Confirmer le mot de passe :</label>
        <input type="password" id="confirmerNewPassword" name="confirmerNewPassword" placeholder="Vide, si vous ne mofifiez pas le mot de passe">
        <br/>
	
		<input type="submit" value="Valider"> <!-- Retour sur la page user avec les modifications -->
		<br/>
	</form>

	<form action="<%=request.getContextPath()%>/userProfil.jsp">
  		<button type="submit">Retour</button>
	</form>

</body>
</html>