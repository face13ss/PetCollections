package service;

import model.Friend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class FriendDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";


    public FriendDAO(){}

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    public List<Friend> searchList()
}
