package ch5._myexercises;
import java.util.Random;
import java.util.Scanner;

public class Exercise5_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalPoundsFed = 0;
        String dinoSize = getDinoSize(random);
        int recommendedAmount = getPoundsToFeed(dinoSize);

        do {
            System.out.println("Is the dinosaur still hungry? (Enter 'full' if not)");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("full")) {
                System.out.println("Total pounds of meat fed: " + totalPoundsFed);
                break;
            }

            int poundsToFeed = getPoundsToFeed(dinoSize);
            totalPoundsFed += poundsToFeed;
            System.out.println("Feed the " + dinoSize + " dinosaur " + poundsToFeed + " pounds of meat.");
            System.out.println("Total pounds of meat fed so far: " + totalPoundsFed);

            if (totalPoundsFed > recommendedAmount) {
                System.out.println("You have exceeded the recommended amount; the dinosaur is getting sick. Please enter 'full'");
            }

        } while (true);

        scanner.close();
    }

    private static String getDinoSize(Random random) {
        int size = random.nextInt(5);
        switch (size) {
            case 0:
                return "x-small";
            case 1:
                return "small";
            case 2:
                return "medium";
            case 3:
                return "large";
            case 4:
                return "x-large";
            default:
                return "unknown";
        }
    }

    private static int getPoundsToFeed(String dinoSize) {
        switch (dinoSize) {
            case "x-small":
                return 5;
            case "small":
                return 10;
            case "medium":
                return 20;
            case "large":
                return 50;
            case "x-large":
                return 75;
            default:
                return 0;
        }
    }
}
