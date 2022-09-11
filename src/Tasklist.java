import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class Tasklist implements Saveable {
    ArrayList<Task> taskList = new ArrayList<Task>();
    Separator s = new Separator();

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public void addToTaskList(Task... tasks) {
        taskList.addAll(Arrays.asList(tasks));
    }

    public void printTasks() {
        for (Task task : taskList) {
            var addDate = LocalDateTime.parse(task.getAddDate(), task.getFormatter());
            var deadline = LocalDateTime.parse(task.getDeadline(), task.getFormatter());
            var period = Period.between(addDate.toLocalDate(), deadline.toLocalDate());

            System.out.println(task.getId());
            System.out.println(task.getPriority());
            System.out.println(task.getCreator());
            System.out.println(task.getDescription());
            System.out.println(task.getAddDate());
            System.out.println(task.getDeadline());
            System.out.println("Days to deadline: " + period.getDays());
            s.pr();
        }
    }

    public void readTasklistFromFile(String filename, Extension ext) {
        FileManager fw = new FileManager();
        taskList = fw.readFromFile(filename, ext);
        reCalcIds();
    }

    public void reCalcIds() {
        new Id().reSetId();
        for (Task task : taskList) {
            Id newID = new Id();
            task.setId(newID);
        }
    }

    public void removeTask(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                taskList.remove(task);
                reCalcIds();
                System.out.println("Task #" + id + " removed");
                s.pr();
                return;
            }
        }
        System.out.println("Task #" + id + " not exist");
        s.pr();
    }

    public void sortById() {
        taskList.sort(new CompareById());
    }

    public void sortByPriority() {
        taskList.sort(new CompareByPriority());
    }

    public void sortByDeadline() {
        taskList.sort(new CompareByDeadline());
    }
}
