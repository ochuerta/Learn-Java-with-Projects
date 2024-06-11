package ch4._myexercises;

public class Exercise4_4 {
    public static void main(String[] args) {
        int safetyLevel = 3; // change this variable to test the code

        if (safetyLevel < 5) {
            System.out.println("The safety level is too low.");
            throw new IllegalStateException("Safety level is below the acceptable threshold.");
        } else {
            System.out.println("The safety level is acceptable.");
        }
    }
}
