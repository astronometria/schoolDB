<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css" />
        <title>List of Users</title>
    </head>
    <body class="body-class-for-list-users">
        <div class="layout-container"> <!-- Container for sidebar and main content -->
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
                <h2>User List</h2>
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Username</th>
                            <th>Password</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listU}" var="user">
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.userName}</td>
                                <td>${user.password}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <c:if test="${listU == null || listU.size() == 0}">
                    <p>No users found.</p>
                </c:if>
            </div>
        </div>
    </body>
</html>
