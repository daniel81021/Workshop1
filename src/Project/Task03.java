package Project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Task03 {

    public static void main(String[] args) {
        String[][] tasks;
        String fileName = "tasks.csv";
        tasks = loadDataToTab(fileName);
        String[] options = {"add", "remove", "list", "exit"};
        Scanner scan = new Scanner(System.in);
        File file = new File("tasks.csv");
        printOptions(options);


        while (scan.hasNextLine()) {
            String input = scan.next();
            switch (input) {
                case "add":
                    System.out.println("wybór ADD działa");
                    break;
                case "remove":
                    System.out.println("wybór REMOVE działa");
                    break;
                case "list":
                    printList(tasks);
                    break;
                case "exit":
                    System.out.println("wybór EXIT działa");
                    break;
                default:
                    System.out.println("Podałeś coś źle");
            }
            System.out.println();
            printOptions(options);
        }
    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: ");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(ConsoleColors.RESET + tab[i]);
        }
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
}



