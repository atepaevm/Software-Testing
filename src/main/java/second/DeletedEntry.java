package second;

public class DeletedEntry extends HashEntry {
    private static DeletedEntry entry = null;
    private DeletedEntry() {
        super(-1, "DELETED");
    }
    public static DeletedEntry getUniqueDeletedEntry() {
        if (entry == null)
            entry = new DeletedEntry();
        return entry;
    }
}
