package cz.martin.models;

public class Hero {
    private String pseudonym;
    private String fullName;
    private String gender;
    private String race;
    private String alignment;


    public Hero(String pseudonym, String fullName, String gender, String race, String alignment) {
        this.pseudonym = pseudonym;
        this.fullName = fullName;
        this.gender = gender;
        this.race = race;
        this.alignment = alignment;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getAlignment() {
        return alignment;
    }
}
