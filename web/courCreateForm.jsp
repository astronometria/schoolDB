<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>Etudiant Form</title>
    </head>
    <body>
       <div class="link-container">
            <a href="UserController" class="btn">Lister les Users</a><br>
            <a href="etudiantCreateForm.jsp" class="btn">Créer un étudiant</a><br>
            <a href="EtudiantController" class="btn">Lister les étudiants</a><br>
            <a href="courCreateForm.jsp" class="btn">Créer un cour</a><br>
            <a href="CourController" class="btn">Lister les cours</a>
        </div>
        <div class="main-content">
            <h2>Cour Create Form</h2>
            <form action="CourController" method="post"> 
                <label for="nomCour">Nom du cour:</label>
                <input type="text" id="nomCour" name="nomCour"><br><br>

                <label for="descriptionCour">Description du cour:</label>
                <input type="text" id="descriptionCour" name="descriptionCour"><br><br>

                <label for="codeCour">Code du cour:</label>
                <input type="text" id="codeCour" name="codeCour"><br><br>



                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>

