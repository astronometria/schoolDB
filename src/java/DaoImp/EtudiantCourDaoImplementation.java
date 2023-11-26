/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.EtudiantCourDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cour;
import model.Etudiant;
import model.EtudiantCour;

/**
 *
 * @author Desktop
 */
public class EtudiantCourDaoImplementation implements EtudiantCourDao{

     Connection connection = ConnectionFactory.getConnection(true);
    @Override
   public void addEtudiantToCour(int etudiantId, int courId) {
        String sql = "INSERT INTO etudiant_cour (etudiant_id, cour_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, etudiantId);
            preparedStatement.setInt(2, courId);
            preparedStatement.executeUpdate();
             preparedStatement.close();
        
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public List<Etudiant> getEtudiantsForCour(int courId) {
        List<Etudiant> etudiants = new ArrayList<>();

        String query = "SELECT e.id, e.nom, e.prenom, e.universite, e.adresse, e.ville, e.province, e.codePostal, e.pays, e.telephone, e.email, e.sexe, e.dateNaissance "
                + "FROM etudiant e JOIN etudiant_cour ec ON e.id = ec.etudiant_id "
                + "WHERE ec.cour_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, courId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Etudiant etudiant = new Etudiant();
                    etudiant.setId(resultSet.getInt("id"));
                    etudiant.setNom(resultSet.getString("nom"));
                    etudiant.setPrenom(resultSet.getString("prenom"));
                    etudiant.setUniversite(resultSet.getString("universite"));
                    etudiant.setAdresse(resultSet.getString("adresse"));
                    etudiant.setVille(resultSet.getString("ville"));
                    etudiant.setProvince(resultSet.getString("province"));
                    etudiant.setCodePostal(resultSet.getString("codePostal"));
                    etudiant.setPays(resultSet.getString("pays"));
                    etudiant.setTelephone(resultSet.getString("telephone"));
                    etudiant.setEmail(resultSet.getString("email"));
                    etudiant.setSexe(resultSet.getString("sexe")); // Assuming sexe is stored as CHAR
                    etudiant.setDateNaissance(resultSet.getString("dateNaissance"));

                    etudiants.add(etudiant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return etudiants;
    }
   public List<EtudiantCour> getCoursForEtudiant(int etudiantId) {
    List<EtudiantCour> etudiantCours = new ArrayList<>();

    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;
    try {
        String query = "SELECT c.id, c.nomCour, c.descriptionCour, c.codeCour, ec.NoteFinale, ec.Semestre, ec.Annee "
                     + "FROM cour c "
                     + "JOIN etudiant_cour ec ON c.id = ec.cour_id "
                     + "WHERE ec.etudiant_id = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, etudiantId);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            EtudiantCour etudiantCour = new EtudiantCour();
            etudiantCour.setEtudiantId(etudiantId); // Set the etudiantId for each EtudiantCour
            etudiantCour.setCourId(resultSet.getInt("id"));
            etudiantCour.setNomCour(resultSet.getString("nomCour"));
            etudiantCour.setDescriptionCour(resultSet.getString("descriptionCour"));
            etudiantCour.setCodeCour(resultSet.getString("codeCour"));
            etudiantCour.setNoteFinale(resultSet.getDouble("NoteFinale"));
            etudiantCour.setSemestre(resultSet.getInt("Semestre"));
            etudiantCour.setAnnee(resultSet.getInt("Annee"));

            etudiantCours.add(etudiantCour);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resultSet and preparedStatement
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    return etudiantCours;
}



    @Override
    public void removeEtudiantFromCour(int etudiantId, int courId) {
        String sql = "DELETE FROM etudiant_cour WHERE etudiant_id = ? AND cour_id = ?";
        try (Connection connection = ConnectionFactory.getConnection(true);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, etudiantId);
            preparedStatement.setInt(2, courId);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            // Log the exception or rethrow as needed
            throw new RuntimeException("Error removing Etudiant from Cour", ex);
        }
    }

   
}
