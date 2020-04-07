package main.Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class People {

    ArrayList<TreeMap<String, Person>> localFamilyTree = new ArrayList<TreeMap<String, Person>>();

    public People(DataBase dataBase) {

        localFamilyTree.add(dataBase.selectAll());

        this.sort();
    }

    public void sort() {        //TODO atalkitani h rekurzivan hivhato legyen
        if (localFamilyTree.get(0).firstEntry() != null) {  //ha van elem a halmazban
            String p1 = localFamilyTree.get(0).firstEntry().getValue().getParentID1();
            String p2 = localFamilyTree.get(0).firstEntry().getValue().getParentID2();
            if (p1 == null && p2 == null) {     //de nincs szuloje
                //TODO akkor megvan a gyoker elem
            } else {                              //viszont ha van legalabb egy
                localFamilyTree.add(1, new TreeMap<String, Person>());  //TODO ezt nem lehet sokszorositani!!!
                if (p1 != null) {
                    localFamilyTree.get(1).put(p1, localFamilyTree.get(0).get(p1));
                    localFamilyTree.get(0).remove(localFamilyTree.get(0).get(p1));
                }
                if (p2 != null) {
                    localFamilyTree.get(1).put(p2, localFamilyTree.get(0).get(p2));
                    localFamilyTree.get(0).remove(localFamilyTree.get(0).get(p2));
                }
            }
        } else
            System.out.println("Az adatbazis ures vagy a lekerdezes sikertelen volt"); //TODO hibakezeles
    }   //TODO a legvegen lefutatni a localFamilyTree.reverse()-t

        /*
        int next=0;
        ArrayList<Person> level;
        while(level.forEach();)) {
            level = localFamilyTree.get(next
            next++;
        }
        */
}

