package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.EtudiantDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cour;
import model.Etudiant;

public class EtudiantDaoImplementation implements EtudiantDao {

    Connection connection = ConnectionFactory.getConnection(true);

    // Constructor 
    public EtudiantDaoImplementation() {
        // Constructor logic if necessary
    }

    // Create a new Etudiant
    public void create(Etudiant etudiant) {
        PreparedStatement preparedStatement;
        try {
            String createQuery = "INSERT INTO ETUDIANT(nom, prenom, universite, adresse, ville, province, codePostal, pays, telephone, email, sexe, dateNaissance) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);

            // Set parameters for Etudiant
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getUniversite());
            preparedStatement.setString(4, etudiant.getAdresse());
            preparedStatement.setString(5, etudiant.getVille());
            preparedStatement.setString(6, etudiant.getProvince());
            preparedStatement.setString(7, etudiant.getCodePostal());
            preparedStatement.setString(8, etudiant.getPays());
            preparedStatement.setString(9, etudiant.getTelephone());
            preparedStatement.setString(10, etudiant.getEmail());
            preparedStatement.setString(11, String.valueOf(etudiant.getSexe())); // Assuming sexe is a char
            preparedStatement.setString(12, etudiant.getDateNaissance());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find Etudiant by id
    public Etudiant findById(int id) {
        Etudiant etudiant = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM ETUDIANT WHERE id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("id"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("Prenom"));
                etudiant.setUniversite(resultSet.getString("universite"));
                etudiant.setAdresse(resultSet.getString("adresse"));
                etudiant.setVille(resultSet.getString("ville"));
                etudiant.setProvince(resultSet.getString("province"));
                etudiant.setCodePostal(resultSet.getString("codePostal"));
                etudiant.setPays(resultSet.getString("Pays"));
                etudiant.setTelephone(resultSet.getString("telephone"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setSexe(resultSet.getString("sexe"));
                etudiant.setDateNaissance(resultSet.getString("dateNaissance"));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return etudiant;
    }

    // Find all Etudiants
    public List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM ETUDIANT ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(resultSet.getInt("id"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("Prenom"));
                etudiant.setUniversite(resultSet.getString("universite"));
                etudiant.setAdresse(resultSet.getString("adresse"));
                etudiant.setVille(resultSet.getString("ville"));
                etudiant.setProvince(resultSet.getString("province"));
                etudiant.setCodePostal(resultSet.getString("codePostal"));
                etudiant.setPays(resultSet.getString("Pays"));
                etudiant.setTelephone(resultSet.getString("telephone"));
                etudiant.setEmail(resultSet.getString("email"));
                etudiant.setSexe(resultSet.getString("sexe"));
                etudiant.setDateNaissance(resultSet.getString("dateNaissance"));

                etudiants.add(etudiant);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return etudiants;
    }

    // Update Etudiant's info
    public void update(Etudiant etudiant) {

        System.out.println("inside EtudiantImplement.update");
        PreparedStatement preparedStatement;
        try {
            String updateQuery = "UPDATE ETUDIANT SET nom = ?, prenom = ?, universite = ?, adresse = ?, ville = ?, province = ?, codePostal = ?, pays = ?, telephone = ?, email = ?, sexe = ?, dateNaissance = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);

            // Set parameters for Etudiant
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getUniversite());
            preparedStatement.setString(4, etudiant.getAdresse());
            preparedStatement.setString(5, etudiant.getVille());
            preparedStatement.setString(6, etudiant.getProvince());
            preparedStatement.setString(7, etudiant.getCodePostal());
            preparedStatement.setString(8, etudiant.getPays());
            preparedStatement.setString(9, etudiant.getTelephone());
            preparedStatement.setString(10, etudiant.getEmail());
            preparedStatement.setString(11, String.valueOf(etudiant.getSexe())); // Assuming sexe is a char
            preparedStatement.setString(12, etudiant.getDateNaissance());
            preparedStatement.setInt(13, etudiant.getId());
            System.out.println(etudiant.getId());
            preparedStatement.executeUpdate();

            preparedStatement.close();
            System.out.println("executed query = " + updateQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete Etudiant
    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM ETUDIANT WHERE ID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  
}
