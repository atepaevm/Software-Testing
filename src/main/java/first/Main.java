package first;

import second.HashEntry;
import second.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap map=new HashMap();

        map.insert("123","0");//0-5-6-8-0
        HashEntry[] standard={new HashEntry("123","0"),null,null};
        map.insert("584","1");//0-5-6-8-0
        map.insert("456","2");//0-5-6-8-0
        map.insert("963","3");//0-5-6-7-0

       //map.remove("2");
        //map.get(0);
        //map.get(1);
        //map.remove(0);
        map.showTable();
    }
}
