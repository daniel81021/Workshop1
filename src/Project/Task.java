package Project;

public class Task {
    public static void main(String[] args) {
        String[] options = {"add", "remove", "list", "exit"};
        printOptions(options);

    }

    public static void printOptions(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option: ");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(ConsoleColors.RESET + tab[i]);
        }
    }
}
