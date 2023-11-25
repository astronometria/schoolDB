<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Enroll Etudiant in a Cour</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <h2>Enroll Etudiant in a Cour</h2>
        <form action="EtudiantCourController" method="post">
            <input type="hidden" name="etudiantId" value="${param.id}" />
            <input type="hidden" name="act" value="enroll" />
            <label for="courId">Select Cour:</label>
            <select id="courId" name="courId">
                <c:forEach items="${listCours}" var="cour">
                    <option value="${cour.id}">${cour.nomCour}</option>
                </c:forEach>
            </select><br><br>
            <input type="submit" value="enroll">
        </form>
    </body>
</html>
