package main.Controller;

import main.Model.DataBase;
import main.Model.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Controller.getInstance().initialize();
        //System.out.println(System.getProperty("user.dir")+ "\\dataBase\\database.db"); // This will work only under Windows
        DataBase dataBase = new DataBase(System.getProperty("user.dir") + "\\dataBase\\database.db");
        //Person person=new Person("Pista", LocalDate.of(1992,12,20),"Bp","25b21127-368a-4dd2-a8db-6403729229f1","ffe47767-e519-4637-a880-1a827cba5e98");
        //dataBase.addNewPerson(person);
        dataBase.printDataBase();
        //dataBase.selectPerson("25b21127-368a-4dd2-a8db-6403729229f1");
        //dataBase.selectChildren(null);
        dataBase.modifyPerson("b731c8b9-7db4-4a31-b431-564d7904b5ce", "name", "Geza");

    }
}
