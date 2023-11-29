<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Enroll Etudiant in a Cour</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div class="layout-container">
            <nav class="sidebar">
                <a href="LoginController" class="nav-link">Acceuil</a>
                <a href="UserController" class="btn">Lister les Users</a><br>
                <a href="etudiantCreateForm.jsp" class="btn">Créer un étudiant</a><br>
                <a href="EtudiantController" class="btn">Lister les étudiants</a><br>
                <a href="courCreateForm.jsp" class="btn">Créer un cour</a><br>
                <a href="CourController" class="btn">Lister les cours</a>
                <br><br><a href="LogoutController">Logout</a>
            </nav>
       
            <div class="main-content">
                <h2>Enroll Etudiant in a Cour</h2>
                <form action="EtudiantCourController" method="post" class="form-container">
                    <input type="hidden" name="etudiantId" value="${param.id}" />
                    <input type="hidden" name="act" value="enroll" />
                    <label for="courId" class="large-label">Select Cour:</label>
                    <select id="courId" name="courId" class="large-select">
                        <c:forEach items="${listCours}" var="cour">
                            <option value="${cour.id}">${cour.nomCour}</option>
                        </c:forEach>
                    </select><br><br>
                    <input type="submit" value="enroll">
                </form>
            </div>
        </div>
    </body>
</html>
