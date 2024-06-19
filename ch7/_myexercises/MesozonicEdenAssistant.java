package ch7._myexercises;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MesozonicEdenAssistant {
    private static boolean exit = false;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (!exit) {
            System.out.println("\nMesozonic Eden Assistant Menu:");
            System.out.println("1. Manage Dinosaurs");
            System.out.println("2. Manage Guests");
            System.out.println("3. Manage Park Hours");
            System.out.println("4. Manage Visitors");
            System.out.println("5. Greet All Current Guests");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    Dinosaur.manageDinosaurs();
                    break;
                case 2:
                    manageGuests();
                    break;
                case 3:
                    manageParkHours();
                    break;
                case 4:
                    manageVisitors();
                    break;
                case 5:
                    greetAllCurrentGuests();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private static void manageGuests() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select an option:");
        System.out.println("1. Add Guest");
        System.out.println("2. Remove Guest");
        System.out.println("3. Delete Guest");
        System.out.println("4. Print Guest Information");
        int choice = scanner.nextInt();
        Guest guest = new Guest();
        switch (choice) {
            case 1:
                Scanner scannerGuest = new Scanner(System.in);
                System.out.print("Enter first name: ");
                String firstName = scannerGuest.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scannerGuest.nextLine();
                System.out.print("Is this a new guest? (Enter 'new' or 'returning'): ");
                String isNewGuest = scannerGuest.nextLine();
                boolean isNew = isNewGuest.equalsIgnoreCase("new");
                guest.addVisitor(firstName, lastName, isNew);
                break;
            case 2:
                guest.printGuestInfo();
                System.out.println("Select a visitor to delete:");
                int visitorIndex = scanner.nextInt();
                guest.deactivateVisitor(visitorIndex);
                break;
            case 3:
                Scanner guestScanner = new Scanner(System.in);
                System.out.print("Enter visitor's first name: ");
                String firstNameGuest = guestScanner.nextLine();
                System.out.print("Enter visitor's last name: ");
                String lastNameGuest = guestScanner.nextLine();
                guest.logVisit(firstNameGuest, lastNameGuest);
                break;
            case 4:
                guest.printGuestInfo();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void manageParkHours() {
        // Implement park hours management functionality here
    }

    private static void manageVisitors() {
        // Implement visitor management functionality here
    }

    private static void greetAllCurrentGuests() {
        // Implement guest greeting functionality here
    }
}

class Dinosaur {
    int age;
    float weightLbs;
    String species;
    String randomName;

    static Dinosaur[] dinosaurs = new Dinosaur[100];
    static int numDinosaurs = 0;

    public static void addDinosaur(int age, float weightLbs, String species, String cuteName) {
        Dinosaur dino = new Dinosaur();
        dino.age = age;
        dino.weightLbs = weightLbs;
        dino.species = species;
        dino.randomName = cuteName;
        dinosaurs[numDinosaurs] = dino;
        numDinosaurs++;
    }

    public static Dinosaur lookupDinosaur(String cuteName) {
        for (int i = 0; i < numDinosaurs; i++) {
            if (dinosaurs[i].randomName.equals(cuteName)) {
                return dinosaurs[i];
            }
        }
        return null;
    }

    public static void removeDinosaur(String cuteName) {
        for (int i = 0; i < numDinosaurs; i++) {
            if (dinosaurs[i].randomName.equals(cuteName)) {
                for (int j = i; j < numDinosaurs - 1; j++) {
                    dinosaurs[j] = dinosaurs[j + 1];
                }
                numDinosaurs--;
                break;
            }
        }
    }

    public static void changeWeightLbs(String randomName, float newWeight) {
        Dinosaur dino = lookupDinosaur(randomName);
        if (dino != null) {
            dino.weightLbs = newWeight;
        }
    }

    public static void changeCuteName(String oldName, String newName) {
        Dinosaur dino = lookupDinosaur(oldName);
        if (dino != null) {
            dino.randomName = newName;
        }
    }

    public static void changeAge(String randomName, int newAge) {
        Dinosaur dino = lookupDinosaur(randomName);
        if (dino != null) {
            dino.age = newAge;
        }
    }

    public static void printDinosaurInfo() {
        System.out.println("Age\tWeight (lbs)\tSpecies\t\tRandom Name");
        System.out.println("---\t------------\t-------\t\t-----------");
        for (int i = 0; i < numDinosaurs; i++) {
            Dinosaur dino = dinosaurs[i];
            System.out.printf("%d\t%.2f\t\t%s\t\t%s\n", dino.age, dino.weightLbs, dino.species, dino.randomName);
        }
    }

    public static void manageDinosaurs() {
        System.out.println("Manage Dinosaurs Menu:");
        System.out.println("1. Add Dinosaur");
        System.out.println("2. Remove Dinosaur");
        System.out.println("3. Change Weight");
        System.out.println("4. Change Name");
        System.out.println("5. Change Age");
        System.out.println("6. Print Dinosaur Information");
        System.out.println("7. Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter age: ");
                int age = scanner.nextInt();
                System.out.print("Enter weight (lbs): ");
                float weightLbs = scanner.nextFloat();
                String[] dinosaurs = {"Tyrannosaurus", "Velociraptor", "Triceratops", "Brachiosaurus", "Stegosaurus"};
                System.out.print("Select a dinosaur species (1. Tyrannosaurus, 2. Velociraptor, 3. Triceratops, 4. Brachiosaurus, 5. Stegosaurus): ");
                int choiceSpecies = scanner.nextInt() - 1;
                String species = dinosaurs[choiceSpecies];

                System.out.println("Pick a pet name from the list:");

                String[] petNames = {"Rex", "Raptor", "Triceratops", "Brachie", "Steggie", "Dino", "Spike", "Tiny", "Chomper", "Roary", "Stomp", "Crunch", "Nibbles", "Scales", "Claws", "Jaws", "Rumble", "Growler", "Snarl", "Gnasher"};
                for (int i = 0; i < petNames.length; i++) {
                    System.out.println((i + 1) + ". " + petNames[i]);
                }
                int choicePetName = scanner.nextInt() - 1;
                String randomName = petNames[choicePetName];
                addDinosaur(age, weightLbs, species, randomName);
                break;
            case 2:
                System.out.print("Enter name to remove: ");
                String nameToRemove = scanner.next();
                removeDinosaur(nameToRemove);
                break;
            case 3:
                System.out.print("Enter name to change weight: ");
                String nameToChangeWeight = scanner.next();
                System.out.print("Enter new weight (lbs): ");
                float newWeight = scanner.nextFloat();
                changeWeightLbs(nameToChangeWeight, newWeight);
                break;
            case 4:
                System.out.print("Enter name to change: ");
                String oldName = scanner.next();
                System.out.print("Enter new random name: ");
                String newName = scanner.next();
                changeCuteName(oldName, newName);
                break;
            case 5:
                System.out.print("Enter name of dinosaur to change age: ");
                String nameToChangeAge = scanner.next();
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                changeAge(nameToChangeAge, newAge);
                break;
            case 6:
                printDinosaurInfo();
                break;
            case 7:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                manageDinosaurs();
        }
    }
}

class Guest {
    String firstName;
    String lastName;
    boolean member;
    int visits;
    LocalDateTime latestVisit;

    static Guest[] guests = new Guest[100];
    static int numGuests = 0;
    private boolean active;

    public static void addVisitor(String firstName, String lastName, boolean member) {
        Guest guest = new Guest();
        guest.firstName = firstName;
        guest.lastName = lastName;
        guest.member = member;
        guest.visits = 1;
        guest.latestVisit = LocalDateTime.now();
        guest.active = true;
        guests[numGuests] = guest;
        numGuests++;
    }

    public static void logVisit(String firstName, String lastName) {
        for (int i = 0; i < numGuests; i++) {
            if (guests[i].firstName.equals(firstName) && guests[i].lastName.equals(lastName)) {
                guests[i].visits++;
                guests[i].latestVisit = LocalDateTime.now();
                break;
            }
        }
    }

    public static void printGuestInfo() {
        System.out.println("Guests:");
        for (int i = 0; i < numGuests; i++) {
            System.out.println(guests[i].firstName + " " + guests[i].lastName + " " + guests[i].visits + " " + guests[i].latestVisit + " " + guests[i].active);
        }
    }

    public static void deactivateVisitor(int visitorIndex) {
        if (visitorIndex >= 0 && visitorIndex < numGuests) {
            guests[visitorIndex].active = false;
        }
    }

}

class Employee {
    String firstName;
    String lastName;
    String shift;
    int primaryDinosaur;

    static Employee[] employees = new Employee[100];
    static int numEmployees = 0;

    public static void addEmployee(String firstName, String lastName, String shift, int primaryDinosaur) {
        Employee employee = new Employee();
        employee.firstName = firstName;
        employee.lastName = lastName;
        employee.shift = shift;
        employee.primaryDinosaur = primaryDinosaur;
        employees[numEmployees] = employee;
        numEmployees++;
    }

    public static void deleteEmployee(String firstName, String lastName) {
        for (int i = 0; i < numEmployees; i++) {
            if (employees[i].firstName.equals(firstName) && employees[i].lastName.equals(lastName)) {
                for (int j = i; j < numEmployees - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                numEmployees--;
                break;
            }
        }
    }

    public static void editEmployee(String firstName, String lastName, String newShift, int newPrimaryDinosaur) {
        for (int i = 0; i < numEmployees; i++) {
            if (employees[i].firstName.equals(firstName) && employees[i].lastName.equals(lastName)) {
                employees[i].shift = newShift;
                employees[i].primaryDinosaur = newPrimaryDinosaur;
                break;
            }
        }
    }
}

class ParkHours {
    LocalDateTime openingTime;
    LocalDateTime closingTime;
    DayOfWeek day;

    static ParkHours[] parkHours = new ParkHours[7];

    public static void addTime(DayOfWeek day, LocalDateTime openingTime, LocalDateTime closingTime) {
        int index = day.getValue() - 1;
        ParkHours ph = new ParkHours();
        ph.day = day;
        ph.openingTime = openingTime;
        ph.closingTime = closingTime;
        parkHours[index] = ph;
    }

    public static void editTime(DayOfWeek day, LocalDateTime newOpeningTime, LocalDateTime newClosingTime) {
        int index = day.getValue() - 1;
        if (parkHours[index] != null) {
            parkHours[index].openingTime = newOpeningTime;
            parkHours[index].closingTime = newClosingTime;
        }
    }

    public static void deleteTime(DayOfWeek day) {
        int index = day.getValue() - 1;
        parkHours[index] = null;
    }
}
