package second;
public class HashEntry {
    private String key;
    private String value;
    public HashEntry(String key, String value) {
        this.key = key;
        this.value=value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    @Override
    public boolean equals(Object other){
        HashEntry o=(HashEntry)other;
        if(o==null|| this==null){
            if(o==null&&this==null)
                return true;
            else
                return false;
        }
        return o.key==this.key&&o.value==this.value;
    }
}