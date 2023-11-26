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
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import model.Etudiant;
import model.Cour;
import model.EtudiantCour;
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
        EtudiantCourDao daoEtudiantCour = new EtudiantCourDaoImplementation();
        String action = request.getParameter("act");
        if (action != null) {
            try {
                switch (action) {

                    case "listCoursForEtudiant":
                        int etudiantId = Integer.parseInt(request.getParameter("id"));

                        Etudiant etudiant = daoEtudiant.findById(etudiantId);
                        List<EtudiantCour> etudiantCours = daoEtudiantCour.getCoursForEtudiant(etudiantId);

                        request.setAttribute("etudiant", etudiant);
                        request.setAttribute("etudiantCours", etudiantCours); // Updated attribute
                        request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                        break;

                    case "remove":
                        // Existing code remains unchanged
                        int etudiantIdForRemove = Integer.parseInt(request.getParameter("id"));
                        int courIdForRemove = Integer.parseInt(request.getParameter("courId"));
                        etudiantCourService.removeEtudiantFromCour(etudiantIdForRemove, courIdForRemove);
                        etudiant = daoEtudiant.findById(etudiantIdForRemove);
                        etudiantCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForRemove);
                        request.setAttribute("etudiant", etudiant);
                        request.setAttribute("etudiantCours", etudiantCours);
                        request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                        break;

                    case "modify":

                        int etudiantIdForModify = Integer.parseInt(request.getParameter("id"));
                        int courIdFormodify = Integer.parseInt(request.getParameter("courId"));

                        etudiant = daoEtudiant.findById(etudiantIdForModify);
                        etudiantCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForModify);
                        request.setAttribute("etudiant", etudiant);
                        request.setAttribute("etudiantCours", etudiantCours);
                        request.getRequestDispatcher("/noteCreateForm.jsp").forward(request, response);
                        break;
                        
                    case "showBulletin":

                        int etudiantIdForBulletin = Integer.parseInt(request.getParameter("id"));
 
                        etudiantCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForBulletin);
                        request.setAttribute("etudiantCours", etudiantCours);
                        request.setAttribute("etudiantId", etudiantIdForBulletin);

                        request.getRequestDispatcher("/displayBulletin.jsp").forward(request, response);
                        break;

                    // Add other cases as needed
                }
            } catch (NumberFormatException e) {
                // Handle exceptions for parsing integer parameters
                request.setAttribute("error", "Invalid ID format");
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
        EtudiantCourDao daoEtudiantCour = new EtudiantCourDaoImplementation();
        String action = request.getParameter("act");

        if (action != null) {
            try {
                switch (action) {
                    case "enroll":
                        int etudiantIdForEnroll = Integer.parseInt(request.getParameter("etudiantId"));
                        int courIdForEnroll = Integer.parseInt(request.getParameter("courId"));

                        // Perform the enrollment
                        etudiantCourService.addEtudiantToCour(etudiantIdForEnroll, courIdForEnroll);

                        // Fetch updated Etudiant and EtudiantCour information
                        Etudiant etudiant = daoEtudiant.findById(etudiantIdForEnroll);
                        List<EtudiantCour> etudiantCours = daoEtudiantCour.getCoursForEtudiant(etudiantIdForEnroll);

                        // Set attributes for forwarding to the JSP
                        request.setAttribute("etudiant", etudiant);
                        request.setAttribute("etudiantCours", etudiantCours); 

                        // Forward to the JSP/view that shows Cours for an Etudiant
                        request.getRequestDispatcher("/coursForEtudiant.jsp").forward(request, response);
                        break;

                    // Add other cases as needed
                }
                if ("addDetails".equals(action)) {
                    System.out.println("inside the addDetails ");
                    int etudiantId = Integer.parseInt(request.getParameter("etudiantId"));
                    int courId = Integer.parseInt(request.getParameter("courId"));
                    String codeCour = request.getParameter("codeCour");
                    double noteFinale = Double.parseDouble(request.getParameter("noteFinale"));
                    int semestre = Integer.parseInt(request.getParameter("semestre"));
                    int annee = Integer.parseInt(request.getParameter("annee"));

                    // Call the method on EtudiantCourService to add or update the details
                    etudiantCourService.addOrUpdateEtudiantCourDetails(etudiantId, courId, codeCour, noteFinale, semestre, annee);

                    List<EtudiantCour> bulletin = daoEtudiantCour.getCoursForEtudiant(etudiantId);
                    request.setAttribute("bulletin", bulletin);
                    request.getRequestDispatcher("/displayBulletin.jsp").forward(request, response);

                }
                

            } catch (NumberFormatException e) {
                // Handle exception for parsing integer parameters
                response.sendRedirect("errorPage.jsp?error=Invalid%20ID%20format");
            } catch (Exception e) {
                e.printStackTrace(); // Log the stack trace
                response.sendRedirect("errorPage.jsp?error=Unexpected%20error:" + URLEncoder.encode(e.getMessage(), "UTF-8"));
            }
        
    }

    
        else {
            // If no action is specified, redirect to a default page
            response.sendRedirect("defaultPage.jsp");
    }
}

}
