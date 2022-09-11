public class TestCase {
    void pressButton() {

        Separator s = new Separator();
        Tasklist tasklist = new Tasklist();
        FileManager fmanager = new FileManager();

        Task task1 = new Task(Priority.low,
                "Nikolay",
                "Throw a Dog out",
                2);
        Task task2 = new Task(Priority.critical,
                "Zigmund",
                "Go to the Mall and buy some food",
                1);
        Task task3 = new Task(Priority.high, "John",
                "Repair that bloody Carburetor",
                5);
        tasklist.addToTaskList(task1, task2, task3);
        s.pr();
        System.out.println("Added Tasks, Simple print it: ");
        s.pr();
        tasklist.printTasks();


        fmanager.saveToFile(tasklist, "out2", Extension.txt);
        s.pr();
        System.out.println("Tasks saved in out2, then sorted by Deadline: ");
        s.pr();
        tasklist.sortByDeadline();
        tasklist.printTasks();

        s.pr();
        System.out.println("Tasks saved in out1, then read from file and reCalcIds for each: ");
        s.pr();
        fmanager.saveToFile(tasklist, "out1", Extension.txt);
        tasklist.readTasklistFromFile("in1", Extension.txt);
        tasklist.reCalcIds();

        tasklist.printTasks();

        tasklist.removeTask(6);
        tasklist.removeTask(2);

        tasklist.printTasks();

        s.pr();
        System.out.println("Tasks saved in out3.csv, then read from file in3.csv: ");
        s.pr();

        fmanager.saveToFile(tasklist, "out3", Extension.csv);

        tasklist.readTasklistFromFile("in3", Extension.csv);
        tasklist.printTasks();
    }
}
