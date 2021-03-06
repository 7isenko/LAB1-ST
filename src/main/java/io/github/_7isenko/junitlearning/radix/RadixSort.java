package io.github._7isenko.junitlearning.radix;

import java.util.Arrays;

/**
 * @author 7isenko
 */
public class RadixSort {
    private final int[] digits = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void sort(int[] array) throws IllegalArgumentException {
        // Checking
        if (check(array)) return;

        // Sorting
        int[] tempArray = array.clone();

        int length = countMaxNumberDigits(array);
        for (int i = 1; i <= length; i++) {
            resetDigits();
            tempArray = iterate(tempArray, i);
        }

        System.arraycopy(tempArray, 0, array, 0, array.length);

    }

    /**
     * Commits an iteration of the radix sorting
     * @return current step array state
     */
    private int[] iterate(int[] arr, int pos) {
        int[] newArr = new int[arr.length];

        for (int num : arr) {
            int digit = getDigitAt(num, pos);
            if (digit != -1) {
                digits[digit] = digits[digit] + 1;
            }
        }

        for (int i = 1; i <= 9; i++) {
            digits[i] = digits[i - 1] + digits[i];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int digit = getDigitAt(arr[i], pos);
            digits[digit] = digits[digit] - 1;
            newArr[digits[digit]] = arr[i];
        }
        return newArr;
    }

    /**
     * Checks if given array is empty or invalid, otherwise false
     *
     * @return true if there is nothing to sort (empty array);
     *         false if input is valid
     * @throws IllegalArgumentException on null or negative numbers in the array
     */
    protected boolean check(int[] array) throws IllegalArgumentException {
        if (array == null) {
            throw new IllegalArgumentException("Array is null.");
        }

        if (array.length == 0) {
            return true;
        }

        if (Arrays.stream(array).min().getAsInt() < 0) {
            throw new IllegalArgumentException("Radix sort works only with positive numbers.");
        }

        return false;
    }

    /**
     * Works even if position is bigger than length of the number
     *
     * @param number to get digit from
     * @param position index of digit to get.
     * @return digit at the given position
     */
    protected int getDigitAt(int number, int position) {
        if (position <= 0) return -1;

        int digit = 0;
        while (position > 0) {
            digit = number % 10;
            number /= 10;
            position -= 1;
        }
        return digit;
    }

    /**
     * @implNote Implemented for positive numbers
     * @return length of max number in the given array
     */
    protected int countMaxNumberDigits(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();

        return String.valueOf(max).length();
    }

    private void resetDigits() {
        for (int i = 0; i <= 9; i++) {
            digits[i] = 0;
        }
    }

}
