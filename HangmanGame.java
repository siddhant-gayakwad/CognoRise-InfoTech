import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static String[] words = {"apple", "banana", "orange", "grape", "kiwi", "melon", "pear"};
    private static Random random = new Random();
    private static String word = words[random.nextInt(words.length)];
    private static char[] wordToGuess = word.toCharArray();
    private static char[] guessedLetters = new char[wordToGuess.length];
    private static int attemptsLeft = 6;
    private static boolean hintGiven = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize guessedLetters array with underscores
        for (int i = 0; i < guessedLetters.length; i++) {
            guessedLetters[i] = '_';
        }

        while (true) {
            System.out.println("\nCurrent word: " + String.valueOf(guessedLetters));
            System.out.println("Attempts left: " + attemptsLeft);
            System.out.print("Guess a Fruit letter: ");
            char guess = scanner.next().charAt(0);

            if (!checkGuess(guess)) {
                attemptsLeft--;
                if (attemptsLeft == 0) {
                    System.out.println("\nYou ran out of attempts! The word was: " + word);
                    break;
                } else if (!hintGiven && attemptsLeft == 3) {
                    giveHint();
                    hintGiven = true;
                }
            }

            if (isWordGuessed()) {
                System.out.println("\nCongratulations! You guessed the Fruit Name: " + word);
                break;
            }
        }
    }

    private static boolean checkGuess(char guess) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == guess) {
                guessedLetters[i] = guess;
                found = true;
            }
        }
        if (!found) {
            System.out.println("The letter '" + guess + "' is not in the word.");
        }
        return found;
    }

    private static boolean isWordGuessed() {
        for (char letter : guessedLetters) {
            if (letter == '_') {
                return false;
            }
        }
        return true;
    }

    private static void giveHint() {
        System.out.println("\nHint: The word starts with the letter '" + word.charAt(0) + "'.");
    }
}
