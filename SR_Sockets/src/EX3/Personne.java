package EX3;

import java.io.Serializable;

public class Personne implements Serializable {

    private String nom;
    private int age;
    private int Id;
    private static int uniqueID = 0;

    Personne(int age, String name) {
        this.nom = name;
        this.age = age;
        Id = Personne.getNextUniqueID();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNextUniqueID() {
        uniqueID++;
        return uniqueID;
    }

    public int getId() {
        return Id;
    }

    public String toString() {
        return getNom() + " " + getAge() + " " + getId();
    }
}