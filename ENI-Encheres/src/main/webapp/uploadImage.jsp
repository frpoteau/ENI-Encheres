<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div>
      <form method="POST" action="UploadServlet" enctype="multipart/form-data">
         Sélectionner une image : <input type="file" name="file" />
         <input type="submit" value="Envoyer" />
      </form>
   </div>
</body>
</html>