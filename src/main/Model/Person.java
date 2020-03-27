package main.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

public class Person {

    String ParentID1;
    String ParentID2;

    String id;

    String name;
    LocalDate birthDate;
    LocalDate deathDate;
    String birthPlace;
    String deathPlace;


    public Person(String name, LocalDate birthDate, String birthPlace, String ParentID1, String ParentID2, LocalDate deathDate, String deathPlace) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
        this.ParentID1 = ParentID1;
        this.ParentID2 = ParentID2;
    }

    public Person(String name, LocalDate birthDate, String birthPlace, String ParentID1, String ParentID2) {
        this(name, birthDate, birthPlace, ParentID1, ParentID2, null, null);
    }

    public Person(String name, LocalDate birthDate, String birthPlace) {
        this(name, birthDate, birthPlace, null, null, null, null);
    }


    public void getDetails() {
    } //TODO: retrurn value

    public ArrayList<Person> getParents() {
        //TODO
        return null;
    }

    public ArrayList<Person> getChildren() {
        //TODO
        return null;
    }

    public void kill(String place) {
    }

    public void newChild(Person child) {
    }

    public void removeChild(Person child) {
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public LocalDate getDeathDate() {
        return this.deathDate;
    }

    public String getBirthPlace() {
        return this.birthPlace;
    }

    public String getDeathPlace() {
        return this.deathPlace;
    }

    public String getParentID1() {
        return this.ParentID1;
    }

    public String getParentID2() {
        return this.ParentID2;
    }
}
