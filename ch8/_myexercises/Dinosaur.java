package ch8._myexercises;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Dinosaur {
    String name;
    int age;
    Species species;
    enum Species {
        T_Rex,
        Velociraptor,
        // add other species cases as needed
    }
    public Dinosaur(String name, int age, Species species) {
        this.name = name;
        this.age = age;
        this.species = species;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public Species getSpecies() {
        return this.species;
    }

    public static void main(String[] args) {

        String[] cuteNames = {"Fluffy", "Cuddles", "Snuggles", "Sweetie", "Cutie"};
        /**
         * Creates a list of 5 randomly generated Dinosaur objects.
         * Each Dinosaur has a random name from the cuteNames array,
         * a random age between 0 and 24, and a random species from
         * the Species enum.
         */
        List<Dinosaur> dinosaurs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Dinosaur dinosaur = new Dinosaur(cuteNames[i], new Random().nextInt(25),
                    Species.values()[new Random().nextInt(Species.values().length)]);
            dinosaurs.add(dinosaur);
        }

        System.out.printf("%-15s%-5s%-10s%n", "Name", "Age", "Species");
        System.out.println("-------------------------------");
        for (Dinosaur dino : dinosaurs) {
            System.out.printf("%-15s%-5d%-10s%n", dino.getName(), dino.getAge(), dino.getSpecies());
        }

    }
}
