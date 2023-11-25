<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>Etudiant Update Form</title>
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
            <h2>Etudiant Information</h2>
            <form action="EtudiantController" method="post"> 
                <input type="hidden" name="id" value="${e.id}" /> <!-- Hidden field for id -->
                <input type="hidden" name="act" value="put" />

                <label for="nom">Nom:</label>
                <input type="text" id="nom" name="nom" value="${e.nom}"><br><br>

                <label for="prenom">Prenom:</label>
                <input type="text" id="prenom" name="prenom" value="${e.prenom}"><br><br>

                <label for="universite">Universite:</label>
                <input type="text" id="universite" name="universite" value="${e.universite}"><br><br>

                <label for="adresse">Adresse:</label>
                <input type="text" id="adresse" name="adresse" value="${e.adresse}"><br><br>

                <label for="ville">Ville:</label>
                <input type="text" id="ville" name="ville" value="${e.ville}"><br><br>

                <label for="province">Province:</label>
                <input type="text" id="province" name="province" value="${e.province}"><br><br>

                <label for="codePostal">Code Postal:</label>
                <input type="text" id="codePostal" name="codePostal" value="${e.codePostal}"><br><br>

                <label for="pays">Pays:</label>
                <input type="text" id="pays" name="pays" value="${e.pays}"><br><br>

                <label for="telephone">Telephone:</label>
                <input type="text" id="telephone" name="telephone" value="${e.telephone}"><br><br>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${e.email}"><br><br>


                <label for="sexe">Sexe:</label>
                <select id="sexe" name="sexe">
                    <option value="M" <c:if test="${e.sexe == 'M'}">selected</c:if>>Masculin</option>
                    <option value="F" <c:if test="${e.sexe == 'F'}">selected</c:if>>Feminin</option>
                </select><br><br>

                <label for="dateNaissance">Date de Naissance:</label>
                <input type="text" id="dateNaissance" name="dateNaissance" value="${e.dateNaissance}"><br><br>

                <input type="submit" value="Submit">
            </form>
        </div>
    </body>
</html>
