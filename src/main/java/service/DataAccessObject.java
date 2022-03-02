package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class DataAccessObject {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";

    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }
}
