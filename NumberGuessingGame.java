package cod;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_ATTEMPTS = 10;
    private static final int RANGE_MIN = 1;
    private static final int RANGE_MAX = 100;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
			Random random = new Random();
			int totalScore = 0;
			boolean playAgain = true;

			while (playAgain) {
			    int randomNumber = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
			    int attempts = 0;
			    boolean hasGuessedCorrectly = false;

			    System.out.println("A random number between " + RANGE_MIN + " and " + RANGE_MAX + " has been generated.");
			    System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the number.");

			    while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
			        System.out.print("Enter your guess: ");
			        int guess = scanner.nextInt();
			        attempts++;

			        if (guess < randomNumber) {
			            System.out.println("Too low!");
			        } else if (guess > randomNumber) {
			            System.out.println("Too high!");
			        } else {
			            System.out.println("Correct! You've guessed the number in " + attempts + " attempts.");
			            totalScore += (MAX_ATTEMPTS - attempts + 1); // Score based on remaining attempts
			            hasGuessedCorrectly = true;
			        }
			    }

			    if (!hasGuessedCorrectly) {
			        System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
			    }

			    System.out.print("Do you want to play again? (yes/no): ");
			    String response = scanner.next();
			    playAgain = response.equalsIgnoreCase("yes");
			}

			System.out.println("Game Over! Your total score is: " + totalScore);
		}
    }
}
