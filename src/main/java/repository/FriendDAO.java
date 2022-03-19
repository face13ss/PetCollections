package repository;

import model.Friend;
import repository.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO extends DataAccessObject {

    private static final String SELECT_BY_NAME = "SELECT id, displayName FROM users where displayName like ?;";
    private static final String ADD_FRIENDS = "INSERT INTO relationships (userId, friendId, inRelation) values (?,?,?);";

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
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return peopleList;
    }
}
