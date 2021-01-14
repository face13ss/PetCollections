package service;

import com.sun.jndi.cosnaming.CNCtx;
import model.User;

import java.sql.*;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";
    private static final String SELECT_USER_BY_USERNAME = "select * FROM users where username = ?";
    private static final String INSERT_USER = "INSERT INTO users(username,password,displayName,email,eggs) value (?,?,?,?,?)";
    private static final String UPDATE_EGGS = "UPDATE users SET eggs = ? WHERE id = ?;";
    private static final String UPDATE_MONEY = "UPDATE users SET money = ? WHERE id = ?;";
    private static final String PASSWORD_UPDATE = "UPDATE users SET password = ? where id = ?;";

    public UserDAO(){}

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
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
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public User selectUser(String username) {
        User user = null;
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

                user = new User(id,username,password,displayName,email,money,eggs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {

        return false;
    }

    public boolean updateUserEggs(User user) {
        boolean rowUpdate = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EGGS)){

            preparedStatement.setInt(1,0);
            preparedStatement.setInt(2,user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e){
            e.printStackTrace();
        }

        return rowUpdate;
    }

    public boolean updateUserMoney(User user){
        boolean updateMoney = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MONEY)){
            preparedStatement.setInt(1,user.getMoney());
            preparedStatement.setInt(2,user.getId());
            updateMoney = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return updateMoney;
    }

    public boolean updatePassword(User user){
        boolean passwordChange = false;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(PASSWORD_UPDATE)){
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setInt(2,user.getId());
            passwordChange = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
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
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isValid;
    }
}

