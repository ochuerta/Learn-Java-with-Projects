package ch5._myexercises;

public class DinoMealPlanner {
    public static void main(String[] args) {
        // Feeding times for different dinosaur species
        int[] tRexFeedingTimes = {8, 14, 20};
        int[] brachiosaurusFeedingTimes = {7, 11, 15, 19};

        // Meal portions for different dinosaur species
        int tRexMealPortion = 100; // kg
        int brachiosaurusMealPortion = 250; // kg

        // Loop through the 24 hours of the day
        for (int currentTime = 0; currentTime < 24; currentTime++) {
            boolean isTRexFeedingTime = false;
            boolean isBrachiosaurusFeedingTime = false;

            // Check if it's feeding time for T-Rex
            for (int feedingTime : tRexFeedingTimes) {
                if (currentTime == feedingTime) {
                    System.out.println("It's " + currentTime + ":00 - Feeding time for T-Rex with " + tRexMealPortion + "kg of food");
                    isTRexFeedingTime = true;
                    break;
                }
            }

            // Check if it's feeding time for Brachiosaurus
            for (int feedingTime : brachiosaurusFeedingTimes) {
                if (currentTime == feedingTime) {
                    System.out.println("It's " + currentTime + ":00 - Feeding time for Brachiosaurus with " + brachiosaurusMealPortion + "kg of food");
                    isBrachiosaurusFeedingTime = true;
                    break;
                }
            }

            // If it's not feeding time for either dinosaur
            if (!isTRexFeedingTime && !isBrachiosaurusFeedingTime) {
                System.out.println("It's " + currentTime + ":00 - It's not time to feed the T-Rex or the Brachiosaurus");
            }
        }
    }
}

