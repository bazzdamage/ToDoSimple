import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Formatter {

    public ArrayList<Task> fileToTasks(ArrayList<String> input, Extension ext) {
        ArrayList<Task> out = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String comma = ",";
        boolean firstLine = true;
        if (ext == Extension.csv) {
            for (String line : input) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                temp = Arrays.asList(line.split(comma));
                Task task = new Task((Priority.valueOf(temp.get(1))), temp.get(2), temp.get(3), temp.get(4), temp.get(5));
                out.add(task);
            }
        }
        if (ext == Extension.txt) {
            for (String line : input) {
                if (Objects.equals(line, "")) {
                    Task task = new Task((Priority.valueOf(temp.get(1))), temp.get(2), temp.get(3), temp.get(4), temp.get(5));
                    out.add(task);
                    temp.clear();
                    continue;
                }
                temp.add(line);
            }
        }
        return out;
    }

    public ArrayList<String> tasksToString(Tasklist input, Extension ext) {
        ArrayList<String> out = new ArrayList<>();
        ArrayList<Task> arrinput = input.getTaskList();
        String comma = ",";

        if (ext == Extension.csv) {
            StringBuilder csvLine = new StringBuilder();
            csvLine.append("Id,Priority,Creator,Description,Add Date,Deadline");
            out.add(csvLine.toString());
            for (Task task : arrinput) {
                csvLine.setLength(0);
                csvLine.append(task.getId()).append(comma);
                csvLine.append(task.getPriority().toString()).append(comma);
                csvLine.append(task.getCreator()).append(comma);
                csvLine.append(task.getDescription()).append(comma);
                csvLine.append(task.getAddDate()).append(comma);
                csvLine.append(task.getDeadline());
                out.add(csvLine.toString());
            }
        }
        if (ext == Extension.txt) {
            for (Task task : arrinput) {
                out.add(String.valueOf(task.getId()));
                out.add(task.getPriority().toString());
                out.add(task.getCreator());
                out.add(task.getDescription());
                out.add(task.getAddDate());
                out.add(task.getDeadline());
                out.add("");
            }
        }
        return out;
    }
}
