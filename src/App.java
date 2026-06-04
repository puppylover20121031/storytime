
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.ArrayList;

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

        writestory(1, lines);

        scanner.close();

    }

    public static void writestory(int storynum, String[] list) {
        String desktopPath = System.getProperty("user.home") + "\\OneDrive\\Desktop\\story" + storynum + ".txt";
        try {
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < list.length; i++) {
                if (list[i] != null && !list[i].isBlank()) {
                    content.append(list[i]).append("\n");
                }
            }
            // Create parent directory if it doesn't exist
            Files.createDirectories(Paths.get(desktopPath).getParent());
            Files.write(Paths.get(desktopPath), content.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Story written successfully to: " + desktopPath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
            e.printStackTrace();
        }
    }

}