package ch6._myExercises;

import java.util.*;

public class Exercise6_3 {
    private static final String[] DINOSAUR_SPECIES = {"Tyrannosaurus", "Velociraptor", "Triceratops", "Brachiosaurus", "Stegosaurus"};
    private static final String[] CUTE_NAMES = {"Fluffy", "Cuddles", "Snuggles", "Sweetie", "Buttercup", "Daisy", "Sunshine", "Sprinkles"};

    public static void main(String[] args) {
        String[][] dinosaurNamesAndWeights = generateUniqueDinosaurNamesAndWeights();
        printDinosaurNamesAndWeights(dinosaurNamesAndWeights);
    }

    private static String[][] generateUniqueDinosaurNamesAndWeights() {
        Random random = new Random();
        Set<String> uniqueNames = new HashSet<>();
        List<String[]> namesAndWeights = new ArrayList<>();

        while (uniqueNames.size() < 10) {
            String species = DINOSAUR_SPECIES[random.nextInt(DINOSAUR_SPECIES.length)];
            String cuteName = CUTE_NAMES[random.nextInt(CUTE_NAMES.length)];
            String name = species + "_" + cuteName;
            float weight;
            if (species.equals("Brachiosaurus")) {
                weight = random.nextFloat() * 60000 + 30000; // 30,000 to 90,000 lbs
            } else if (species.equals("Velociraptor")) {
                weight = random.nextFloat() * 30 + 15; // 15 to 45 lbs
            } else {
                weight = random.nextFloat() * 10000; // Assuming weight in lbs for other species
            }

            uniqueNames.add(name);
            namesAndWeights.add(new String[]{name, String.valueOf(weight)});
        }

        return namesAndWeights.toArray(new String[0][]);
    }

    private static void printDinosaurNamesAndWeights(String[][] namesAndWeights) {
        for (String[] nameAndWeight : namesAndWeights) {
            System.out.printf("%s - %.1f lbs%n", nameAndWeight[0], Double.parseDouble(nameAndWeight[1]));
        }
    }
}
