/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persondaoexample;

import DaoImp.UserDaoImplementation;
import java.util.List;
import model.User;
import interfaceDao.UserDao;

 
public class PErsonDaoExample {

 
    public static void main(String[] args) {
        UserDao dao = 
                new UserDaoImplementation();
    
   // User person1 = dao.findById(20);
    //System.out.println(person1);
   
   List<User> listUsers = dao.findAll();
   for ( User u: listUsers)
   System.out.println(u);
  
 // User person1 = dao.findById(1340);
 // person1.setName("xxx");
 // dao.update(person1);
 //dao.delete(1340);
 
 /*
 User pers1= new User();
 pers1.setId(20);
 pers1.setName("Yasmine");
 dao.create(pers1);
 
 */
 
   
        
    }
    
}
