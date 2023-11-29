/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.CourDaoImplementation;
import DaoImp.EtudiantCourDaoImplementation;
import DaoImp.EtudiantDaoImplementation;
import interfaceDao.CourDao;
import interfaceDao.EtudiantDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cour;
import model.Etudiant;
import services.EtudiantCourService;

/**
 * The {@code CourController} class extends {@link HttpServlet} and is responsible
 * for handling all the requests related to the 'Cour' entity, such as creating,
 * updating, deleting, and displaying courses. It interacts with the {@link CourDao}
 * to persist and retrieve course data.
 *
 * <p>It supports the GET, POST, PUT, and DELETE HTTP methods to facilitate the
 * CRUD operations on course data. The servlet is annotated with {@code WebServlet},
 * mapping it to the URL pattern '/CourController'.</p>
 * 
 * <p>Each method in this class is designed to handle a specific HTTP request method,
 * gather the necessary data from the request, perform operations using the DAO layer,
 * and forward the response to the appropriate JSP page.</p>
 *
 * @author Desktop
 */
@WebServlet(name = "CourController", urlPatterns = {"/CourController"})
public class CourController extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CourController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CourController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   /**
     * Handles the HTTP {@code GET} method.
     * <p>This method determines the action to be taken (such as deleting a course,
     * updating course information, showing the enrollment form, or displaying the
     * list of courses) based on the 'act' parameter from the request. It then forwards
     * the request to the appropriate JSP page with the necessary attributes set.</p>
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in the  Cour doGet");
        // Create cour using DAO
        String act = request.getParameter("act");
        System.out.println(act);

        CourDao dao = new CourDaoImplementation();
        if (act != null) {
            if (act.equals("delete")) {
                System.out.println("in the  cour doGet.delete");
                doDelete(request, response);
                return;
            }

            if (act.equals("update")) {
                System.out.println("in the cour doGet.update");
                Cour currentCour = dao.findById(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("c", currentCour);
                getServletContext().getRequestDispatcher("/courUpdateForm.jsp").forward(request, response);
                return;

            }
            if ("showEnrollForm".equals(request.getParameter("act"))) {
                
                System.out.println("inside showEnrollForm if statement");
                int etudiantId = Integer.parseInt(request.getParameter("id"));
                List<Cour> listCours = dao.findAll();
                request.setAttribute("listCours", listCours);
                request.setAttribute("etudiantId", etudiantId);
                System.out.println("List of Cours: " + listCours); // Debugging line
                request.getRequestDispatcher("/inscriptionCour.jsp").forward(request, response);
            }
        }

        // Retrieve updated list and set as request attribute
        List<Cour> listCours = dao.findAll();
        request.setAttribute("listC", listCours);
        System.out.println(request.getParameter("id"));

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listCour.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP {@code POST} method.
     * <p>This method is responsible for creating a new course record based on the form
     * data received in the request. After creating the course, it retrieves an updated
     * list of courses and forwards to the course listing JSP page.</p>
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in the cour doPost");
        String act = request.getParameter("act");
        CourDao dao = new CourDaoImplementation();
        
        if (act != null) {
            if (act.equals("put")) {
                System.out.println("in the  cour doPost.put");
                doPut(request, response);
                return;
            }
           
            
        }
        

        // Retrieve form data
        String nomCour = request.getParameter("nomCour");
        String descriptionCour = request.getParameter("descriptionCour");
        String codeCour = request.getParameter("codeCour");

        // Create a new Cour object
        Cour cour = new Cour();
        cour.setNomCour(nomCour);
        cour.setDescriptionCour(descriptionCour);
        cour.setCodeCour(codeCour);

        dao.create(cour);

        // Retrieve updated list and set as request attribute
        List<Cour> listCours = dao.findAll();
        request.setAttribute("listC", listCours);

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listCour.jsp").forward(request, response);
    }

     /**
     * Handles the HTTP {@code DELETE} method.
     * <p>This method is called to delete a course. It uses the {@link EtudiantCourService}
     * to handle the deletion operation and then forwards to the course listing JSP
     * page with an updated list of courses.</p>
     *
     * @param req  servlet request
     * @param resp servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in the cour doDelete");

        // Obtain the courId to delete
        int courId = Integer.parseInt(req.getParameter("id"));

        // Use EtudiantCourService to handle the deletion
        EtudiantCourService etudiantCourService = new EtudiantCourService(
                new EtudiantCourDaoImplementation(),
                new EtudiantDaoImplementation(),
                new CourDaoImplementation()
        );
        etudiantCourService.deleteCour(courId);

        // Retrieve updated list of cours and set as request attribute
        CourDao dao = new CourDaoImplementation();
        List<Cour> listCours = dao.findAll();
        req.setAttribute("listC", listCours);

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listCour.jsp").forward(req, resp);
    }

    /**
     * Handles the HTTP {@code PUT} method.
     * <p>This method updates an existing course's information based on the form data
     * received in the request. It then retrieves an updated list of courses and forwards
     * to the course listing JSP page.</p>
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in the cour doPut");

        CourDao dao = new CourDaoImplementation();

        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String nomCour = request.getParameter("nomCour");
        String descriptionCour = request.getParameter("descriptionCour");
        String codeCour = request.getParameter("codeCour");

        // Create a new cour object
        Cour cour = new Cour();
        cour.setId(id);
        cour.setNomCour(nomCour);
        cour.setDescriptionCour(descriptionCour);
        cour.setCodeCour(codeCour);

        dao.update(cour);

        // Retrieve updated list and set as request attribute
        List<Cour> listCours = dao.findAll();
        request.setAttribute("listC", listCours);

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listCour.jsp").forward(request, response);
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
