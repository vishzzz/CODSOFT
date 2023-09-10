import java.util.Random;
import java.util.Scanner;
 class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("You have " + maxAttempts + " attempts to guess the number between "
                + minRange + " and " + maxRange + ".");

        while (true) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations user! You've guessed the correct number.");
                    score++;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                break;
            }
        }

        System.out.println("Your score: " + score);
        scanner.close();
    }
}
