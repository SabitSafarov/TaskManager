import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        try (TaskManager taskManager = new TaskManager("tasks.bin");
             Scanner scr = new Scanner(System.in)) {

            boolean run = true;
            while (run) {
                System.out.println("Введите команду: \n1 - создать задачу\n2 - просмотреть список задач\n3 - удалить задачу\n4 - выход");
                int command = scr.nextInt();
                scr.nextLine();
                if (command == 1) {
                    System.out.print("Введите название задачи: ");
                    String name = scr.nextLine();
                    System.out.println();
                    System.out.print("Введите описание задачи: ");
                    String description = scr.nextLine();
                    System.out.println();
                    System.out.println("Статус: 1 = задача выплнена, 2 - задача не выполнена");
                    boolean status = false;
                    int stat = scr.nextInt();
                    if (stat == 1) {
                        status = true;
                    } else if (stat == 2) {
                        status = false;
                    } else {
                        System.out.println("Ошибка! Введите снова: 1 - задача выплнена, 2 - задача не выполнена");
                    }
                    taskManager.addTask(new Task(name, description, status));
                } else if (command == 2) {
                    taskManager.viewTasks();
                } else if (command == 3) {
                    System.out.print("Введите id задачи которое хотите удалить: ");
                    int id = scr.nextInt();
                    System.out.println();
                    taskManager.deleteTask(id);
                } else if (command == 4) {
                    run = false;
                } else {
                    System.out.println("Неверная команда!");
                }
            }

        } catch (ClassCastException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
