package second;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

public class HashMapTest {
    private static HashMap insertMap=null;
    private static HashMap getMap=null;
    private static HashMap removeMap=null;
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
    @BeforeClass
    public static void initialize(){
        String insertPath="src\\main\\test\\second\\insertTestLog";
        String getPath="src\\main\\test\\second\\getTestLog";
        String removePath="src\\main\\test\\second\\removeTestLog";
        insertMap=new HashMap(insertPath);
        getMap=new HashMap(getPath);
        removeMap=new HashMap(removePath);
    }
    @Test
    public void insertTest() {
        int testNumber=0;
        //HashMap map=new HashMap();

        insertMap.insert("123","0");//0-5-6-8-0
        HashEntry[] standard={new HashEntry("123","0"),null,null};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("INSERT",testNumber,i,insertMap.getTable()[i],standard[i]),insertMap.getTable()[i],standard[i]);
        ++testNumber;

        insertMap.insert("584","1");//0-5-6-8-0
        standard=new HashEntry[]{new HashEntry("123","0"),null,new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("INSERT",testNumber,i,insertMap.getTable()[i],standard[i]),insertMap.getTable()[i],standard[i]);
        ++testNumber;

        insertMap.insert("456","2");//0-5-6-8-0
        standard=new HashEntry[]{new HashEntry("123","0"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("INSERT",testNumber,i,insertMap.getTable()[i],standard[i]),insertMap.getTable()[i],standard[i]);
        ++testNumber;

        insertMap.insert("963","3");//0-5-6-7-0
        standard=new HashEntry[]{new HashEntry("123","0"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("INSERT",testNumber,i,insertMap.getTable()[i],standard[i]),insertMap.getTable()[i],standard[i]);
    }
    @Test
    public void getTest() {
        int testNumber=0;
        //HashMap map=new HashMap();
        getMap.insert("123","0");//0-5-6-8-0
        getMap.insert("584","1");//0-5-6-8-0
        getMap.insert("456","2");//0-5-6-8-0

        String entry=getMap.get("123");//0-1-2-4-0
        assertEquals("GET: TEST"+testNumber+", expected: 0, actual: "+entry,"0",entry);
        ++testNumber;

        entry=getMap.get("NONE");//0-1-2-3-0
        assertEquals("GET: TEST "+testNumber+", expected: null, actual: "+entry,null,entry);
        ++testNumber;
    }
    @Test
    public void removeTest() {
        int testNumber=0;
        //HashMap map=new HashMap();
        removeMap.insert("123","0");//0-5-6-8-0
        removeMap.insert("584","1");//0-5-6-8-0
        removeMap.insert("456","2");//0-5-6-8-0
        removeMap.remove("123");//0-9-10-12-0
        HashEntry[] standard=new HashEntry[]{new HashEntry("DELETED","DELETED"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("REMOVE",testNumber,i,removeMap.getTable()[i],standard[i]),removeMap.getTable()[i],standard[i]);
        ++testNumber;
        removeMap.remove("666");//0-9-10-11-0
        standard=new HashEntry[]{new HashEntry("DELETED","DELETED"),new HashEntry("456","2"),new HashEntry("584","1")};
        for(int i=0;i<standard.length;++i)
            assertEquals(getMessage("REMOVE",testNumber,i,removeMap.getTable()[i],standard[i]),removeMap.getTable()[i],standard[i]);

    }
}