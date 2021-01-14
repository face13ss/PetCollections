package model;

public class PetType {
    private int id;
    private String species;
    private int baseDamage;
    private int baseHP;
    private int baseHunger;
    private int baseDodge;
    private int upState;

    public PetType(int id, String species, int baseDamage, int baseHP, int baseHunger, int baseDodge, int upState) {
        this.id = id;
        this.species = species;
        this.baseDamage = baseDamage;
        this.baseHP = baseHP;
        this.baseHunger = baseHunger;
        this.baseDodge = baseDodge;
        this.upState = upState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }

    public int getBaseHunger() {
        return baseHunger;
    }

    public void setBaseHunger(int baseHunger) {
        this.baseHunger = baseHunger;
    }

    public int getBaseDodge() {
        return baseDodge;
    }

    public void setBaseDodge(int baseDodge) {
        this.baseDodge = baseDodge;
    }

    public int getUpState() {
        return upState;
    }

    public void setUpState(int upState) {
        this.upState = upState;
    }
}
