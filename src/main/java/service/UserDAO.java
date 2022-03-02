package service;

import model.User;

import java.sql.*;
import java.util.List;

public class UserDAO extends DataAccessObject implements IUserDAO {
    private static final String SELECT_USER_BY_USERNAME = "select * FROM users where username = ?";
    private static final String INSERT_USER = "INSERT INTO users(username,password,displayName,email,eggs) value (?,?,?,?,?)";
    private static final String UPDATE_EGGS = "UPDATE users SET eggs = ? WHERE id = ?;";
    private static final String UPDATE_MONEY = "UPDATE users SET money = ? WHERE id = ?;";
    private static final String PASSWORD_UPDATE = "UPDATE users SET password = ? where id = ?;";

    public UserDAO(){}

    @Override
    public void insertUser(User user){
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)){
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getDisplayName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setInt(5,3);

            preparedStatement.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(String username) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)){
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String password = rs.getString("password");
                String displayName = rs.getString("displayName");
                String email = rs.getString("email");
                int money = rs.getInt("money");
                int eggs = rs.getInt("eggs");

                return new User(id,username,password,displayName,email,money,eggs);
            }
            rs.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {

        return false;
    }

    public boolean updateUserEggs(User user) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EGGS)){

            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUserMoney(User user){
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MONEY)){
            preparedStatement.setInt(1,user.getMoney());
            preparedStatement.setInt(2,user.getId());
            return preparedStatement.executeUpdate() > 0;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(User user){
        boolean passwordChange = false;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(PASSWORD_UPDATE)){
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2,user.getId());
            passwordChange = preparedStatement.executeUpdate() > 0;
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return passwordChange;
    }

    public boolean checkLogin(String username){
        boolean isValid = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME)){
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                isValid = true;
            }else {
                isValid = false;
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return isValid;
    }
}

