package ch4._myexercises;
public class Exercise4_5 {
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

        System.out.println(dinosaur1 + " (" + size1 + ") will be housed in " + housingUnit1 + " and fed " + feedingTimes1 + " times per day.");
        System.out.println(dinosaur2 + " (" + size2 + ") will be housed in " + housingUnit2 + " and fed " + feedingTimes2 + " times per day.");
        System.out.println(dinosaur3 + " (" + size3 + ") will be housed in " + housingUnit3 + " and fed " + feedingTimes3 + " times per day.");
        System.out.println(dinosaur4 + " (" + size4 + ") will be housed in " + housingUnit4 + " and fed " + feedingTimes4 + " times per day.");
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
}
