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
            <h2>Etudiant Create Form</h2>
            <form action="EtudiantController" method="post"> 
                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom"><br><br>

                <label for="prenom">Prenom:</label>
                <input type="text" id="prenom" name="prenom"><br><br>

                <label for="universite">Universite:</label>
                <input type="text" id="universite" name="universite"><br><br>

                <label for="adresse">Adresse:</label>
                <input type="text" id="adresse" name="adresse"><br><br>

                <label for="ville">Ville:</label>
                <input type="text" id="ville" name="ville"><br><br>

                <label for="province">Province:</label>
                <input type="text" id="province" name="province"><br><br>

                <label for="codePostal">Code Postal:</label>
                <input type="text" id="codePostal" name="codePostal"><br><br>

                <label for="pays">Pays:</label>
                <input type="text" id="pays" name="pays"><br><br>

                <label for="telephone">Telephone:</label>
                <input type="text" id="telephone" name="telephone"><br><br>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email"><br><br>

                <label for="sexe">Sexe:</label>
                <select id="sexe" name="sexe">
                    <option value="M">Masculin</option>
                    <option value="F">Feminin</option>
                </select><br><br>

                <label for="dateNaissance">Date de Naissance:</label>
                <input type="text" id="dateNaissance" name="dateNaissance"><br><br>

                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>

