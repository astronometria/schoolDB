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
            <a href="UserController" class="btn">Show all users</a><br>
            <a href="etudiantForm.jsp" class="btn">Créer un étudiant</a><br>
            <a href="EtudiantController" class="btn">Lister les étudiants</a>
            
        </div>
        <div class="main-content">
        <table>
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
                        <td><a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=delete'/>">delete</a><td>
                        <td><a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=update'/>">Mettre a jour</a><td>
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
