package services;

import DaoImp.EtudiantCourDaoImplementation;
import DaoImp.EtudiantDaoImplementation;
import DaoImp.CourDaoImplementation;
import connection.ConnectionFactory;
import interfaceDao.CourDao;
import interfaceDao.EtudiantCourDao;
import interfaceDao.EtudiantDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import model.Cour;
import model.Etudiant;

public class EtudiantCourService {

    private final EtudiantCourDao etudiantCourDao;
    private final EtudiantDao etudiantDao;
    private final CourDao courDao;

    public EtudiantCourService(EtudiantCourDao etudiantCourDao,
            EtudiantDao etudiantDao,
            CourDao courDao) {
        this.etudiantCourDao = etudiantCourDao;
        this.etudiantDao = etudiantDao;
        this.courDao = courDao;
    }

    public void deleteEtudiant(int etudiantId) {
        Connection conn = null;
        try {
            // Get a connection with auto-commit turned off
            conn = ConnectionFactory.getConnection(false);

            // Start transaction
            // (Note: The transaction started implicitly when we set auto-commit to false)
            // Check if the etudiant is enrolled in any cours
            List<Cour> cours = etudiantCourDao.getCoursForEtudiant(etudiantId);
            if (!cours.isEmpty()) {
                // Handle the case where etudiant is enrolled in cours,
                // which might involve removing the etudiant from those cours first
                for (Cour cour : cours) {
                    etudiantCourDao.removeEtudiantFromCour(etudiantId, cour.getId());
                }
            }
            // Now it's safe to delete the etudiant
            etudiantDao.delete(etudiantId);

            // Commit transaction
            conn.commit();
        } catch (SQLException e) {
            // Handle exception - log or rethrow as appropriate
            try {
                if (conn != null) {
                    // Rollback transaction if necessary
                    conn.rollback();
                }
            } catch (SQLException ex) {
                // Handle rollback exception
            }
            // Rethrow or handle the original exception as needed
            throw new RuntimeException("Error deleting etudiant with ID: " + etudiantId, e);
        } finally {
            try {
                // Reset auto-commit to default state before closing the connection
                if (conn != null && !conn.getAutoCommit()) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                // Log this exception as well
            }
            // Close the connection
            ConnectionFactory.closeConnection();
        }
    }

    public void deleteCour(int courId) {
        Connection conn = null;
        try {
            // Get a connection with auto-commit turned off
            conn = ConnectionFactory.getConnection(false);

            // Start transaction
            // (Note: The transaction started implicitly when we set auto-commit to false)
            // Check if any etudiants are enrolled in the cour
            List<Etudiant> etudiants = etudiantCourDao.getEtudiantsForCour(courId);
            if (!etudiants.isEmpty()) {
                // Handle the case where etudiants are enrolled in the cour,
                // which might involve removing those etudiants first
                for (Etudiant etudiant : etudiants) {
                    etudiantCourDao.removeEtudiantFromCour(etudiant.getId(), courId);
                }
            }

            // Now it's safe to delete the cour
            courDao.delete(courId);

            // Commit transaction
            conn.commit();
        } catch (SQLException e) {
            // Handle exception - log or rethrow as appropriate
            try {
                if (conn != null) {
                    // Rollback transaction if necessary
                    conn.rollback();
                }
            } catch (SQLException ex) {
                // Handle rollback exception
                throw new RuntimeException("Error during rollback while deleting cour with ID: " + courId, ex);
            }
            throw new RuntimeException("Error deleting cour with ID: " + courId, e);
        } finally {
            try {
                // Reset auto-commit to default state before closing the connection
                if (conn != null && !conn.getAutoCommit()) {
                    conn.setAutoCommit(true);
                }
            } catch (SQLException e) {
                // Log this exception as well
            }
            // Close the connection
            ConnectionFactory.closeConnection();
        }
    }
    public List<Cour> getCoursForEtudiant(int etudiantId) {
        // Call the method from EtudiantCourDaoImplementation
        // You can add additional business logic here if necessary
        return etudiantCourDao.getCoursForEtudiant(etudiantId);
    }
    
    public List<Etudiant> getEtudiantsForCour(int courId) {
        // Call the method from EtudiantCourDaoImplementation
        // You can add additional business logic here if necessary
        return etudiantCourDao.getEtudiantsForCour(courId);
    }
    public void addEtudiantToCour(int etudiantId, int courId) {
        etudiantCourDao.addEtudiantToCour(etudiantId, courId);
    }
    public void removeEtudiantFromCour(int etudiantId, int courId){
        etudiantCourDao.removeEtudiantFromCour(etudiantId, courId);
    }
}
