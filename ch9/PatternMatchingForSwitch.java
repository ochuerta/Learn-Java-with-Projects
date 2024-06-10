package ch9;

public class PatternMatchingForSwitch {

    public static void patternMatchingSwitch(VehicleType v) {
        String result = switch (v) {
            case Boat b -> b.toString();
            case Train t -> t.toString();
            case Auto c -> {
                if (c.getNumDoors() == 4) {
                    yield "Saloon/Sedan: " + c.onRoad();
                } else if (c.getNumDoors() == 2) {
                    yield "Convertible: " + c.onRoad();
                } else {
                    yield "Unknown Auto type";
                }
            }
            case null -> "Invalid type";
            default -> "Invalid type"; // exhaustiveness
        };
        System.out.println(result);
    }

    // Example usage:
    public static void main(String[] args) {
        VehicleType vehicle1 = new Boat();
        VehicleType vehicle2 = new Train();
        VehicleType vehicle3 = new Auto(4); // assuming Auto has a constructor that sets numDoors
        VehicleType vehicle4 = new Auto(2);

        patternMatchingSwitch(vehicle1); // Output: Boat toString() result
        patternMatchingSwitch(vehicle2); // Output: Train toString() result
        patternMatchingSwitch(vehicle3); // Output: Saloon/Sedan: onRoad() result
        patternMatchingSwitch(vehicle4); // Output: Convertible: onRoad() result
        patternMatchingSwitch(null);     // Output: Invalid type
    }
}

interface VehicleType {
    // common methods for all vehicle types
}

class Boat implements VehicleType {
    @Override
    public String toString() {
        return "Boat";
    }
}

class Train implements VehicleType {
    @Override
    public String toString() {
        return "Train";
    }
}

class Auto implements VehicleType {
    private final int numDoors;

    public Auto(int numDoors) {
        this.numDoors = numDoors;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public String onRoad() {
        return "on the road";
    }

    @Override
    public String toString() {
        return "Auto with " + numDoors + " doors";
    }
}





/*
package java21.pattern_matching_for_switch;

sealed class Vehicle permits Car, Boat, Train{}
final class Car extends Vehicle {
    private int numDoors;
    Car(int numDoors){
        this.numDoors = numDoors;
    }
    public int getNumDoors() {return numDoors;}
    public String onRoad(){
        return "I can move on the road";
    }
}
final class Boat extends Vehicle{}
final class Train extends Vehicle{}

public class PatternMatchingForSwitch {
    public static void patternMatchingSwitch(Vehicle v) {
        System.out.println(
            switch(v){ // 'v' is the "selector expression"
                // 'Boat b' is a (type) pattern label
                case Boat b -> "It's a Boat";
                case Train t -> "It's a Train";
                // 'Car c' is a type pattern and also a "guarded case label"
                // 'c.getNumDoors() == 4' is a "guard":
                //    A guard is a boolean expression on the RHS of a 'when' clause.
                // Overall it is called a "guarded pattern".
                case Car c when c.getNumDoors() == 4  ->
                        "Saloon/Sedan: "+ c.onRoad();
                case Car c when c.getNumDoors() == 2  -> {
                    yield "Convertible: " + c.onRoad();
                }
                case null, default      -> "Invalid type"; // exhaustivess covered
            }
        );
    }
    public static void main(String[] args) {
        patternMatchingSwitch(new Car(2));
        patternMatchingSwitch(new Car(4));
        patternMatchingSwitch(new Boat());
        patternMatchingSwitch(null);
    }
}

 */