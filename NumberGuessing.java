import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game! 🎮");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1; 
            int maxAttempts = 5;
            int attempts = 0;
            boolean hasWon = false;

            System.out.println("\nYou have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts && !hasWon) {
                System.out.print("Enter your guess: ");
                int guess;
                
                try {
                    guess = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("⚠️ Please enter a valid number!");
                    scanner.nextLine();
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    hasWon = true;
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts!");
                } else if (guess < targetNumber) {
                    System.out.println("⬆️ Too low! Try a higher number.");
                } else {
                    System.out.println("⬇️ Too high! Try a lower number.");
                }

                if (!hasWon && attempts < maxAttempts) {
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                }
            }

            if (!hasWon) {
                System.out.println("😢 Game over! The number was: " + targetNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            playAgain = playChoice.equals("yes");
        }

        System.out.println("\nThanks for playing! 👋");
        scanner.close();
    }
}