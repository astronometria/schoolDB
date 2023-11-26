<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Bulletin</title>
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
        <h2>Student Bulletin</h2>
    <c:if test="${not empty etudiantCours}">
        <table border="1">
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
         <br> <a href="<c:url value='/EtudiantCourController?act=listCoursForEtudiant&id=${etudiantId}'/>">Back to Details</a>
    <c:if test="${empty etudiantCours}">
        <p>No records found.</p>
    </c:if>
        </div>
    </body>
</html>
