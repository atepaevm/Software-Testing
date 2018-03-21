package second;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class HashMap {

    private final static int TABLE_SIZE = 29;
    private final static Logger log=Logger.getLogger("java.test.log");
    FileHandler fh;
    public HashEntry[] table;
    public HashMap() {
        String path="src\\main\\test\\second\\log";
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
    public String get(int key) {
        log.log(Level.INFO,"In GET method, key="+key);
        int hash = (key % TABLE_SIZE);
        while(table[hash]!=null){
            log.log(Level.INFO,"GET: in while entry!=null");
            if(table[hash].getKey()==key) {
                log.log(Level.INFO,"GET: keys're equal: "+key+", return");
                return table[hash].getValue();
            }
            hash=(hash+1)%TABLE_SIZE;
        }
        log.log(Level.INFO,"GET: not find entry, return null");
        return null;
        /*
        int hash = (key % TABLE_SIZE);
        int initialHash = -1;
        while (hash != initialHash
                && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initialHash == -1)
                initialHash = hash;
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (table[hash] == null || hash == initialHash)
            return null;
        else
            return table[hash].getValue();
            */
    }

    public void insert(int key, String value) {
        int hash = (key % TABLE_SIZE);
        while(table[hash]!=null&&table[hash]!=DeletedEntry.getUniqueDeletedEntry()){
            hash=(hash+1)%TABLE_SIZE;
        }
        table[hash]=new HashEntry(key,value);
/*        int indexOfDeletedEntry = -1;
        while (hash != initialHash
                && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initialHash == -1)
                initialHash = hash;
            if (table[hash] == DeletedEntry.getUniqueDeletedEntry())
                indexOfDeletedEntry = hash;
            hash = (hash + 1) % TABLE_SIZE;
        }
        if ((table[hash] == null || hash == initialHash)
                && indexOfDeletedEntry != -1)
            table[indexOfDeletedEntry] = new HashEntry(key, value);
        else if (initialHash != hash)
            if (table[hash] != DeletedEntry.getUniqueDeletedEntry()
                    && table[hash] != null && table[hash].getKey() == key)
                table[hash].setValue(value);
            else
                table[hash] = new HashEntry(key, value);
                */
    }

    public void remove(int key) {
        int hash = (key % TABLE_SIZE);
        int counter=0;
        while(table[hash]!=null&&counter<TABLE_SIZE){
            //if node found
            if(table[hash].getKey()==key){
                table[hash]=DeletedEntry.getUniqueDeletedEntry();
            }
            ++counter;
            hash=(hash+1)%TABLE_SIZE;
        }
        /*
        int initialHash = -1;
        while (hash != initialHash
                && (table[hash] == DeletedEntry.getUniqueDeletedEntry() || table[hash] != null
                && table[hash].getKey() != key)) {
            if (initialHash == -1)
                initialHash = hash;
            hash = (hash + 1) % TABLE_SIZE;
        }
        if (hash != initialHash && table[hash] != null)
            table[hash] = DeletedEntry.getUniqueDeletedEntry();
            */
    }
    public void showTable(){
        for(int i=0;i<table.length;++i){
            if(table[i]==null)
                System.out.println("null");
            else if(table[i]==DeletedEntry.getUniqueDeletedEntry())
                System.out.println("del");
            else
                System.out.println(table[i].getKey()+", "+table[i].getValue());
        }
    }
}