package ch5._myexercises;
import java.util.Scanner;

public class WhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSum = 0;
        boolean shouldExit = false;

        while (!shouldExit) {
            System.out.print("Enter a number or '=', 'done', or 'exit' to finish: ");
            String userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "=", "done", "exit":
                    System.out.println("The total sum is: " + totalSum);
                    shouldExit = true;
                    break;
                default:
                    try {
                        int num = Integer.parseInt(userInput);
                        totalSum += num;
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number or '=', 'done', or 'exit'.");
                    }
                    break;
            }
        }
        scanner.close();
    }
}

