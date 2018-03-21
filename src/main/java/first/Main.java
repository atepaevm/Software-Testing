package first;

import second.HashEntry;
import second.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap map=new HashMap();
        map.insert(0,"0");
        map.insert(0,"0");
        map.get(0);
        map.get(1);
        map.remove(0);
        //map.showTable();
    }
}
