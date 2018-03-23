package second;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    String getMessage(String method,int testNumber, int element, HashEntry o1,HashEntry o2){
        String mes="Method: "+method+", test: "+testNumber+", element: "+element+". Expected: (";
        if(o1==null)
            mes+=null;
        else
            mes+=o1.getKey()+","+o1.getValue();
        mes+="), actual (";
        if(o2==null)
            mes+=null;
        else
            mes+=o2.getKey()+","+o2.getValue()+")";
        return mes;
    }
    @Test
    public void test() {
        int testNumber=0;
        HashMap map=new HashMap();

        map.insert("123","0");//0-5-6-8-0
        HashEntry[] standard={new HashEntry("123","0"),null,null};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;

        map.insert("584","1");//0-5-6-8-0
        standard=new HashEntry[]{new HashEntry("123","0"),null,new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;

        map.insert("456","2");//0-5-6-8-0
        standard=new HashEntry[]{new HashEntry("123","0"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;

        map.insert("963","3");//0-5-6-7-0
        standard=new HashEntry[]{new HashEntry("123","0"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;

        String entry=map.get("123");//0-1-2-4-0
        assertEquals("TEST"+testNumber+", expected: 0, actual: "+entry,"0",entry);
        ++testNumber;

        entry=map.get("NONE");//0-1-2-3-0
        assertEquals("Test "+testNumber+", expected: null, actual: "+entry,null,entry);
        ++testNumber;

        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;

        map.remove("123");//0-9-10-12-0
        standard=new HashEntry[]{new HashEntry("DELETED","DELETED"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;
        map.remove("666");//0-9-10-11-0
        standard=new HashEntry[]{new HashEntry("DELETED","DELETED"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("GET",testNumber,i,map.getTable()[i],standard[i]),map.getTable()[i],standard[i]);
        ++testNumber;
        //map.showTable();
    }

}