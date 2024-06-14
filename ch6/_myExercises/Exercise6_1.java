package ch6._myExercises;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Exercise6_1 {
    private static final String[] DINOSAUR_SPECIES = {"Tyrannosaurus", "Velociraptor", "Triceratops", "Brachiosaurus", "Stegosaurus"};
    private static final String[] CUTE_NAMES = {"Fluffy", "Cuddles", "Snuggles", "Sweetie", "Buttercup", "Daisy", "Sunshine", "Sprinkles"};

    public static void main(String[] args) {
        String[] dinosaurNames = generateUniqueDinosaurNames();
        printDinosaurNames(dinosaurNames);
    }

    private static String[] generateUniqueDinosaurNames() {
        Random random = new Random();
        Set<String> uniqueNames = new HashSet<>();

        while (uniqueNames.size() < 10) {
            String species = DINOSAUR_SPECIES[random.nextInt(DINOSAUR_SPECIES.length)];
            String cuteName = CUTE_NAMES[random.nextInt(CUTE_NAMES.length)];
            String name = species + "_" + cuteName;
            uniqueNames.add(name);
        }

        return uniqueNames.toArray(new String[0]);
    }

    private static void printDinosaurNames(String[] names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
