package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.EtudiantDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Etudiant;

public class EtudiantDaoImplementation implements EtudiantDao{

    Connection connection = ConnectionFactory.getConnection();

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

    public void update(int etudiantId, String fieldName, String fieldValue) {
        String columnName = mapFieldNameToColumnName(fieldName);
        if (columnName == null) {
            throw new IllegalArgumentException("Invalid field name");
        }

        PreparedStatement preparedStatement = null;

        try {
            String updateQuery = "UPDATE etudiant SET " + columnName + " = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, fieldValue);
            preparedStatement.setInt(2, etudiantId);

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    //used to prevent sql injection
    private String mapFieldNameToColumnName(String fieldName) {
        switch (fieldName) {
            case "nom":
                return "nom";
            case "Prenom":
                return "Prenom";
            case "universite":
                return "universite";
            case "adresse":
                return "adresse";
            case "ville":
                return "ville";
            case "province":
                return "province";
            case "codePostal":
                return "codePostal";
            case "Pays":
                return "Pays";
            case "telephone":
                return "telephone";
            case "email":
                return "email";
            case "sexe":
                return "sexe";
            case "dateNaissance":
                return "dateNaissance";
            default:
                return null; // Or throw an exception
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

    @Override
    public void update(Etudiant e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
