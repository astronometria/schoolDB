<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Details for Etudiant</title>
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
            <h2>Information for Etudiant</h2>
            <table>
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
                </tr>
            </table>

        <h3>Cours Enrolled In</h3>
        <c:if test="${not empty etudiantCours}">
            <table>
                <thead>
                    <tr>
                        <th>ID Cour</th>
                        <th>Nom Cour</th>
                        <th>Description</th>
                        <th>Code Cour</th>
                        <th>Note Finale</th>
                        <th>Semestre</th>
                        <th>Année</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${etudiantCours}" var="etudiantCour">
                        <tr>
                            <td>${etudiantCour.courId}</td>
                            <td>${etudiantCour.nomCour}</td>
                            <td>${etudiantCour.descriptionCour}</td>
                            <td>${etudiantCour.codeCour}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${etudiantCour.noteFinale != null}">
                                        ${etudiantCour.noteFinale}
                                    </c:when>
                                    <c:otherwise>
                                        N/A
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${etudiantCour.semestre != null}">
                                        ${etudiantCour.semestre}
                                    </c:when>
                                    <c:otherwise>
                                        N/A
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${etudiantCour.annee != null}">
                                        ${etudiantCour.annee}
                                    </c:when>
                                    <c:otherwise>
                                        N/A
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td><a href="<c:url value='/EtudiantCourController?id=${etudiant.id}&courId=${etudiantCour.courId}&act=remove'/>">delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <c:if test="${empty etudiantCours}">
            <p>No cours found for this etudiant.</p>
        </c:if>

        </div>
    </body>
</html>
