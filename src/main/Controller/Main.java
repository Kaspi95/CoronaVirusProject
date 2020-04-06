package main.Controller;

import main.Model.DataBase;
import main.Model.People;
import main.Model.Person;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args){
        Controller.getInstance().initialize();
        //System.out.println(System.getProperty("user.dir")+ "\\dataBase\\database.db"); // This will work only under Windows
        DataBase dataBase = new DataBase(System.getProperty("user.dir") + "\\dataBase\\database.db");
        Person person=new Person("Geza2", LocalDate.of(1995,12,20),"Bp","1d888d15-3444-4f9b-9c31-21f00e46ffb4","1d888d15-3444-4f9b-9c31-21f00e46ffb4");
        Person person1=new Person("Geza3", LocalDate.of(1995,12,20),"Bp","1d888d15-3444-4f9b-9c31-21f00e46ffb4","1d888d15-3444-4f9b-9c31-21f00e46ffb4");
        dataBase.addNewPerson(person);
        dataBase.addNewPerson(person1);

        dataBase.selectPerson("b0f2ef32-50f9-436f-bcf1-09ad4287ba12");
        dataBase.selectChildren(null);
        dataBase.modifyPerson("1d888d15-3444-4f9b-9c31-21f00e46ffb4", "name", "Jozsi");
        dataBase.modifyPerson("e1d7804d-a811-459e-bec3-42e42047b3e7", "deathDate", LocalDate.of(2002,10,01));


        dataBase.printDataBase();

        People people=new People(dataBase);

    }
}
