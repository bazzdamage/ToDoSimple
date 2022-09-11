public class Id {
    static int id = 0;
    private final int currentId;

    public Id() {
        id++;
        this.currentId = id;
    }

    public int getId() {
        return currentId;
    }

    public void reSetId() {
        id = 0;
    }

}
