package io.github.mmyers.prime;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Accepts two numbers as a range and returns all the prime numbers between them.
 *
 * @version  $Revision$, $Date$
 */
public class PrimeNumberSearch {
    /**
     * Creates a new PrimeNumberSearch object.
     */
    public PrimeNumberSearch() {
    }

    /**
     * Main method for running the search.
     *
     * @param  args
     */
    public static void main(final String[] args) {
        final PrimeNumberSearch primeSearch = new PrimeNumberSearch();
        primeSearch.runSearch();

    }

    /**
     * Finds any Prime numbers in the range and stores them in an ArrayList.
     *
     * @param   minNumber
     * @param   maxNumber
     *
     * @return  finds any Prime numbers in the range and stores them in an ArrayList.
     */
    public ArrayList<Integer> findPrimeNumbers(final Integer minNumber, final Integer maxNumber) {
        final ArrayList<Integer> primeNumbers = new ArrayList<Integer>();

        for (int i = minNumber + 1; i < maxNumber; i++) {
            if (isNumberPrime(i)) {
                primeNumbers.add(i);

            }

        }

        return primeNumbers;

    }

    /**
     * Returns valid Integer as user input from the console.
     *
     * @return  user number value.
     */
    public Integer getUserNumber() {
        final Scanner reader = new Scanner(System.in);

        Integer userInteger = reader.nextInt();

        while (validateNumber(userInteger).equals(false)) {
            System.out.println(userInteger + " is not a positive whole number.");
            System.out.println("Please enter a positive whole number: ");
            userInteger = reader.nextInt();

        }

        reader.close();

        return userInteger;

    }

    /**
     * Returns the valid range value.
     *
     * @return  the valid range value.
     */
    public ArrayList<Integer> getValidRange() {
        ArrayList<Integer> numberRange = requestNumbers();

        while (validateRange(numberRange).equals(false)) {
            System.out.println(
                "That range is not valid, the lowest number should be entered first and highest number second");
            numberRange = requestNumbers();

        }

        return numberRange;

    }

    /**
     * Returns the number prime value.
     *
     * @param   number
     *
     * @return  number prime value.
     */
    public Boolean isNumberPrime(final Integer number) {
        if (number == 2) {
            return true;

        } else if (number < 2) {
            return false;

        } else if ((number % 2) == 0) {
            // The number is a multiple of 2 so it's not a prime
            return false;

        }

        // Determine if the number is a multiple of any odd number less than the number itself
        for (int i = 3; (i * i) <= number; i += 2) {
            if ((number % i) == 0) {
                return false;

            }

        }

        return true;

    }

    /**
     * Prints the prime numbers in the users range.
     *
     * @param  primeNumbers
     * @param  numberRange
     */
    public void printNumbers(final ArrayList<Integer> primeNumbers, final ArrayList<Integer> numberRange) {
        if (primeNumbers.size() == 0) {
            System.out.println("There were no prime numbers between " + numberRange.get(0) + " and " +
                numberRange.get(1));

        } else {
            System.out.println("These are the prime numbers between " + numberRange.get(0) + " and " +
                numberRange.get(1) + ": ");

            for (final Integer primeNumber : primeNumbers) {
                System.out.println(primeNumber);

            }

        }

    }

    /**
     * DOCUMENT ME!
     *
     * @return  ArrayList
     */
    public ArrayList<Integer> requestNumbers() {
        final ArrayList<Integer> userNumbers = new ArrayList<Integer>();

        System.out.println("Enter the minimum number: ");
        userNumbers.add(0, getUserNumber());
        System.out.println("Enter the maximum number: ");
        userNumbers.add(1, getUserNumber());

        return userNumbers;

    }

    /**
     * Runs the PrimeNumber search.
     */
    public void runSearch() {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        ArrayList<Integer> numberRange = new ArrayList<Integer>();

        userInstructions();
        numberRange = getValidRange();
        primeNumbers = findPrimeNumbers(numberRange.get(0), numberRange.get(1));
        printNumbers(primeNumbers, numberRange);

    }

    /**
     * Instructs the user.
     */
    public void userInstructions() {
        System.out.println("Prime Number Search");
        System.out.println(
            "This program accepts two whole positive numbers and outputs the prime numbers in that range.");

    }

    /**
     * Validates that number is valid for the search by determining that it is a whole positive number.
     *
     * @param   numberToValidate
     *
     * @return  Integer
     */
    public Boolean validateNumber(final Integer numberToValidate) {
        if (numberToValidate > 0) {
            return true;

        }

        return false;

    }

    /**
     * Determines if the range is valid for a prime number search.
     *
     * @param   numberRange
     *
     * @return  Boolean
     */
    public Boolean validateRange(final ArrayList<Integer> numberRange) {
        return numberRange.get(0) < numberRange.get(1);

    }

}
