<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Cours</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
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
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom du Cour</th>
                        <th>Description du Cour</th>
                        <th>Code du Cour</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listC}" var="cour">
                        <tr>
                            <td>${cour.id}</td>
                            <td>${cour.nomCour}</td>
                            <td>${cour.descriptionCour}</td>
                            <td>${cour.codeCour}</td>

                            <td><a href="<c:url value='/CourController?id=${cour.id}&act=delete'/>">delete</a><td>
                            <td><a href="<c:url value='/CourController?id=${cour.id}&act=update'/>">Mettre a jour</a><td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:if test="${listC == null || listC.size() == 0}">
                <p>Aucun cour trouvé.</p>
            </c:if>
        </div>
    </body>
</html>
