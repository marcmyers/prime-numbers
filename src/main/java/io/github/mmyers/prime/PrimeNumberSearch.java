package io.github.mmyers.prime;

import java.io.BufferedWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;


/**
 * Accepts two numbers as a range and returns all the prime numbers between them.
 *
 * @version  $Revision$, $Date$
 */
public class PrimeNumberSearch {
    UserInterface userInterface;

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
     * Determines if a number is a prime number.
     *
     * @param   number
     *
     * @return  number prime value.
     */
    public Boolean isNumberPrime(final Integer number) {
        Boolean isPrime = true;

        if (number != 2) {
            if (number < 2) {
                isPrime = false;

            } else if ((number % 2) == 0) {
                // The number is a multiple of 2 so it's not a prime
                isPrime = false;

            }

            // Determine if the number is a multiple of any odd number less than the number itself
            for (int i = 3; (i * i) <= number; i += 2) {
                if ((number % i) == 0) {
                    isPrime = false;

                }

            }

        }

        return isPrime;

    }

    /**
     * Returns the valid range value.
     *
     * @return  the valid range value.
     */
    private ArrayList<Integer> getValidRange() {
        ArrayList<Integer> numberRange = userInterface.requestNumbers();

        while (validateRange(numberRange).equals(false)) {
            System.out.println(
                "That range is not valid, the lowest number should be entered first and highest number second");
            numberRange = userInterface.requestNumbers();

        }

        return numberRange;

    }

    /**
     * Prints the prime numbers in the users range.
     *
     * @param  primeNumbers
     * @param  numberRange
     */
    private void printNumbers(final ArrayList<Integer> primeNumbers, final ArrayList<Integer> numberRange) {
        if (primeNumbers.size() == 0) {
            System.out.println("There were no prime numbers between " + numberRange.get(0) + " and " +
                numberRange.get(1));

        } else {
            System.out.println("These are the prime numbers between " + numberRange.get(0) + " and " +
                numberRange.get(1) + ": ");

            for (final Integer primeNumber : primeNumbers) {
                System.out.println(primeNumber);

            }

            writeResultsFile(primeNumbers);

        }

    }

    /**
     * Runs the PrimeNumber search.
     */
    private void runSearch() {
        ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
        ArrayList<Integer> numberRange = new ArrayList<Integer>();

        userInterface.userInstructions();
        numberRange = getValidRange();
        primeNumbers = findPrimeNumbers(numberRange.get(0), numberRange.get(1));
        printNumbers(primeNumbers, numberRange);
        userInterface.getConsoleReader().close();

    }

    /**
     * Determines if the range is valid for a prime number search.
     *
     * @param   numberRange
     *
     * @return  Boolean
     */
    private Boolean validateRange(final ArrayList<Integer> numberRange) {
        return numberRange.get(0) < numberRange.get(1);

    }

    /**
     * Writes a results file of all the prime numbers found in the range.
     *
     * @param  results
     */
    private void writeResultsFile(final ArrayList<Integer> results) {
        final String file = "PrimeNumbers.txt";
        System.out.println("Writing results to: " + file);

        try(final BufferedWriter writer = Files.newBufferedWriter(Paths.get(file))) {
            for (final Integer number : results) {
                writer.write(number.toString() + "\n");

            }

        } catch (IOException ioException) {
            System.out.println("There was an issue writing the results file: ");
            System.out.println(ioException);

        }


    }

}
