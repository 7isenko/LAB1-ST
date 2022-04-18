package io.github._7isenko.junitlearning.radix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 7isenko
 */
class RadixSortTest {

    private final RadixSort radixSort = new RadixSort();

    @Test
    void sort() {
        int[] arr = {1000, 1, 4, 6, 100, 14, 2};
        int[] sorted = {1, 2, 4, 6, 14, 100, 1000};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_LongerArray() {
        int[] arr = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_BiggerNumbers() {
        int[] arr = {Integer.MAX_VALUE, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, Integer.MAX_VALUE};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_SingleValue() {
        int[] arr = {1};
        int[] sorted = {1};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_AllDigitsValue() {
        int[] arr = {1234567890, 987654321};
        int[] sorted = {987654321, 1234567890};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_ShouldThrowExceptionForNegativeValues() {
        int[] arr = {1, 4, -6, 0, 100};
        assertThrows(IllegalArgumentException.class, () -> radixSort.sort(arr));
    }

    @ParameterizedTest
    @NullSource
    void sort_ShouldThrowExceptionForNullArray(int[] arr) {
        assertThrows(IllegalArgumentException.class, () -> radixSort.sort(arr));
    }

    @ParameterizedTest
    @EmptySource
    void sort_ShouldExecuteForEmptyArray(int[] arr) {
        radixSort.sort(arr);
        assertArrayEquals(arr, arr);
    }

}