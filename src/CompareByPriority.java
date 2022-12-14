import java.util.Comparator;

public class CompareByPriority implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return t2.getPriority().compareTo(t1.getPriority());
    }
}
