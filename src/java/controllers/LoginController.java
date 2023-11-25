
package controllers;

import DaoImp.UserDAOImplementation;
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
        UserDao dao = new UserDAOImplementation();
        
        if(password == dao.findByUserName(userName).getPassword()){
            System.out.println("password == true");
            getServletContext().
                getRequestDispatcher("/listUsers.jsp").
                forward(req, resp);
        }
        else{
            System.out.println("password == false");
            getServletContext().
                getRequestDispatcher("/index.jsp").
                forward(req, resp);
        }
       
    }
    
}
