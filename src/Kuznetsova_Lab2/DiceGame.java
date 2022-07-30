/*
 * Ekaterina Kuznetsova
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package Kuznetsova_Lab2;
import java.util.Scanner; //needed for user input

/**
 * The DiceGame plays a game between the computer and user of program;
 * the game is rigged towards the computer through a loaded die, which
 * uses a class 'LoadedDie' in the same package; the program keeps track
 * and prints the winner of the game.
 *
 * @author Ekaterina Kuznetsova
 * @version 1.0
 */
public class DiceGame {
    /**
     * The main method creates a Scanner object, runs the basic methods of
     * the game, and closes the Scanner object; the basic methods include
     * a welcome method, a method running the game that the user can repeat,
     * and a goodbye method.
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        //create scanner object for user input
        Scanner keyboard = new Scanner(System.in);

        //welcome message
        welcome();

        //do-while loop method
        userRepeat(keyboard);

        //goodbye message
        goodbye();

        //close scanner
        keyboard.close();
    }

    /**
     * Welcome method welcomes the user and introduces the program
     */
    public static void welcome() {
        //create welcome string
        String welcome = "Welcome!";
        //print string in middle of 80 characters
        System.out.printf("%32s\n", welcome);
        //print message
        System.out.println("This is a game of you versus the computer. We " +
                "will each\nhave one die. We roll our own die and the " +
                "higher number\nwins. We roll ten times and the one with " +
                "the higher number\nof wins is the grand winner.");
    }

    /**
     * goodbye method prints a farewell message and thanks the user
     */
    public static void goodbye() {
        //print goodbye message
        System.out.println("Thanks! Goodbye for now!");
    }

    /**
     * userRepeat method repeats the program as many times as the user wishes
     *
     * @param keyboard  A scanner object for user input
     */
    public static void userRepeat(Scanner keyboard) {
        //declare variable to hold user response
        char repeat;
        //array to hold tally of computer and user wins
        int[] count = new int[2];

        //create do-while loop for user to repeat game
        do {
            //call tenTurns method to run one game
            tenTurns(keyboard, count);

            //call winner method to determine winner
            winner(count);

            //prompt user for repeat of game
            System.out.print("\nRepeat the game? (Y/N): ");
            repeat = keyboard.nextLine().toLowerCase().charAt(0);

        //conclude do-while loop with verification of user response
        } while (repeat == 'y');

    }

    /**
     * The tenTurns method repeats the steps of a single round of the game
     * ten times
     *
     * @param keyboard
     * @param count
     */
    public static void tenTurns(Scanner keyboard, int[] count) {
        //initialize constant variables
        //number of rounds
        final int TURNS = 10;
        //prioritized number for computer
        final int LOADED_NUM_C = 6;
        //prioritized number for user
        final int LOADED_NUM_U = 1;
        //percent to prioritize by
        final int MORE_TIMES_PER_HUNDRED = 30;

        //initiate String variables
        String iRoll = "I rolled a ";
        String uRoll = "You rolled a ";
        String ready = "Ready to roll? (Press ENTER when ready)";

        //begin 10 rounds of game
        for (int i = 0; i < TURNS; i++) {

            //print current round
            System.out.printf("\nRoll %d of out %d:\n", i + 1, TURNS);

            //computer turn - create object and print result
            LoadedDie diceC = new LoadedDie(LOADED_NUM_C,
                    MORE_TIMES_PER_HUNDRED);
            System.out.println(iRoll + diceC.getValue());

            //prompt user & continue code after 'enter'
            System.out.print(ready);
            keyboard.nextLine();

            //user turn - create object & print result
            LoadedDie diceU = new LoadedDie(LOADED_NUM_U,
                    MORE_TIMES_PER_HUNDRED);
            System.out.println(uRoll + diceU.getValue());

            //round tally:
            //if computer wins round, count up
            if (diceC.getValue() > diceU.getValue()) {
                count[0]++;
            }
            //if user wins round, count up
            else if (diceU.getValue() > diceC.getValue()) {
                count[1]++;
            }
            //if a tie, let user know
            else if (diceU.getValue() == diceC.getValue())
                System.out.println("A tie this round!");

        }
    }

    /**
     * The winner method determines and prints who was the final winner
     * of the game.
     *
     * @param count
     */
    public static void winner(int[] count) {

        //if the computer count is greater than the user
        if (count[0] > count[1]) {
            System.out.println("\nGrand winner is me!");
            //if the user count is greater
        } else if (count[1] > count[0]) {
            System.out.println("\nGrand winner is you!");
        } else {
            //if it's a tie!
            System.out.println("\nIt's a tie! No winner");
        }
    }

}


