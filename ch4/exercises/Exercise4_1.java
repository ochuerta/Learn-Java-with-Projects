package ch4.exercises;

public class Exercise4_1 {
    public static void main(String[] args) {
        boolean isCarnivore; // change this variable to test the code

        isCarnivore = getRandomBoolean();
        System.out.println(isCarnivore + " is the result of getRandomBoolean().");
        if (isCarnivore) {
            System.out.println("The dinosaur is a carnivore.");
        } else {
            System.out.println("The dinosaur is a herbivore.");
        }

    }

    public static boolean getRandomBoolean() {
        // Get the current time in milliseconds since the Unix epoch
        long currentTime = System.currentTimeMillis();

        // Use the least significant bit of the current time as the random boolean
        boolean randomBoolean = (currentTime & 1) == 1;

        return randomBoolean;
    }
}
