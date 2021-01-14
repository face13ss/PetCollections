package model;

import com.sun.corba.se.spi.orb.StringPair;

public class User {
    private int id;
    private String username;
    private String password;
    private String displayName;
    private String email;
    private int money;
    private int eggs;

    public User(){}

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String displayName, String email){
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
    }
    public User(int id, String username, String password,String displayName, String email, int money, int eggs){
        this.id = id;
        this.username = username;
        this.password = password;
        this.displayName = displayName;
        this.email = email;
        this.money = money;
        this.eggs = eggs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
}
