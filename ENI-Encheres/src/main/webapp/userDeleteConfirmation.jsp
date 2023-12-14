<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmation de la suppression de votre compte</title>
</head>
<body>
	
		<p>Voulez-vous supprimer votre compte, cela sera définitif, vous perdrez l'historique de vos achats et de vos ventes, pour refaire partie de nous vous devrez recréer un compte.</p>
		
		<p>Êtes-vous sur de vouloir supprimer votre compte.</p>
		
	<form method="get" action="UserDeleteConfirmationServlet">
		
		<!-- Supprime le profil Utilisateur de la base de donnée -->
			<a href="UserDeleteServlet?id=<%=session.getAttribute("userID")%>">OUI</a>
		
		<!-- Supprime le profil Utilisateur de la base de donnée -->
		<a href="<%=request.getContextPath()%>/userProfil.jsp">NON</a>
		
	</form>

</body>
</html>