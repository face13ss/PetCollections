package service;

import model.Pet;
import model.PetType;

import java.sql.*;
import java.util.List;

public class PetTypeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";

    private static final String SELECT_PETTYPE_BY_ID = "SELECT * FROM pettypes where id=?;";
    private static final String SELECT_ALL_PETTYPES = "SELECT * FROM pettypes;";

    public PetTypeDAO(){
    }

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
    public Pet randomPet(int userid){
        Pet pet = null;
        int id = (int) (Math.random()*(7-1) +1);
        try(Connection connection = getConnection();
           PreparedStatement statement = connection.prepareStatement(SELECT_PETTYPE_BY_ID)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String name =  resultSet.getString("species");
                int attack = resultSet.getInt("baseDamage");
                int health = resultSet.getInt("baseHP");
                int hunger = resultSet.getInt("baseHunger");
                int dodge = resultSet.getInt("baseDodge");
                int upPerLevel = resultSet.getInt("upPerLevel");
                PetDAO petDAO = new PetDAO();
                petDAO.insertPet(new Pet(name,id,attack,health,hunger,dodge,0,upPerLevel,userid));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return pet;
    }
    public PetType getPetType(int id){
        PetType petType = null;

        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PETTYPE_BY_ID)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String species =  resultSet.getString("species");
                int baseDamage = resultSet.getInt("baseDamage");
                int baseHealth = resultSet.getInt("baseHP");
                int baseDodge = resultSet.getInt("baseDodge");
                int upStatePerLevel = resultSet.getInt("upPerLevel");
                petType = new PetType(id, species,baseDamage,baseHealth,baseDamage,baseDodge,upStatePerLevel);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return petType;
    }
}
