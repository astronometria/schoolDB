/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.CourDaoImplementation;
import DaoImp.EtudiantCourDaoImplementation;
import DaoImp.EtudiantDaoImplementation;
import DaoImp.UserDaoImplementation;
import interfaceDao.EtudiantDao;
import interfaceDao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Etudiant;
import model.User;
import services.EtudiantCourService;

/**
 *
 * @author Desktop
 */
@WebServlet(name = "EtudiantController", urlPatterns = {"/EtudiantController"})
public class EtudiantController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EtudiantController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EtudiantController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in the doGet");
        // Create etudiant using DAO
        String act = request.getParameter("act");
        System.out.println(act);
        
        EtudiantDao dao = new EtudiantDaoImplementation();
        if (act != null){
        if (act.equals("delete")){            
            System.out.println("in the doGot.delete");
            doDelete(request , response);
            return;
        }
        
        if (act.equals("update")){
            System.out.println("in the doGet.update");
            Etudiant currentEtudiant = dao.findById(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("e",currentEtudiant) ;
            getServletContext().getRequestDispatcher("/EtudiantUpdateForm.jsp").forward(request, response);
            return;
            
        }
        }

        // Retrieve updated list and set as request attribute
        List<Etudiant> listEtudiants = dao.findAll();
        request.setAttribute("listE", listEtudiants);
        System.out.println(request.getParameter("id")); 
        
      

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listEtudiant.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in the doPost");
        String act = request.getParameter("act");
        if (act != null){
        if (act.equals("put")){            
            System.out.println("in the doPost.put");
            doPut(request , response);
            return;
        }
        }
        EtudiantDao dao = new EtudiantDaoImplementation();

        // Retrieve form data
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String universite = request.getParameter("universite");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        String province = request.getParameter("province");
        String codePostal = request.getParameter("codePostal");
        String pays = request.getParameter("pays");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String sexe = request.getParameter("sexe");
        String dateNaissance = request.getParameter("dateNaissance");

        // Create a new Etudiant object
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setUniversite(universite);
        etudiant.setAdresse(adresse);
        etudiant.setVille(ville);
        etudiant.setProvince(province);
        etudiant.setCodePostal(codePostal);
        etudiant.setPays(pays);
        etudiant.setTelephone(telephone);
        etudiant.setEmail(email);
        etudiant.setSexe(sexe);
        etudiant.setDateNaissance(dateNaissance);

        dao.create(etudiant);

        // Retrieve updated list and set as request attribute
        List<Etudiant> listEtudiants = dao.findAll();
        request.setAttribute("listE", listEtudiants);

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listEtudiant.jsp").forward(request, response);
    }

    @Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("in the Etudiant doDelete");
    
    // Obtain the etudiantId to delete
    int etudiantId = Integer.parseInt(req.getParameter("id"));
    
    // Use EtudiantCourService to handle the deletion
    EtudiantCourService etudiantCourService = new EtudiantCourService(
        new EtudiantCourDaoImplementation(),
        new EtudiantDaoImplementation(),
        new CourDaoImplementation()
    );
    etudiantCourService.deleteEtudiant(etudiantId);

    // Retrieve updated list of etudiants and set as request attribute
    EtudiantDao dao = new EtudiantDaoImplementation();
    List<Etudiant> listEtudiants = dao.findAll();
    req.setAttribute("listE", listEtudiants);

    // Forward to JSP
    getServletContext().getRequestDispatcher("/listEtudiant.jsp").forward(req, resp);
}


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in the doPut");

        EtudiantDao dao = new EtudiantDaoImplementation();

        // Retrieve form data
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String universite = request.getParameter("universite");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        String province = request.getParameter("province");
        String codePostal = request.getParameter("codePostal");
        String pays = request.getParameter("pays");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String sexe = request.getParameter("sexe");
        String dateNaissance = request.getParameter("dateNaissance");

        // Create a new Etudiant object
        
        Etudiant etudiant = new Etudiant();
        etudiant.setId(id);
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setUniversite(universite);
        etudiant.setAdresse(adresse);
        etudiant.setVille(ville);
        etudiant.setProvince(province);
        etudiant.setCodePostal(codePostal);
        etudiant.setPays(pays);
        etudiant.setTelephone(telephone);
        etudiant.setEmail(email);
        etudiant.setSexe(sexe);
        etudiant.setDateNaissance(dateNaissance);

        dao.update(etudiant);

        // Retrieve updated list and set as request attribute
        List<Etudiant> listEtudiants = dao.findAll();
        request.setAttribute("listE", listEtudiants);

        // Forward to JSP
        getServletContext().getRequestDispatcher("/listEtudiant.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
