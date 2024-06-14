package ch5._myexercises;
import java.util.Random;

public class Exercise5_3 {
    public static void main(String[] args) {
        Random random = new Random();
        int parkStartHour = 8 + random.nextInt(2); // Random hour between 8 and 9
        int parkStartMinute = random.nextInt(60); // Random minute between 0 and 59
        int currentHour = 7; // Start at 7 AM
        int currentMinute = random.nextInt(60 * (parkStartHour - currentHour) + parkStartMinute); // Random minute before park start time

        while (currentHour < parkStartHour || (currentHour == parkStartHour && currentMinute < parkStartMinute)) {
            int minutesUntilOpen = (parkStartHour - currentHour) * 60 + (parkStartMinute - currentMinute);
            String currentTime = formatTime(currentHour, currentMinute) + " AM";
            String parkOpeningTime = formatTime(parkStartHour, parkStartMinute) + " AM";
            System.out.println("Current time: " + currentTime + ", Park opening time: " + parkOpeningTime + ", The park will open in " + minutesUntilOpen + " minutes.");

            currentMinute += 5; // Elapse 5 minutes
            if (currentMinute >= 60) {
                currentHour++;
                currentMinute -= 60;
            }
        }

        String finalTime = formatTime(parkStartHour, parkStartMinute) + " AM";
        System.out.println("Hurray! The park is open at " + finalTime + "! Come on in!");
    }

    private static String formatTime(int hour, int minute) {
        String hourString = String.format("%02d", hour);
        String minuteString = String.format("%02d", minute);
        return hourString + ":" + minuteString;
    }
}





