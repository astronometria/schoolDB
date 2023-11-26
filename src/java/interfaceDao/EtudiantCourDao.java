/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaceDao;

import java.util.List;
import model.Cour;
import model.Etudiant;
import model.EtudiantCour;

/**
 *
 * @author Desktop
 */
public interface EtudiantCourDao {
    public void addEtudiantToCour(int etudiantId, int courId);
    public void removeEtudiantFromCour(int etudiantId, int courId);
    public List<Etudiant> getEtudiantsForCour(int courId);
    public List<EtudiantCour> getCoursForEtudiant(int etudiantId);
    
   
}
