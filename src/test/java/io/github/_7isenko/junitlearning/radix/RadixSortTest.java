package io.github._7isenko.junitlearning.radix;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

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
        int[] arr = {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};

        radixSort.sort(arr);
        assertArrayEquals(sorted, arr);
    }

    @Test
    void sort_BiggerNumbers() {
        int[] arr = {2000000000, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2};
        int[] sorted = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2000000000};

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
        assertArrayEquals(arr, arr);
    }
}