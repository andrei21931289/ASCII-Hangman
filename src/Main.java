import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Hangman!");
        System.out.println("Input secret word: ");
        Scanner scanner = new Scanner(System.in);
        String secretWord = scanner.nextLine();
        secretWord = secretWord.toLowerCase();
        clearScreen();


        int lives = 7;
        ArrayList<Character> previousGuesses = new ArrayList<>();
        char copy[] = secretWord.toCharArray();
        for (int i = 0; i < copy.length; i++) {
            copy[i] = '*';
        }


        while (lives > 0) {
            clearScreen();
            char secretWordArray [] = secretWord.toCharArray();
            if (Arrays.equals(copy, secretWordArray)) {
                break;
            }
            System.out.println("Previous guesses: " + previousGuesses);
            System.out.println("Lives left: " + lives);
            System.out.println(copy);
            System.out.println("Next guess: ");
            char guess = scanner.next().charAt(0);
            if (secretWord.contains(String.valueOf(guess))) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == guess) {
                        copy[i] = guess;
                    }
                }
                previousGuesses.add(guess);
                continue;

            } else if (!(secretWord.contains(String.valueOf(guess)))) {
                lives = lives - 1;
                previousGuesses.add(guess);

            }

        }

        if (lives == 0) {

            System.out.println("      -------\n" +
                    "      |     |\n" +
                    "      |     @\n" +
                    "      |    /|\\ \n" +
                    "      |     |\n" +
                    "      |    / \\\n" +
                    " _____|_________\n" +
                    "/     |         /|\n" +
                    "______________ / /\n" +
                    "             |  /\n" +
                    "______________ /");
        }

        if (lives > 0) {
            System.out.println("The word was: " + secretWord);
            System.out.println("You win!!!!");
            System.out.println("      ____\n" +
                    "            /____ `\\\n" +
                    "           ||_  _`\\ \\\n" +
                    "     .-.   `|O, O  ||\n" +
                    "     | |    (/    -)\\\n" +
                    "     | |    |`-'` |\\`\n" +
                    "  __/  |    | _/  |\n" +
                    " (___) \\.  _.\\__. `\\___\n" +
                    " (___)  )\\/  \\    _/  ~\\.\n" +
                    " (___) . \\   `--  _   `\\\n" +
                    "  (__)-    ,/        (   |\n" +
                    "       `--~|         |   |\n" +
                    "           |         |   | ");
        }


    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}