package repository;

import model.Pet;
import repository.IpetDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO implements IpetDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/petcollections?useSSL=false";
    private String jdbcUsername = "admin";
    private String jdbcPassword = "Admin@123";

    private static final String INSERT_PET_SQL = "INSERT INTO pets"
            + " (petName, petType, attack, health, hunger, dodge, exp,upPerLevel, petOf) value "
            + "(?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_BY_USER = "SELECT * FROM pets where petOf=?";
    private static final String SELECT_BY_ID = "SELECT * FROM pets where id=?";
    private static final String DELETE_BY_ID = "DELETE FROM pets where id=?";

    public PetDAO(){}

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
    @Override
    public void insertPet(Pet pet) throws SQLException {
        System.out.println(INSERT_PET_SQL);
        //(petName, petType, attack, health, hunger, dodge, exp)
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PET_SQL)){
            preparedStatement.setString(1,pet.getPetName());
            preparedStatement.setInt(2, pet.getPetType());
            preparedStatement.setInt(3,pet.getAttack());
            preparedStatement.setInt(4,pet.getHealth());
            preparedStatement.setInt(5,pet.getHunger());
            preparedStatement.setInt(6,pet.getDodge());
            preparedStatement.setInt(7,pet.getExp());
            preparedStatement.setInt(8,pet.getUpPerLevel());
            preparedStatement.setInt(9,pet.getPetOf());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Pet selectPet(int id) {
        Pet pet = null;
        return pet;
    }

    @Override
    public List<Pet> selectAllPetByUserId(int userId) {
        List<Pet> petList = new ArrayList();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BY_USER)){
            preparedStatement.setInt(1,userId);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String petName = rs.getString("petName");
                int petType = rs.getInt("petType");
                int attack = rs.getInt("attack");
                int health = rs.getInt("health");
                int hunger = rs.getInt("hunger");
                int dodge = rs.getInt("dodge");
                int exp = rs.getInt("exp");
                int upPerLevel = rs.getInt("upPerLevel");
                int petOf = rs.getInt("petOf");
                petList.add(new Pet(id,petName,petType,attack,health,hunger,dodge,exp,upPerLevel,petOf));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return petList;
    }

    @Override
    public boolean deletePet(int id){
        boolean rowDelete = false;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)){
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public boolean updatePet(Pet pet) throws SQLException {
        return false;
    }
}
