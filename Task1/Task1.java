package CodSoft;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        final String RED = "\033[31m";
        final String RESET = "\033[0m";

        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int n = 5, round = 1, userInput = 0, count = 0, pts = 0;
        String s1;
        boolean playAgain = true;
        System.out.println(RED+"Welcome to Guess the Number Game!"+RESET);
        System.out.println("-------------------------------------");
        System.out.println("Rules of the game:\n1. Enter the number between 1 to 100.\n2. You can make only 5 guesses.");
        System.out.println("-------------------------------------");
        System.out.println("Point Distribution :\n1. At Attempt 1 : 10pts\n2. At Attempt 2 : 8pts\n3. At Attempt 3 : 6pts\n4. At Attempt 4 : 4pts\n5. At Attempt 5 : 2pts\nIf not guessed in the given attempts 0pts");

        while (playAgain) {

            // Generating random number from 1 to 100
            int rNumber = random.nextInt(100) + 1;
            System.out.println("-------------------------------------");
            System.out.println(RED+"Round "+round+RESET);
            System.out.println("-------------------------------------");
            System.out.println("Please make your guess.");

            for (int i = 1; i <= n; i++) {
                count++;
                System.out.printf("Attempt %d: ", i);

                // Getting user input
                userInput = sc.nextInt();

                if (userInput < 1 || userInput > 100) {
                    System.out.println("Please enter the number between 1 to 100: ");
                } else if (userInput == rNumber) {
                    System.out.println("Congratulations! You have guessed the number.\nYou Won!");
                    break;
                } else if (userInput > rNumber) {
                    System.out.println("Too High");
                } else {
                    System.out.println("Too Low");
                }
                if (i == n) {
                    System.out.println("-------------------------------------");
                    System.out.println("You are out of guesses.\nYou Lose!");
                    System.out.println("The number was " + rNumber);

                }
            }
            System.out.println("-------------------------------------");
            if (userInput != rNumber) {
                count++;
            }

            // For Point Calculation
            switch (count) {
                case 1:
                    pts += 10;
                    break;
                case 2:
                    pts += 8;
                    break;
                case 3:
                    pts += 6;
                    break;
                case 4:
                    pts += 4;
                    break;
                case 5:
                    pts += 2;
                    break;
                default:
                    pts += 0;
            }
            System.out.println("Do you want to play again? (Yes/No)");
            s1 = sc.next();
            playAgain = s1.equalsIgnoreCase("Yes");
            if (playAgain) {
                round++;
                count = 0;
            }
        }
        System.out.println("Total Points Won = "+pts + "pts");
    }
}