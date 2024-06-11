package ch4._myexercises;

import java.util.Random;

public class RatingProgram {
    private static final int MAX_VISITORS = 1000;
    private static final int MAX_DINOSAURS = 20;
    private static final int MAX_STAFF = 50;
    private static final double SICK_STAFF_PROBABILITY = 0.2;

    public static void main(String[] args) {
        String dinosaur1 = "T-Rex";
        String dinosaur2 = "Stegosaurus";
        String dinosaur3 = "Little Velociraptor";
        String dinosaur4 = "Pterodactyl";

        String size1 = "Large";
        String size2 = "Medium";
        String size3 = "X-Small";
        String size4 = "Small";

        String housingUnit1 = assignHousingUnit(size1);
        String housingUnit2 = assignHousingUnit(size2);
        String housingUnit3 = assignHousingUnit(size3);
        String housingUnit4 = assignHousingUnit(size4);

        int feedingTimes1 = assignFeedingTimes(size1);
        int feedingTimes2 = assignFeedingTimes(size2);
        int feedingTimes3 = assignFeedingTimes(size3);
        int feedingTimes4 = assignFeedingTimes(size4);

        int numDinosaurs = 4;
        int numStaff = generateRandomStaff();
        int numVisitors = 0;
        int weekNumber = 1;
        double parkSafetyRating = 5.0;

        System.out.println("Week " + weekNumber + ":");
        System.out.println("Number of dinosaurs: " + numDinosaurs);
        System.out.println("Number of staff: " + numStaff);
        System.out.println("Number of visitors: " + numVisitors);
        System.out.println("Park safety rating: " + parkSafetyRating);
        printStaffRoles(numStaff);
        System.out.println();

        System.out.println(dinosaur1 + " (" + size1 + ") will be housed in " + housingUnit1 + " and fed " + feedingTimes1 + " times per day.");
        System.out.println(dinosaur2 + " (" + size2 + ") will be housed in " + housingUnit2 + " and fed " + feedingTimes2 + " times per day.");
        System.out.println(dinosaur3 + " (" + size3 + ") will be housed in " + housingUnit3 + " and fed " + feedingTimes3 + " times per day.");
        System.out.println(dinosaur4 + " (" + size4 + ") will be housed in " + housingUnit4 + " and fed " + feedingTimes4 + " times per day.");

        for (int i = 2; i <= 10; i++) {
            weekNumber = i;
            numVisitors = generateRandomVisitors(numVisitors);
            parkSafetyRating = calculateParkSafetyRating(numDinosaurs, numStaff, numVisitors);
            numStaff = adjustStaffing(numStaff, parkSafetyRating);

            System.out.println("\nWeek " + weekNumber + ":");
            System.out.println("Number of dinosaurs: " + numDinosaurs);
            System.out.println("Number of staff: " + numStaff);
            System.out.println("Number of visitors: " + numVisitors);
            System.out.println("Park safety rating: " + parkSafetyRating);
            printStaffRoles(numStaff);
        }
    }

    public static String assignHousingUnit(String size) {
        String housingUnit;
        switch (size) {
            case "Large":
                housingUnit = "Large Enclosure";
                break;
            case "Medium":
                housingUnit = "Medium Enclosure";
                break;
            case "Small":
                housingUnit = "Small Enclosure";
                break;
            case "X-Small":
                housingUnit = "Terrarium";
                break;
            default:
                housingUnit = "Unknown Housing Unit";
                break;
        }
        return housingUnit;
    }

    public static int assignFeedingTimes(String size) {
        int feedingTimes;
        switch (size) {
            case "Large":
                feedingTimes = 4;
                break;
            case "Medium":
                feedingTimes = 3;
                break;
            case "Small":
                feedingTimes = 2;
                break;
            case "X-Small":
                feedingTimes = 1;
                break;
            default:
                feedingTimes = 0;
                break;
        }
        return feedingTimes;
    }

    public static int generateRandomStaff() {
        Random random = new Random();
        return random.nextInt(MAX_STAFF) + 1;
    }

    public static int generateRandomVisitors(int currentVisitors) {
        Random random = new Random();
        int newVisitors = currentVisitors + random.nextInt(MAX_VISITORS / 10);
        return Math.min(newVisitors, MAX_VISITORS);
    }

    public static double calculateParkSafetyRating(int numDinosaurs, int numStaff, int numVisitors) {
        double dinosaurToStaffRatio = (double) numDinosaurs / numStaff;
        double visitorToStaffRatio = (double) numVisitors / numStaff;
        double safetyRating = 5.0;

        if (dinosaurToStaffRatio > 2.0 || visitorToStaffRatio > 50.0) {
            safetyRating -= 1.0;
        }

        if (dinosaurToStaffRatio > 4.0 || visitorToStaffRatio > 100.0) {
            safetyRating -= 1.0;
        }

        if (dinosaurToStaffRatio > 6.0 || visitorToStaffRatio > 200.0) {
            safetyRating -= 1.0;
        }

        if (dinosaurToStaffRatio > 8.0 || visitorToStaffRatio > 300.0) {
            safetyRating -= 1.0;
        }

        if (dinosaurToStaffRatio > 10.0 || visitorToStaffRatio > 400.0) {
            safetyRating -= 1.0;
        }

        return Math.max(safetyRating, 1.0);
    }

    public static int adjustStaffing(int currentStaff, double parkSafetyRating) {
        Random random = new Random();
        int sickStaff = 0;
        int adjustedStaff = currentStaff;

        for (int i = 0; i < currentStaff; i++) {
            if (random.nextDouble() < SICK_STAFF_PROBABILITY) {
                sickStaff++;
            }
        }

        adjustedStaff -= sickStaff;

        if (parkSafetyRating < 3.0) {
            adjustedStaff += 5;
        } else if (parkSafetyRating < 4.0) {
            adjustedStaff += 3;
        }

        return Math.min(adjustedStaff, MAX_STAFF);
    }

    public static void printStaffRoles(int numStaff) {
        int feeders = numStaff / 4;
        int cleaners = numStaff / 4;
        int securityGuards = numStaff / 4;
        int tourGuides = numStaff - feeders - cleaners - securityGuards;

        System.out.println("Staff roles:");
        System.out.println("Feeders: " + feeders);
        System.out.println("Cleaners: " + cleaners);
        System.out.println("Security Guards: " + securityGuards);
        System.out.println("Tour Guides: " + tourGuides);
    }
}

