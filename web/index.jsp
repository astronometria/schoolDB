<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div class="link-container">
           
        </div>
        <div class="main-content">
        <h1>Bienvenu ${user}</h1>
        
        
        <a href="UserController" class="btn">Show all users</a>
        <br>
        <a href="etudiantCreateForm.jsp" class="btn">Créer un étudiant</a> 
        <br>
        <a href="EtudiantController" class="btn">Lister les étudiants</a>
        <br>
        <a href="courCreateForm.jsp" class="btn">Créer un cour</a>
        <br>
        <a href="CourController" class="btn">Lister les cours</a>
        <br><!-- comment -->
        <a href="LogoutController">Logout</a>
        </div>
       
    </body>
</html>
