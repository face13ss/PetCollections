package repository;

import model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface IpetDAO {
    public void insertPet(Pet pet) throws SQLException;

    public Pet selectPet(int id);

    public List<Pet> selectAllPetByUserId(int userId);

    public boolean deletePet(int id) throws SQLException;

    public boolean updatePet(Pet pet) throws SQLException;
}
