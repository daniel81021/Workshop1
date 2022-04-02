package Project;

import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        String[] options = {"add", "remove", "list", "exit"};
        Scanner scan = new Scanner(System.in);
        printOptions(options);
        String input = scan.next();

        switch(input) {
            case "add":
                System.out.println("wybór ADD działa");
                break;
            case "remove":
                System.out.println("wybór REMOVE działa");
                break;
            case "list":
                System.out.println("wybór LIST działa");
                break;
            case "exit":
                System.out.println("wybór EXIT działa");
                break;
            default:
                System.out.println("Podałeś coś źle");

        }

    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: ");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(ConsoleColors.RESET + tab[i]);
        }
    }
}
