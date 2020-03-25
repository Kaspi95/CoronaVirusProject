package main.Model;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Date;

public class Person {

    Person Parent1;
    Person Parent2;

    ArrayList<Person> children = new ArrayList<Person>();

    String name;
    Date birthDate;
    Date deathDate;
    String birthPlace;
    String deathPlace;
    String job;

    public Person(String name, Date birthDate, String birthPlace, Date deathDate,  String deathPlace) {
        this.name=name;
        this.birthDate=birthDate;
        this.birthPlace=birthPlace;
        this.deathDate=deathDate;
        this.deathPlace=deathPlace;
    }

    public Person(String name, Date birthDate, String birthPlace) {
        new Person(name,birthDate,birthPlace,null,null);
    }


    public void getDetails(){} //TODO: retrurn value
    public ArrayList<Person> getParents() {
        //TODO
        return null;
    }
    public ArrayList<Person> getChildren() {
        //TODO
        return null;
    }

    public void kill(String place) {}
    public void newChild(Person child) {}
    public void removeChild(Person child) {}

}
