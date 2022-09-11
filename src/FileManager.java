import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileManager {
    Separator s = new Separator();
    public void saveToFile(Tasklist tasklist, String filename, Extension ext) {
        Formatter fw = new Formatter();
        try {
            Path path = Path.of("src/fileOut/" + filename + "." + ext);
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.write(path, fw.tasksToString(tasklist, ext));
            System.out.println(filename + "." + ext + " successfully saved");
            s.pr();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Task> readFromFile(String filename, Extension ext) {
        ArrayList<String> arrOut = new ArrayList<>();
        Formatter fw = new Formatter();
        try {
            Path path = Path.of("src/fileIn/" + filename + "." + ext);
            if (Files.exists(path)) {
                arrOut.addAll(Files.readAllLines(path));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(filename + "." + ext + " successfully read");
        s.pr();
        return fw.fileToTasks(arrOut, ext);
    }
}
