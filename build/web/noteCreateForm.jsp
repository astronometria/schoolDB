<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Update Note Details for Etudiant</title>
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
            <div class="main-content">
            <h2>Update Note Details for Etudiant</h2>
            <form action="EtudiantCourController" method="post">
                <input type="hidden" name="act" value="addDetails" />

                <!-- Hidden field for student ID -->
                <input type="hidden" name="etudiantId" value="${etudiant.id}" />

                <!-- Iterate over etudiantCours to find and display the correct course -->
                <c:forEach items="${etudiantCours}" var="cour">
                    <!-- Assuming courId is the parameter to determine the specific course -->
                    <c:if test="${param.courId == cour.courId}">
                        <!-- Hidden fields for course ID and course code -->
                        <input type="hidden" name="courId" value="${cour.courId}" />
                        <input type="hidden" name="codeCour" value="${cour.codeCour}" />

                        <div>
                            <strong>Student ID:</strong> <span>${etudiant.id}</span><br><br>
                            <strong>Course ID:</strong> <span>${cour.courId}</span><br><br>
                            <strong>Course Code:</strong> <span>${cour.codeCour}</span><br><br>
                        </div>

                        <div>
                            <label for="noteFinale">Final Note:</label>
                            <input type="number" id="noteFinale" name="noteFinale" value="${cour.noteFinale}" min="0" max="100" step="0.5" required><br><br>
                        </div>

                        <div>
                            <label for="semestre">Semester:</label>
                            <select id="semestre" name="semestre" required>
                                <option value="1" ${cour.semestre == 1 ? 'selected' : ''}>1 - January</option>
                                <option value="2" ${cour.semestre == 2 ? 'selected' : ''}>2 - September</option>
                            </select><br><br>
                        </div>

                        <div>
                            <label for="annee">Year:</label>
                            <input type="number" id="annee" name="annee" value="${cour.annee}" required><br><br>
                        </div>

                        <input type="submit" value="Update">
                    </c:if>
                </c:forEach>
            </form>
        </div>
    </body>
</html>
