import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1; // Minimum number
        int upperBound = 100; // Maximum number
        int randomNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 5; // Predefined limit of attempts
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between " + lowerBound + " and " + upperBound);

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                guessedCorrectly = true;
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println(
                    "Sorry, you've exceeded the maximum number of attempts. The correct number was: " + randomNumber);
        }

        scanner.close();
    }
}
