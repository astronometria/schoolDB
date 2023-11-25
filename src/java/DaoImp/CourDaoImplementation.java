/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoImp;

import connection.ConnectionFactory;
import interfaceDao.CourDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cour;
import model.Etudiant;

/**
 *
 * @author Desktop
 */
public class CourDaoImplementation implements CourDao {

    Connection connection = ConnectionFactory.getConnection(true);

    @Override
    public void create(Cour c) {
        PreparedStatement preparedStatement;
        try {
            String createQuery = "INSERT INTO COUR(nomCour, descriptionCour, codeCour) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);

            // Set parameters for Etudiant
            preparedStatement.setString(1, c.getNomCour());
            preparedStatement.setString(2, c.getDescriptionCour());
            preparedStatement.setString(3, c.getCodeCour());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Cour c) {
        System.out.println("inside ourImplement.update");
        PreparedStatement preparedStatement;
        try {
            String updateQuery = "UPDATE COUR SET nomCour = ?, descriptionCour = ?, codeCour = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(updateQuery);

            // Set parameters for Etudiant
            preparedStatement.setString(1, c.getNomCour());
            preparedStatement.setString(2, c.getDescriptionCour());
            preparedStatement.setString(3, c.getCodeCour());
            preparedStatement.setInt(4, c.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            System.out.println("executed query = " + updateQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM COUR WHERE ID = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Cour> findAll() {
        List<Cour> cours = new ArrayList<>();
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM COUR ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cour cour = new Cour();
                cour.setId(resultSet.getInt("id"));
                cour.setNomCour(resultSet.getString("nomCour"));
                cour.setDescriptionCour(resultSet.getString("descriptionCour"));
                cour.setCodeCour(resultSet.getString("codeCour"));

                cours.add(cour);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cours;
    }

    @Override
    public Cour findById(int id) {
        Cour cour = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM Cour WHERE id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cour = new Cour();
                cour.setId(resultSet.getInt("id"));
                cour.setNomCour(resultSet.getString("nomCour"));
                cour.setDescriptionCour(resultSet.getString("descriptionCour"));
                cour.setCodeCour(resultSet.getString("codeCour"));
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cour;
    }
   
}



