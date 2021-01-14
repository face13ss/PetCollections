package model;

public class Pet {
    private int id;
    private String petName;
    private int petType;
    private int attack;
    private int health;
    private int hunger;
    private int dodge;
    private int exp;
    private int upPerLevel;



    private int petOf;

    public Pet(){}

    public Pet(String petName, int petType, int attack, int health, int hunger, int dodge, int exp,int upPerLevel,int petOf) {
        this.petName = petName;
        this.petType = petType;
        this.attack = attack;
        this.health = health;
        this.hunger = hunger;
        this.dodge = dodge;
        this.upPerLevel = upPerLevel;
        this.exp = exp;
        this.petOf = petOf;
    }
    public Pet(int id,String petName, int petType, int attack, int health, int hunger, int dodge, int exp,int upPerLevel,int petOf) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.attack = attack;
        this.health = health;
        this.hunger = hunger;
        this.dodge = dodge;
        this.upPerLevel = upPerLevel;
        this.exp = exp;
        this.petOf = petOf;
    }

    public Pet(int id, String petName, int petType, int attack, int health, int hunger, int doge) {
        this.id = id;
        this.petName = petName;
        this.petType = petType;
        this.attack = attack;
        this.health = health;
        this.hunger = hunger;
        this.dodge = doge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getPetType() {
        return petType;
    }

    public void setPetType(int petType) {
        this.petType = petType;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int doge) {
        this.dodge = doge;
    }

    public int getPetOf() {
        return petOf;
    }

    public void setPetOf(int petOf) {
        this.petOf = petOf;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public int getUpPerLevel() {
        return upPerLevel;
    }

    public void setUpPerLevel(int upPerLevel) {
        this.upPerLevel = upPerLevel;
    }
}
