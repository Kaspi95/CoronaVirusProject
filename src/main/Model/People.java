package main.Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class People {

    ArrayList<TreeMap<String,Person>> localFamilyTree = new ArrayList<TreeMap<String,Person>>();

    public People(DataBase dataBase){

        localFamilyTree.add(dataBase.selectAll());

        this.sort();
    }

    public void sort() {
        if(localFamilyTree.get(0).firstEntry()!=null){
            String p1=localFamilyTree.get(0).firstEntry().getValue().getParentID1();
            String p2=localFamilyTree.get(0).firstEntry().getValue().getParentID2();

            for (TreeMap<String,Person> level :localFamilyTree) {
                level.get(p1);

                }

            }
        }

        /*
        int next=0;
        ArrayList<Person> level;
        while(level.forEach();)) {
            level = localFamilyTree.get(next
            next++;
        }
        */
    }
}
