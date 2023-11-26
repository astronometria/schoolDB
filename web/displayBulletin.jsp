<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Bulletin</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div class="layout-container">
            <div class="sidebar">
                <a href="LoginController" class="nav-link">Accueil</a>
                <a href="UserController" class="nav-link">Lister les Users</a>
                <a href="etudiantCreateForm.jsp" class="nav-link">Créer un étudiant</a>
                <a href="EtudiantController" class="nav-link">Lister les étudiants</a>
                <a href="courCreateForm.jsp" class="nav-link">Créer un cour</a>
                <a href="CourController" class="nav-link">Lister les cours</a>
                <a href="LogoutController" class="nav-link logout">Logout</a>

            </div>
            <div class="main-content">
                <h2>Student Bulletin</h2>

                <c:if test="${not empty etudiantCours}">
                    <table class="styled-table">
                        <thead>
                            <tr>
                                <th>Course Code</th>
                                <th>Note</th>
                            </tr>

                        </thead>
                        <tbody>
                            <c:forEach items="${etudiantCours}" var="record">
                                <tr>
                                    <td>${record.codeCour}</td>
                                    <td><c:out value="${record.noteFinale != null ? record.noteFinale : 'N/A'}" /></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty etudiantCours}">
                    <p>No records found.</p>
                </c:if>
                <br>

                <a href="<c:url value='/EtudiantCourController?act=listCoursForEtudiant&id=${etudiantId}'/>"  class="button-link">Back to Details</a>

            </div>
        </div>
    </body>
</html>
