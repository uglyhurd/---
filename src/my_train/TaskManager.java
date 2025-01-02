package my_train;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskManager {
    public static class Task {
        private String name;
        private boolean isCompleted;


          public Task(String name, boolean Completed) {
              this.name = name;
              this.isCompleted = Completed;
          }

          public String getName(){
              return name;
          }
        public boolean getIsCompleted(){
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        public void setName(String name){
              this.name = name;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", isCompleted=" + isCompleted +
                    '}';
        }
    }

    public static class MyTaskManager {
        public List<Task> tasks = new ArrayList<>();

        public void addTask(Task name){
            tasks.add(name);
        }
        public void viewTasks(){
            if (tasks.isEmpty()){
                System.out.println("Список задач пуст\n");
            } else{
                for(int i=0; i < tasks.size(); i++ ){
                    Task task = tasks.get(i);
                    if (task.getIsCompleted() == true) {
                        System.out.println(i+1+"." + " [X] " + task.getName());
                    }else {
                        System.out.println(i+1+"." + " [] " + task.getName());
                    }

                }
            }
        }
        public void completedTask(int index) {
            Task task = tasks.get(index);
            task.setCompleted(true);
        }
        public void deleteTask(int index) {
            Task task = tasks.remove(index);
            System.out.println("Задача удалена\n");
        }
    }

    public static void main(String[] args) {
        MyTaskManager task = new MyTaskManager();
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Добавить задачу\n" +
                "2. Просмотреть задачи\n" +
                "3. Отметить задачу как выполненную\n" +
                "4. Удалить задачу\n" +
                "5. Выход");
        int number = scan.nextInt();
        while (number != 5) {

            if (number == 1) {
                System.out.println("Введите задачу");
                scan.nextLine();
                String name=  scan.nextLine();
                task.addTask(new Task(name, false));
                System.out.println("Задача добавлена\n");

            }
            if (number == 2) {
                task.viewTasks();
            }
            if(number == 3) {
                System.out.println("Введите номер задачи которую вы выполнили ");
                int completed_task = scan.nextInt();
                try{
                    task.completedTask(completed_task - 1);
                } catch (NoSuchElementException e){
                    System.out.println("Задача по номеру не найдена");
                }
            }
            if (number == 4) {
                System.out.println("Введите номер задачи который хотите удалить");
                int delete_task = scan.nextInt();
                try{
                    task.deleteTask(delete_task - 1);
                }catch (NoSuchElementException e) {
                    System.out.println("Задача по номеру не найдена");
                }
            }
            number = scan.nextInt();
//            System.out.println("1. Добавить задачу\n" +
//                    "2. Просмотреть задачи\n" +
//                    "3. Отметить задачу как выполненную\n" +
//                    "4. Удалить задачу\n" +
//                    "5. Выход");
        }
        scan.close();
        System.out.println("Удачи!");

    }
}