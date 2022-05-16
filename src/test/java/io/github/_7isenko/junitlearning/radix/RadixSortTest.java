package io.github._7isenko.junitlearning.radix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 7isenko
 */
class RadixSortTest {

    private static RadixSort radixSort;

    @BeforeAll
    static void setupSort() {
        radixSort = new RadixSort();
    }

    @Test
    void sort() {
        int[] arr = {1000, 1, 4, 6, 100, 14, 2};
        int[] sorted = {1, 2, 4, 6, 14, 100, 1000};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sortLongerArray() {
        int[] arr = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sortBiggerNumbers() {
        int[] arr = {Integer.MAX_VALUE, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, Integer.MAX_VALUE};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sortSingleValue() {
        int[] arr = {1};
        int[] sorted = {1};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sortAllDigitsValue() {
        int[] arr = {1234567890, 987654321};
        int[] sorted = {987654321, 1234567890};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sortShouldThrowExceptionForNegativeValues() {
        int[] arr = {1, 4, -6, 0, 100};
        assertThrows(IllegalArgumentException.class, () -> radixSort.sort(arr));
    }

    @ParameterizedTest
    @NullSource
    void sortShouldThrowExceptionForNullArray(int[] arr) {
        assertThrows(IllegalArgumentException.class, () -> radixSort.sort(arr));
    }

    @ParameterizedTest
    @EmptySource
    void sortShouldExecuteForEmptyArray(int[] arr) {
        radixSort.sort(arr);
        assertArrayEquals(arr, arr);
    }

    @Test
    void checkShouldThrowExceptionForNegativeValues() {
        int[] arr = {1, -1};
        assertThrows(IllegalArgumentException.class, () -> radixSort.check(arr));
    }

    @ParameterizedTest
    @NullSource
    void checkShouldThrowExceptionForNullArray(int[] arr) {
        assertThrows(IllegalArgumentException.class, () -> radixSort.check(arr));
    }

    @ParameterizedTest
    @EmptySource
    void checkShouldReturnTrueForEmptyArray(int[] arr) {
        assertTrue(radixSort.check(arr));
    }

    @Test
    void checkShouldReturnFalseForValidArray() {
        assertFalse(radixSort.check(new int[] {123, 431, 5555, 135}));
    }

    @ParameterizedTest
    @CsvSource({"12345,2,4", "321451, 2, 5"})
    void getDigitAtReturnsExpectedValues(int number, int position, int expected) {
        assertEquals(expected, radixSort.getDigitAt(number, position));
    }


    @Test
    void countMaxNumberDigitsReturnsExpectedValues() {
        int[] input = {2, 515, 100000, 99999};
        assertEquals(6, radixSort.countMaxNumberDigits(input));
    }

}