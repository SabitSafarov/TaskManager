import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Serializable, AutoCloseable {

    private final List<Task> tasks;
    private final String fileName;
    private int counter;

    public TaskManager(String fileName) throws IOException, ClassNotFoundException{
        this.fileName = fileName;
        this.tasks = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            Object task = null;
            while ((task = inputStream.readObject()) != null) {
                ++counter;
                tasks.add((Task) task);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Not found file. Created new");
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        }
    }

    void addTask(Task task)  {
        task.setId(++counter);
        tasks.add(task);
        System.out.println("Задача успешно создана!");
    }

    void viewTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    void deleteTask(int id) {
        tasks.remove(id - 1);
        counter = 1;
        for (Task task : tasks) {
            task.setId(counter);
            counter++;
        }
        counter--;
        System.out.println("Задача успешно удалена!");
    }

    @Override
    public void close() throws Exception {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for(Task task : tasks) {
                out.writeObject(task);
            }
        }
    }
}
