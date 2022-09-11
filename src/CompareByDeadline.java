import java.util.Comparator;

public class CompareByDeadline implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t1.getDeadline().compareTo(t2.getDeadline());
    }
}
