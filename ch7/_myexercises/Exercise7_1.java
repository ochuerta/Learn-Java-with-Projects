package ch7._myexercises;

public class Exercise7_1 {
    public static void main(String[] args) {

        for (int i = 0; i < 22; i++) {
            System.out.println(dinoStage(i));
        }

        for (int i = 0; i < 220; i+=10) {
            System.out.println("Dinosaurs that weigh " + i + "lbs require " + dinoFoodIntake(i) + " lbs of food");
        }

        String[][] dinoList = createDinoArray();
        System.out.println("The average age of the dinosaurs is: " + avgAge(dinoList));
    }
    private static String dinoStage ( int age){
        if (age >= 0 && age <= 1) {
            return "hatchling";
        } else if (age > 1 && age <= 4) {
            return "juvenile";
        } else if (age > 4 && age <= 20) {
            return "adult";
        } else {
            return "senior";
        }
    }

    private static int dinoFoodIntake(float weight) {
        int lbs_of_food = 0;
        lbs_of_food = (int) Math.max(5, Math.log(weight) * 10);
        return lbs_of_food;
    }
    private static String[][] createDinoArray() {
        String[][] dinoNames = {
            {"Tyrannosaurus Rex", "8"},
            {"Brachiosaurus", "30"},
            {"Velociraptor", "2"},
            {"Triceratops", "18"},
            {"Stegosaurus", "12"},
            {"Spinosaurus", "15"},
            {"Allosaurus", "10"},
            {"Diplodocus", "25"},
            {"Ankylosaurus", "20"},
            {"Parasaurolophus", "15"},
            {"Gallimimus", "5"},
            {"Corythosaurus", "12"},
            {"Pachycephalosaurus", "8"},
            {"Oviraptor", "3"},
            {"Iguanodon", "10"},
            {"Deinonychus", "4"},
            {"Quetzalcoatlus", "8"},
            {"Pteranodon", "6"},
            {"Compsognathus", "1"},
            {"Archaeopteryx", "1"},
            {"Plateosaurus", "15"},
            {"Coelophysis", "3"},
            {"Dilophosaurus", "6"},
            {"Herrerasaurus", "5"},
            {"Eoraptor", "2"},
            {"Caudipteryx", "3"},
            {"Tsintaosaurus", "12"},
            {"Shunosaurus", "18"},
            {"Mamenchisaurus", "35"},
            {"Gigantoraptor", "10"}
        };
        return dinoNames;
    }

    private static double avgAge(String[][] dinoArray) {
        double totalAge = 0;
        for (String[] dino : dinoArray) {
            totalAge += Integer.parseInt(dino[1]);
        }
        return totalAge / dinoArray.length;
    }

    private static float avgAge(int[] ages) {
        int sum = 0;
        for (int age : ages) {
            sum += age;
        }
        return (float) sum / ages.length;
    }
}
