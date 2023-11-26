<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>Cour Update Form</title>
    </head>
    <body>
        <div class="layout-container">
            <div class="sidebar">
                <a href="LoginController" class="nav-link">Acceuil</a>
                <a href="UserController" class="nav-link">Lister les Users</a>
                <a href="etudiantCreateForm.jsp" class="nav-link">Créer un étudiant</a>
                <a href="EtudiantController" class="nav-link">Lister les étudiants</a>
                <a href="courCreateForm.jsp" class="nav-link">Créer un cour</a>
                <a href="CourController" class="nav-link">Lister les cours</a>
                <a href="LogoutController" class="nav-link logout">Logout</a>
            </div>
            <div class="main-content">
                <h2>Cour Update Form</h2>
                <form action="CourController" method="post" class="form-container"> 
                    <input type="hidden" name="id" value="${c.id}" /> <!-- Hidden field for id -->
                    <input type="hidden" name="act" value="update" /> <!-- Correct the action value to 'update' -->

                    <label for="nomCour">Nom du cour:</label>
                    <input type="text" id="nomCour" name="nomCour" value="${c.nomCour}"><br><br>

                    <label for="descriptionCour">Description du cour:</label>
                    <input type="text" id="descriptionCour" name="descriptionCour" value="${c.descriptionCour}"><br><br>

                    <label for="codeCour">Code du cour:</label>
                    <input type="text" id="codeCour" name="codeCour" value="${c.codeCour}"><br><br>

                    <input type="submit" value="Update"> <!-- Change the button text to 'Update' -->
                </form>
            </div>
        </div>
    </body>
</html>
