package service;

import model.Friend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";
    private static final String SELECT_BY_NAME = "SELECT id, displayName FROM users where displayName like ?;";
    private static final String ADD_FRIENDS = "INSERT INTO relationships (userId, friendId, inRelation) values (?,?,?);";


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
    public List<Friend> showPeople(String searchName){
        List<Friend> peopleList = new ArrayList<>();

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_NAME)){
            preparedStatement.setString(1,"%"+searchName+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String displayName = resultSet.getString("displayName");
                peopleList.add(new Friend(id,displayName));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return peopleList;
    }
}
