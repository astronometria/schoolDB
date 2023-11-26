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
                <h2>Liste des Étudiants</h2>
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom</th>
                            <th>Prénom</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listE}" var="etudiant">
                            <tr>
                                <td>${etudiant.id}</td>
                                <td>${etudiant.nom}</td>
                                <td>${etudiant.prenom}</td>
                                <td>
                                    <a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=delete'/>" class="button-link">delete</a> |
                                    <a href="<c:url value='/EtudiantController?id=${etudiant.id}&act=update'/>" class="button-link">update</a> |
                                    <a href="<c:url value='/CourController?act=showEnrollForm&id=${etudiant.id}'/>" class="button-link">enroll</a> |
                                    <a href="<c:url value='/EtudiantCourController?act=listCoursForEtudiant&id=${etudiant.id}'/>" class="button-link">details</a> |
                                    <a href="<c:url value='/EtudiantCourController?act=showBulletin&id=${etudiant.id}'/>" class="button-link">bulletin</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${listE == null || listE.size() == 0}">
                    <p>Aucun étudiant trouvé.</p>
                </c:if>
            </div>
        </div>
    </body>
</html>
