import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int targetNumber = random.nextInt(100);
        int tries = 0;
        boolean hasGuessed = false;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I've selected a number between " + min + " and " + max + ". Try to guess it.");

        while (!hasGuessed) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
           tries++;

            if (guess < min || guess > max) {
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } else if (guess < targetNumber) {
                System.out.println("Try a higher number.");
            } else if (guess > targetNumber) {
                System.out.println("Try a lower number.");
            } else {
                System.out.println("Congratulations! You've guessed the number " + targetNumber + " in " + tries + " attempts.");
                hasGuessed = true;
            }
        }

        scanner.close();
    }
}
