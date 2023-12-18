import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalAttempts = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        System.out.print("How many attempts would you like per round? Enter a number: ");
        int attemptsPerRound = scanner.nextInt();

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew round! Guess the number between 1 and 100.");
            while (attempts < attemptsPerRound) { // Limiting attempts based on user's choice
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You've guessed the correct number: " + secretNumber);
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low! Try a higher number.");
                } else {
                    System.out.println("Too high! Try a lower number.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.next();
            if (!playChoice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();
    }
}
