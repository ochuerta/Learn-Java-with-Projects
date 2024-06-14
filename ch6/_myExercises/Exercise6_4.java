package ch6._myExercises;

import java.util.*;

public class Exercise6_4 {
    private static final String[] EMPLOYEE_NAMES = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel", "Jessica", "Matthew", "Ashley", "Andrew", "Amanda", "Joseph", "Samantha", "Christopher", "Brittany", "Joshua", "Stephanie", "Robert", "Lauren"};
    private static final String[] DINOSAUR_SPECIES = {"Tyrannosaurus", "Velociraptor", "Triceratops", "Brachiosaurus", "Stegosaurus"};
    private static final String[] CUTE_NAMES = {"Fluffy", "Cuddles", "Snuggles", "Sweetie", "Buttercup", "Daisy", "Sunshine", "Sprinkles"};

    public static void main(String[] args) {
        String[][] employeeAndDinosaurs = generateEmployeeAndDinosaurs();
        for (String[] pair : employeeAndDinosaurs) {
            System.out.println(pair[0] + " is assigned to care for " + pair[1]);
        }
    }

    private static String[][] generateEmployeeAndDinosaurs() {
        Random random = new Random();
        List<String[]> employeeAndDinosaurs = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            String employee = EMPLOYEE_NAMES[random.nextInt(EMPLOYEE_NAMES.length)];
            String species = DINOSAUR_SPECIES[random.nextInt(DINOSAUR_SPECIES.length)];
            String cuteName = CUTE_NAMES[random.nextInt(CUTE_NAMES.length)];
            String dinosaur = species + "_" + cuteName;
            employeeAndDinosaurs.add(new String[]{employee, dinosaur});
        }

        return employeeAndDinosaurs.toArray(new String[0][]);
    }
}
