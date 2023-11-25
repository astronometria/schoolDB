/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceDao;

import java.util.List;
import model.Cour;
import model.Etudiant;


/**
 *
 * @author Desktop
 */
public interface CourDao {
     void create(Cour c);
    
    void update(Cour c);
    
    void delete(int id);

    List<Cour> findAll();

    Cour findById(int id);
    
    
    
    
}
