package second;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HashMap {

    private final static int TABLE_SIZE = 3;
    private final static Logger log=Logger.getLogger("java.test.log");
    FileHandler fh;
    public HashEntry[] table;
    public int hash(String s){
        int hash=0;
        for(int i=s.length()-1;i>=0;--i){
            char c=s.charAt(i);
            hash<<=4;
            hash+=c;
        }
        return hash;
    }
    public HashMap() {
        String path="src\\test\\java\\second\\log";
        try {
            fh=new FileHandler(path);
        } catch (IOException e) {
           log.log(Level.WARNING, "CONSTRUCTOR: can't find file: "+path);
        }
        log.addHandler(fh);
        fh.setFormatter(new SimpleFormatter());
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    public HashEntry[] getTable(){
        return this.table;
    }
    public String get(String key) {
        log.log(Level.INFO,"In GET method, key="+key);
        //int hash = (key % TABLE_SIZE);
        int hash=this.hash(key)%TABLE_SIZE;
        int counter=0;
        while(table[hash]!=null&&counter<TABLE_SIZE){
            log.log(Level.INFO,"GET: in while, cur key="+table[hash].getKey());
            ++counter;
            if(table[hash].getKey()==key) {
                log.log(Level.INFO,"GET: keys're equal: "+key+", return");
                return table[hash].getValue();
            }
            hash=(hash+1)%TABLE_SIZE;
        }
        log.log(Level.INFO,"GET: not find entry, return null");
        return null;
    }

    public void insert(String key, String value) {
        log.log(Level.INFO,"In INSERT method,key="+key+" value="+value);
        //int hash = (key % TABLE_SIZE);
        int hash=this.hash(key)%TABLE_SIZE;
        int counter=0;
        while(table[hash]!=null&&table[hash]!=DeletedEntry.getUniqueDeletedEntry()&&counter<TABLE_SIZE){
            ++counter;
            log.log(Level.INFO,"INSERT: in while, cur key="+table[hash].getKey());
            hash=(hash+1)%TABLE_SIZE;
        }
        if(counter==TABLE_SIZE){
            log.log(Level.INFO,"INSERT: can't insert ("+key+","+value+"), table's full");
            return;
        }
        log.log(Level.INFO,"INSERT: inserting ("+key+","+value+")");
        table[hash]=new HashEntry(key,value);
        return;
    }

    public void remove(String key) {
        //int hash = (key % TABLE_SIZE);
        int hash=this.hash(key)%TABLE_SIZE;
        int counter=0;
        log.log(Level.INFO,"In REMOVE method,key="+key);
        while(table[hash]!=null&&counter<TABLE_SIZE){
            //if node found
            log.log(Level.INFO,"REMOVE: in while, cur key="+table[hash].getKey());
            if(table[hash].getKey()==key){
                log.log(Level.INFO,"REMOVE: deleting entry with key="+table[hash].getKey());
                table[hash]=DeletedEntry.getUniqueDeletedEntry();
                return;
            }
            ++counter;
            hash=(hash+1)%TABLE_SIZE;
        }
        log.log(Level.INFO,"REMOVE: entry doesn't exist, return");
    }
    public void showTable(){
        for(int i=0;i<table.length;++i){
            if(table[i]==null)
                System.out.println(i+") null");
            else if(table[i]==DeletedEntry.getUniqueDeletedEntry())
                System.out.println(i+") del");
            else
                System.out.println(i+") "+table[i].getKey()+", "+table[i].getValue());
        }
    }
}