import java.io.Serializable;

public class Task implements Serializable {

    private int id;
    private String name;
    private String description;
    private boolean status;

    public Task(String name, String description, boolean status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID Задачи: " + id + "\n" +
                "Название: " + name +"\n" +
                "Описание: " + description+ "\n" +
                "Статус данной задачи: " + (status ? "Задача выполнена" : "Задача не выполнена") + "\n";
    }
}