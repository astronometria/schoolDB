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
 *
 * @author Desktop
 */
@WebServlet(name = "CourController", urlPatterns = {"/CourController"})
public class CourController extends HttpServlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in the cour doPost");
        String act = request.getParameter("act");
        if (act != null) {
            if (act.equals("put")) {
                System.out.println("in the  cour doPost.put");
                doPut(request, response);
                return;
            }
        }
        CourDao dao = new CourDaoImplementation();

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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
