package io.github.mmyers.testng;

import io.github.mmyers.prime.PrimeNumberSearch;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Unit Tests for the prime-numbers project.
 *
 * @version  $Revision$, $Date$
 */
public class UnitTests {
    private PrimeNumberSearch numberSearch = new PrimeNumberSearch();

    /**
     * Creates a new UnitTests object.
     */
    public UnitTests() {
    }

    /**
     * Returns data provider for the testFindPrimeNumbers().
     *
     * @return  Object[][]
     */
    @DataProvider(name = "findNumbersData")
    public Object[][] findNumbersData() {
        return new Object[][] {
                { 1, 35, new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)) },
                {
                    12, 180,
                    new ArrayList<Integer>(Arrays.asList(13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                            79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
                            179))
                },
                {
                    140, 200,
                    new ArrayList<Integer>(Arrays.asList(149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199))
                }
            };

    }

    /**
     * Returns the prime data value.
     *
     * @return  prime data value.
     */
    @DataProvider(name = "isPrimeData")
    public Object[][] isPrimeData() {
        return new Object[][] {
                { 2, true },
                { 11, true },
                { 37, true },
                { 61, true },
                { 89, true },
                { 109, true },
                { 139, true },
                { 173, true },
                { 199, true },
                { 1, false },
                { 22, false },
                { 86, false },
                { 112, false },
                { 2000, false },
                { 4008, false }
            };

    }

    /**
     * Tests findPrimeNumbers, it should find the prime numbers between a range.
     *
     * @param  minValue
     * @param  maxValue
     * @param  expPrimeNumbers
     */
    @Test(
        dataProvider = "findNumbersData",
        dependsOnMethods = "testIsPrime"
    )
    public void testFindPrimeNumbers(final Integer minValue, final Integer maxValue,
        final ArrayList<Integer> expPrimeNumbers) {
        Assert.assertEquals(numberSearch.findPrimeNumbers(minValue, maxValue), expPrimeNumbers);

    }

    /**
     * Tests isPrime(), it should properly differentiates between prime and non-prime numbers.
     *
     * @param  number
     * @param  expResult
     */
    @Test(dataProvider = "isPrimeData")
    public void testIsPrime(final Integer number, final Boolean expResult) {
        Assert.assertEquals(numberSearch.isNumberPrime(number), expResult);

    }

}
