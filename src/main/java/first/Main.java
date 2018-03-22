package first;

import second.HashEntry;
import second.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap map=new HashMap();
        map.insert(0,"0");
        map.insert(1,"1");
        map.insert(2,"2");       ;
        map.insert(3,"3");
        //map.get(0);
        //map.get(1);
        //map.remove(0);
        map.showTable();
    }
}
