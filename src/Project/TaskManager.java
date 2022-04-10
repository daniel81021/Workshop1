package Project;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {

    static final String FILE_NAME = "tasks.csv";
    static String[][] tasks;
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) {

        tasks = loadDataToTab(FILE_NAME);
        Scanner scan = new Scanner(System.in);
        printOptions(OPTIONS);

        while (scan.hasNextLine()) {
            String input = scan.next();
            switch (input) {
                case "add":
                    addTask();
                    System.out.println(ConsoleColors.GREEN + "Task successfully added.");
                    break;
                case "remove":
                    removeTask(tasks, getTheNumber());
                    break;
                case "list":
                    printList(tasks);
                    break;
                case "exit":
                    saveTabToFile(FILE_NAME, tasks);
                    System.out.println(ConsoleColors.RED + "Bye, bye.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Podałeś coś źle");
            }
            System.out.println();
            printOptions(OPTIONS);
        }
    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: ");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(ConsoleColors.RESET + tab[i]);
        }
        System.out.println(ConsoleColors.BLUE + "Add option here: " + ConsoleColors.RESET);
    }

    public static void printList(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] loadDataToTab(String fileName) {
        Path dir = Paths.get(fileName);
        if (!Files.exists(dir)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        String[][] tab = null;
        try {
            List<String> strings = Files.readAllLines(dir);
            tab = new String[strings.size()][strings.get(0).split(",").length];
            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return tab;
    }

    private static void addTask() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please add task description: ");
        String taskDescription = scan.nextLine();
        System.out.println("Please add task due date: ");
        String taskDueDate = scan.nextLine();
        System.out.println("Please write if your task is important (true/false): ");
        String isImportant = scan.nextLine();

        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = new String[3];
        tasks[tasks.length - 1][0] = taskDescription;
        tasks[tasks.length - 1][1] = taskDueDate;
        tasks[tasks.length - 1][2] = isImportant;
    }

    public static boolean isNumberGreaterEqualZero(String input) {

        if (NumberUtils.isParsable(input)) {
            return Integer.parseInt(input) >= 0;
        }
        return false;
    }

    public static int getTheNumber() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select number to remove.");

        String n = scanner.nextLine();
        while (!isNumberGreaterEqualZero(n)) {
            System.out.println("Incorrect argument passed. Please give number greater or equal 0");
            n = scanner.nextLine();
        }
        return Integer.parseInt(n);

    }

    private static void removeTask(String[][] tab, int index) {

        try {
            if (index < tab.length) {
                tasks = ArrayUtils.remove(tab, index);
                System.out.println(ConsoleColors.GREEN + "Value was successfully deleted." + ConsoleColors.RESET);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Element not exist in tab");
        }
    }

    public static void saveTabToFile(String fileName, String[][] tab) {

        Path dir = Paths.get(fileName);
        String[] lines = new String[tasks.length];
        for (int i = 0; i < tab.length; i++) {
            lines[i] = String.join(",", tab[i]);
        }
        try {
            Files.write(dir, Arrays.asList(lines));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
