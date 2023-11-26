<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>Etudiant Form</title>
        <script type="text/javascript">
            function validateForm() {
                var nom = document.getElementById('nom').value;
                var prenom = document.getElementById('prenom').value;
                if (nom.trim() === '' || prenom.trim() === '') {
                    alert('Les champs Nom et Prénom sont obligatoires.');
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body class="student-form-page">
        <div class="layout-container">
            <nav class="sidebar">
                <a href="LoginController" class="nav-link">Acceuil</a>
                <a href="UserController" class="nav-link">Lister les Users</a>
                <a href="etudiantCreateForm.jsp" class="nav-link">Créer un étudiant</a>
                <a href="EtudiantController" class="nav-link">Lister les étudiants</a>
                <a href="courCreateForm.jsp" class="nav-link">Créer un cour</a>
                <a href="CourController" class="nav-link">Lister les cours</a>
                <a href="LogoutController" class="nav-link logout">Logout</a>
            </nav>

            <div class="main-content">
                <h2>Etudiant Create Form</h2>

                <form action="EtudiantController" method="post" class="form-container" onsubmit="return validateForm()">

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

                    <input type="submit" value="Submit" class="form-btn">
                </form>

            </div>
        </div>
    </body>
</html>
