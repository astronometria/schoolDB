
package controllers;

import DaoImp.UserDaoImplementation;
import interfaceDao.UserDao;
import java.io.IOException;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        UserDao dao = new UserDaoImplementation();
        System.out.println(dao.findByUserName(userName).getPassword());
         System.out.println(password);
        if(password.equalsIgnoreCase(dao.findByUserName(userName).getPassword()) ){
           
          
            req.setAttribute("user", userName);
            getServletContext().
                getRequestDispatcher("/index.jsp").
                forward(req, resp);
        }
        else{
          
            getServletContext().
                getRequestDispatcher("/login.jsp").
                forward(req, resp);
        }
       
    }
    
}
