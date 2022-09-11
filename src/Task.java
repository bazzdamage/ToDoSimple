import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Priority priority;
    private Id id;
    private String creator;
    private String description;
    private String addDate;
    private String deadline;


    public Task(Priority priority, String creator, String description, int daysToDeadline) {

        LocalDateTime now = LocalDateTime.now();
        this.priority = priority;
        this.creator = creator;
        this.description = description;
        this.addDate = now.format(formatter);
        this.id = new Id();
        this.deadline = now.plusDays(daysToDeadline).format(formatter);
    }

    public Task(Priority priority, String creator, String description, String addDate, String deadline) {

        LocalDateTime now = LocalDateTime.now();
        this.priority = priority;
        this.creator = creator;
        this.description = description;
        this.addDate = addDate;
        this.id = new Id();
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public int getId() {
        return id.getId();
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
