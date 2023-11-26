<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Cours</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body class="list-courses-page"> <!-- Use a specific class for course listing page -->
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
                <h2>Liste des Cours</h2>
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nom du Cour</th>
                            <th>Description du Cour</th>
                            <th>Code du Cour</th>
                            <th>Actions</th> <!-- Added column header for actions -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listC}" var="cour">
                            <tr>
                                <td>${cour.id}</td>
                                <td>${cour.nomCour}</td>
                                <td>${cour.descriptionCour}</td>
                                <td>${cour.codeCour}</td>
                                <td>
                                    <a href="<c:url value='/CourController?id=${cour.id}&act=delete'/>" class="button-link">delete</a> 
                                    <a href="<c:url value='/CourController?id=${cour.id}&act=update'/>" class="button-link">update</a>
                                </td> <!-- Added action links with styling class -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${listC == null || listC.size() == 0}">
                    <p>Aucun cour trouvé.</p>
                </c:if>
            </div>
        </div>
    </body>
</html>
