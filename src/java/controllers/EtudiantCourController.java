package controllers;

import DaoImp.CourDaoImplementation;
import DaoImp.EtudiantCourDaoImplementation;
import DaoImp.EtudiantDaoImplementation;
import interfaceDao.CourDao;
import interfaceDao.EtudiantCourDao;
import interfaceDao.EtudiantDao;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import model.Etudiant;
import model.Cour;
import services.EtudiantCourService;

@WebServlet(name = "EtudiantCourController", urlPatterns = {"/EtudiantCourController"})
public class EtudiantCourController extends HttpServlet {

    private EtudiantCourService etudiantCourService;

    public void init() {
        // Create DAO implementations
        EtudiantCourDaoImplementation etudiantCourDao = new EtudiantCourDaoImplementation();
        EtudiantDaoImplementation etudiantDao = new EtudiantDaoImplementation();
        CourDaoImplementation courDao = new CourDaoImplementation();

        // Inject DAOs into the service
        etudiantCourService = new EtudiantCourService(etudiantCourDao, etudiantDao, courDao);
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Handle GET requests
    EtudiantDao daoEtudiant = new EtudiantDaoImplementation();
    EtudiantCourDao  daoEtudiantCour = new EtudiantCourDaoImplementation();
    Etudiant etudiant;
    List<Cour> listCours;
    String action = request.getParameter("act");
    if (action != null) {
        try {
            switch (action) {
                case "listEtudiantsForCour":
                    int courId = Integer.parseInt(request.getParameter("courId"));
                    List<Etudiant> etudiants = etudiantCourService.getEtudiantsForCour(courId);
                    request.setAttribute("etudiants", etudiants);
                    request.setAttribute("courId", courId);
                    // Forward to the JSP/view that shows Etudiants for a Cour
                    request.getRequestDispatcher("/etudiantsForCour.jsp").forward(request, response);
                    break;

                case "listCoursForEtudiant":
                   
                    System.out.println("inse listCoursForEtudiant"); //for troubleshooting
                    int etudiantId = Integer.parseInt(request.getParameter("id"));
                    etudiant = daoEtudiant.findById(etudiantId);
                    listCours = daoEtudiantCour.getCoursForEtudiant(etudiantId);
                    request.setAttribute("etudiant", etudiant);
                    request.setAttribute("listCours", listCours);
                    // Forward to the JSP/view that shows Cours for an Etudiant
                    request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                    break;
                    
                    case "remove":
                    
                    int etudiantIdForRemove = Integer.parseInt(request.getParameter("id"));
                    int courIdForRemove = Integer.parseInt(request.getParameter("courId"));
                    etudiantCourService.removeEtudiantFromCour(etudiantIdForRemove, courIdForRemove);
                    etudiant = daoEtudiant.findById(etudiantIdForRemove);
                    listCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForRemove);
                    request.setAttribute("etudiant", etudiant);
                    request.setAttribute("listCours", listCours);
                    // Redirect after successful removal
                    request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                    break;

                // Add other cases as needed
            }
        } catch (NumberFormatException e) {
            // Handle exception for parsing integer parameters
            request.setAttribute("error", "Invalid ID format");
            // Forward to an error page or the original page with error message
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle other exceptions
            request.setAttribute("error", "An error occurred: " + e.getMessage());
            request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
        }
    } else {
        // If no action is specified, forward to a default page
        request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
    }
}

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Handle POST requests
    EtudiantDao daoEtudiant = new EtudiantDaoImplementation();
    EtudiantCourDao  daoEtudiantCour = new EtudiantCourDaoImplementation();
    Etudiant etudiant;
    List<Cour> listCours;
    String action = request.getParameter("act");
    
    if (action != null) {
        try {
            switch (action) {
                case "enroll":
                    
                    int etudiantIdForEnroll = Integer.parseInt(request.getParameter("etudiantId"));
                    int courIdForEnroll = Integer.parseInt(request.getParameter("courId"));
                    etudiantCourService.addEtudiantToCour(etudiantIdForEnroll, courIdForEnroll);
                    etudiant = daoEtudiant.findById(etudiantIdForEnroll);
                    listCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForEnroll);
                    request.setAttribute("etudiant", etudiant);
                    request.setAttribute("listCours", listCours);
                    // Redirect after successful enrollment
                    request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                    break;

                

                // Add other cases as needed
            }
        } catch (NumberFormatException e) {
            // Handle exception for parsing integer parameters
            // Redirect to an error page or show an error message
            response.sendRedirect("errorPage.jsp?error=Invalid%20ID%20format");
        } catch (Exception e) {
            // Handle other exceptions
            // Redirect to an error page with an error message
            response.sendRedirect("errorPage.jsp?error=Unexpected%20error");
        }
    } else {
        // If no action is specified, redirect to a default page
        response.sendRedirect("defaultPage.jsp");
    }
}

}
