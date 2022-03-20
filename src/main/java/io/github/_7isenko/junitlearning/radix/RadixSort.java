package io.github._7isenko.junitlearning.radix;

import java.util.Arrays;

/**
 * @author 7isenko
 */
public class RadixSort {

    public void sort(int[] array) throws IllegalArgumentException {

        // Checking
        if (array == null) {
            throw new IllegalArgumentException("Array is null.");
        }

        if (array.length == 0) {
            return;
        }

        if (Arrays.stream(array).min().getAsInt() < 0) {
            throw new IllegalArgumentException("Radix sort works only with positive numbers.");
        }

        // Sorting
        int max = Arrays.stream(array).max().getAsInt();
        int length = String.valueOf(max).length();

        int[][] bucket = new int[10][array.length];
        int[] bucketCount = new int[array.length];

        int divisor = 1;

        // Initialize the buckets
        for (int pass = 0; pass < length; pass++) {

            for (int i = 0; i < array.length; i++) {
                bucketCount[i] = 0;
            }

            // sort the numbers according to the digit at passth place
            for (int value : array) {
                int remainder = (value / divisor) % 10;
                bucket[remainder][bucketCount[remainder]] = value;
                bucketCount[remainder] += 1;
            }

            // collect the numbers after PASS pass
            for (int k = 0, i = 0; k < 10 && i < array.length; k++) {
                for (int j = 0; j < bucketCount[k]; j++, i++) {
                    array[i] = bucket[k][j];
                }
            }
            divisor *= 10;
        }
    }
}
