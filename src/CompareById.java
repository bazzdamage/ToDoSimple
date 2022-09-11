import java.util.Comparator;

public class CompareById implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t2.getId() - t1.getId() < 0) return -1;
        else if (t2.getId() - t1.getId() > 0) return 1;
        else return 0;
    }
}
