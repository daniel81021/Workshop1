package Project;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class AddTask {
    public static void main(String[] args) {
        String[][] tasks = {{"zadanie", "04/04/2022", "false"}};
        Scanner scan = new Scanner(System.in);

        out.println("Please add task description: ");
        String taskDescription = scan.nextLine();
        out.println("Please add task due date: ");
        String taskDueDate = scan.nextLine();
        out.println("Please write if your task is important (true/false): ");
        String isImportant = scan.nextLine();

        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = taskDescription;
        tasks[tasks.length - 1][1] = taskDueDate;
        tasks[tasks.length - 1][2] = isImportant;



    }
}
