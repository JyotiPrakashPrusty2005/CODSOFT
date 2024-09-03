import java.util.Scanner;
import java.util.Random;

public class codsoft_task1 {
    
     private static final int low_bound = 1;
     private static final int upper_bound = 100;
     private static final int max_attempts = 10;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        boolean again_play;
        int rounds_total = 0;
        int won_rounds = 0;

        do {
            int numberToGuess = rand.nextInt(upper_bound - low_bound + 1) + low_bound;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("A number between " + low_bound + " and " + upper_bound + " has been generated.");
            System.out.println("You have " + max_attempts + " attempts to guess it.");

            while (attempts < max_attempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            rounds_total++;
            if (guessedCorrectly) {
                won_rounds++;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            again_play = sc.next().equalsIgnoreCase("yes");

        } while (again_play);

        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + rounds_total);
        System.out.println("Rounds Won: " + won_rounds);
        sc.close();
    }
}

    
