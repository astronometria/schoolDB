<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Étudiants</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div class="link-container">
            <a href="UserController" class="btn">Lister les Users</a><br>
            <a href="etudiantCreateForm.jsp" class="btn">Créer un étudiant</a><br>
            <a href="EtudiantController" class="btn">Lister les étudiants</a><br>
            <a href="courCreateForm.jsp" class="btn">Créer un cour</a><br>
            <a href="CourController" class="btn">Lister les cours</a>
            <br><br><a href="LogoutController">Logout</a>
        </div>
        <div class="main-content">
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Université</th>
                        <th>Adresse</th>
                        <th>Ville</th>
                        <th>Province</th>
                        <th>Code Postal</th>
                        <th>Pays</th>
                        <th>Téléphone</th>
                        <th>Email</th>
                        <th>Sexe</th>
                        <th>Date de Naissance</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listE}" var="etudiant">
                        <tr>
                            <td>${etudiant.id}</td>
                            <td>${etudiant.nom}</td>
                            <td>${etudiant.prenom}</td>
                            <td>${etudiant.universite}</td>
                            <td>${etudiant.adresse}</td>
                            <td>${etudiant.ville}</td>
                            <td>${etudiant.province}</td>
                            <td>${etudiant.codePostal}</td>
                            <td>${etudiant.pays}</td>
                            <td>${etudiant.telephone}</td>
                            <td>${etudiant.email}</td>
                            <td>${etudiant.sexe}</td>
                            <td>${etudiant.dateNaissance}</td>
                            <td><a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=delete'/>">delete</a>
                            <td><a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=update'/>">Mettre a jour</a>
                            <td><a href="<c:url value='/CourController?act=showEnrollForm&id=${etudiant.id}'/>">Enroll in Course</a>
                            <td><a href="<c:url value='/EtudiantCourController?act=listCoursForEtudiant&id=${etudiant.id}'/>">Show Details</a>
                            <td><a href="<c:url value='/EtudiantCourController?act=showBulletin&id=${etudiant.id}'/>">Show Bulletin</a>
                                

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${listE == null || listE.size() == 0}">
                <p>Aucun étudiant trouvé.</p>
            </c:if>
        </div>
    </body>
</html>
