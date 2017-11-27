package io.github.mmyers.prime;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * DOCUMENT ME!
 *
 * @version  $Revision$, $Date$
 */
public class UserInterface {
    private final Scanner consoleReader = new Scanner(System.in);

    /**
     * Creates a new UserInterface object.
     */
    public UserInterface() {
    }

    /**
     * Returns the console reader value.
     *
     * @return  console reader value.
     */
    public Scanner getConsoleReader() {
        return consoleReader;

    }

    /**
     * Requests numbers for the range.
     *
     * @return  ArrayList
     */
    public ArrayList<Integer> requestNumbers() {
        final ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        System.out.println("Enter the minimum number: ");
        userNumbers.add(0, requestUserInteger());
        System.out.println("Enter the maximum number: ");
        userNumbers.add(1, requestUserInteger());

        return userNumbers;

    }

    /**
     * Returns valid Integer as user input from the console.
     *
     * @return  user number value.
     */
    public Integer requestUserInteger() {
        String userInput;
        Integer userInteger = -1;

        while (userInteger <= -1) {
            userInput = consoleReader.next();

            try {
                userInteger = Integer.parseInt(userInput);

            } catch (NumberFormatException ex) {
            }

            if (userInteger <= -1) {
                System.out.println("That value is not a positive whole number.");
                System.out.println("Please enter a valid number: ");

            }

        }

        return userInteger;

    }

    /**
     * Instructs the user.
     */
    public void userInstructions() {
        System.out.println("Prime Number Search");
        System.out.println(
            "This program accepts two whole positive numbers and outputs the prime numbers in that range.");

    }

}
