package first;

import second.HashEntry;
import second.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap map=new HashMap();
        map.put(0,"0");
        map.put(0,"0");
        map.remove(0);
        map.showTable();
    }
}
