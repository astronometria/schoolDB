/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
   private static Connection connection = null;

    public static final String URL = "jdbc:mysql://localhost/school";
    public static final String USER = "root";
    public static final String PASS = "";
    public static Connection getConnection()  {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
       }
        try {
          
            connection = DriverManager.getConnection(URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }
    }

    public void closeConnection() throws SQLException {

        if (connection != null) {
            connection.close();
        }
    }
}