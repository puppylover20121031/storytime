
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String[] lines = new String[100];

        System.out.println("Hello there!");
        System.out.println("Do you want to create a story?");
        System.out.println("yes or no?");
        String answer = scanner.nextLine();
        if (answer.equals("yes") || answer.equals("y")) {
            System.out.println("ok, ");
            System.out.println("what is the name of the story?");
            name = scanner.nextLine();
            System.out.println("ok then, \"" + name + "\" it is");

        }
        System.out.println("what is the first line for the story, \"" + name + "\"");
        String line1 = scanner.nextLine();
        if (line1.isBlank()) {
            System.out.println("The first line cannot be blank");
            System.exit(1);
        }
        lines[0] = line1;

        int storyc = 1;

        boolean doneline = false;
        while (!doneline) {
            if (storyc <= 99) {
                System.out.println("what is the next line for the story, \"" + name + "\"");
                String line = scanner.nextLine();
                if (line.isBlank()) {
                    System.out.println("end of story");
                    doneline = true;
                }
                lines[storyc] = line;
                storyc++;
            } else {
                doneline = true;
            }
        }

        scanner.close();

    }

}