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
	
		Pseudo : <%= session.getAttribute("userPseudo") %>
		<br/>
		Nom : <%=session.getAttribute("userNom") %>
		<br/>
		Prenom : <%=session.getAttribute("userPrenom") %>
		<br/>
		Email : <%=session.getAttribute("userEmail") %>
		<br/>
		Telephone : <%=session.getAttribute("userTelephone") %>
		<br/>
		Rue : <%=session.getAttribute("userRue") %>
		<br/>
		Code Postal : <%=session.getAttribute("userCodePostal") %>
		<br/>
		Ville : <%=session.getAttribute("userVille") %>
		<br/>
		Credit : <%=session.getAttribute("userCredit") %>
		<br/>
		Adresse de Livraison : <%=session.getAttribute("userCoordonnees") %>
		<br/>
        <a href="<%=request.getContextPath()%>/updateUser.jsp"><input type="button" value="Modifier mon Compte"/></a>
        
    </form>
	
	
	
</body>
</html>