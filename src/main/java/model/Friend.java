package model;

public class Friend {
    private int id;
    private String displayName;
    private String inRelation;

    public Friend(int id, String displayName, String inRelation){
        this.id = id;
        this.displayName = displayName;
        this.inRelation = inRelation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getInRelation() {
        return inRelation;
    }

    public void setInRelation(String inRelation) {
        this.inRelation = inRelation;
    }
}
