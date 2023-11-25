/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import DaoImp.UserDAOImplementation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import interfaceDao.UserDao;


@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserDao dao = new UserDAOImplementation();
       
        List<User> listUsers = dao.findAll();
        request.setAttribute("listU", listUsers);

        getServletContext().
                getRequestDispatcher("/listUsers.jsp").
                forward(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        UserDao dao = new UserDAOImplementation();

        User user = new User(userName , password);

        dao.create(user);
        List<User> listUsers = dao.findAll();
        request.setAttribute("listU", listUsers);

        getServletContext().
                getRequestDispatcher("/listUsers.jsp").
                forward(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
