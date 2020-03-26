package main.Controller;

import main.Model.DataBase;
import main.Model.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Controller.getInstance().initialize();
        //System.out.println(System.getProperty("user.dir")+ "\\dataBase\\database.db"); // This will work only under Windows
        DataBase dataBase = new DataBase(System.getProperty("user.dir") + "\\dataBase\\database.db");
        Person person=new Person("Pista", LocalDate.of(1992,12,20),"Bp");
        dataBase.addNewPerson(person);
        dataBase.printDataBase();

    }
}
