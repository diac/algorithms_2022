package com.diac.binarysearch;

import com.diac.algorithms.data.RandomArray;

import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        var array = RandomArray.ofIntUniqueSorted(100);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]: %d", i, array[i]);
            System.out.println();
        }
        var random = new Random();
        var searchValue = array[random.nextInt(array.length)];
        var iterativeResult = binarySearchIterative(array, searchValue);
        System.out.printf("Iterative search: position of %d is %d", searchValue, iterativeResult);
        System.out.println();
        var recursiveResult = binarySearchRecursive(array, searchValue, 0, array.length - 1);
        System.out.printf("Recursive search: position of %d is %d", searchValue, recursiveResult);
        System.out.println();
    }

    private static int binarySearchIterative(int[] array, int searchValue) {
        int result = -1;
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (searchValue == array[mid]) {
                result = mid;
                break;
            } else if (searchValue < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    private static int binarySearchRecursive(int[] array, int searchValue, int left, int right) {
        int result = -1;
        if (left <= right) {
            int mid = (left + right) / 2;
            if (searchValue < array[mid]) {
                result = binarySearchRecursive(array, searchValue, left, mid - 1);
            } else if (searchValue > array[mid]) {
                result = binarySearchRecursive(array, searchValue, mid + 1, right);
            } else {
                result = mid;
            }
        }
        return result;
    }
}
