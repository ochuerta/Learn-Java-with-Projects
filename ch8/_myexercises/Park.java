package ch8._myexercises;

public class Park {
    enum OpenDay {
        MONDAY("9-5"),
        TUESDAY("9-5"),
        WEDNESDAY("9-5"),
        THURSDAY("9-5"),
        FRIDAY("9-10"),
        SATURDAY("10-5");

        private String hoursOfOperation;
        OpenDay(String hoursOfOperation) {
            this.hoursOfOperation = hoursOfOperation;
        }
        public String getHoursOfOperation() {
            return hoursOfOperation;
        }
    }

    public static void main(String[] args) {
        String[] parkAnimals = {"T-Rex", "Velociraptor", "Deinonychus", "Triceratops", "Tyrannosaurus", "Stegosaurus"};
        String[] parkEnclosures = {"Small Herbivore Enclosure", "Medium Herbivore Enclosure", "Large Herbivore Enclosure", "Carnivore Enclosure"};
    }
}
