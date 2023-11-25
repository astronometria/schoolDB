package DaoImp;


import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import interfaceDao.UserDao;


public class UserDaoImplementation implements UserDao{
    
    Connection connection = ConnectionFactory.getConnection();

    // Constructor 
    public UserDaoImplementation() {

    }

    // Create a new User
    public void create(User user) {

        PreparedStatement preparedStatement;

        try {
            String createQuery = "INSERT INTO USER(username, password) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            
            
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find by id
    @Override
    public User findById(int id) {

        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM USER where id = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    // find All people
    public List<User> findAll() {
        System.out.println("in findall()");
        List<User> users = new ArrayList<>();
        User user = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM USER ORDER BY ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                users.add(user);
                System.out.println(user.toString());
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    // Update user's info
    public void update(User user) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE USER SET USERNAME = ? WHERE ID = ?";
            //System.out.println("Query = " + updateQuery);
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setInt(2, user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete person
    public void delete(int id) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM USER WHERE ID =" + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findByUserName(String userName) {
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM USER where username = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }
    
}
