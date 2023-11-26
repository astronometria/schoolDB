<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Details for Etudiant</title>
        <link rel="stylesheet" type="text/css" href="styles.css" />
    </head>
    <body>
        <div class="layout-container">
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
                <h2 class="center-text">Information for Etudiant</h2>
                <table class="styled-table">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Université</th>
                        <th>Adresse</th>
                        <th>Ville</th>
                        <th>Province</th>
                        <th>Code Postal</th>

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


                    </tr>
                    <tr>
                        <th>Pays</th>
                        <th>Téléphone</th>
                        <th>Email</th>
                        <th>Sexe</th>
                        <th>Date de Naissance</th>
                        <th></th>
                        <th></th>
                        <th></th>

                        </td>
                    </tr>
                    <tr>
                        <td>${etudiant.pays}</td>
                        <td>${etudiant.telephone}</td>
                        <td>${etudiant.email}</td>
                        <td>${etudiant.sexe}</td>
                        <td>${etudiant.dateNaissance}</td>
                        <td colspan="3" rowspan="2" class="centered-cell">
                            <a href="<c:url value='/EtudiantCourController?act=showBulletin&id=${etudiant.id}'/>" class="button-link">Show Bulletin</a>
                        </td>


                    </tr>
                </table>


                <h2 class="center-text">Cours Enrolled In</h2>
                <c:if test="${not empty etudiantCours}">
                    <table class="styled-table">
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
                                <th></th>
                                <th></th>
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
                                    <td><a href="<c:url value='/EtudiantCourController?id=${etudiant.id}&courId=${etudiantCour.courId}&act=remove'/>"class="button-link">delete</a></td>
                                    <td><a href="<c:url value='/EtudiantCourController?id=${etudiant.id}&courId=${etudiantCour.courId}&act=modify'/>"class="button-link">modify</a></td>

                                    <td><a href="<c:url value='/CourController?act=showEnrollForm&id=${etudiant.id}'/>"class="button-link">Enroll in Course</a>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty etudiantCours}">
                    <p>No cours found for this etudiant.</p>
                </c:if>
            </div>
        </div>
    </body>
</html>
