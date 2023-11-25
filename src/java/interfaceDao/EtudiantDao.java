
package interfaceDao;

import java.util.List;
import model.Cour;
import model.Etudiant;



public interface EtudiantDao {
    
    void create(Etudiant e);
    
    void update(Etudiant e);
    
    void delete(int id);

    List<Etudiant> findAll();

    Etudiant findById(int id);
    

   
}
