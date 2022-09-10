package com.diac.algorithms.data;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {

    public static int[] ofInt(int size) {
        int[] array = new int[size];
        var random = new Random();
        for (var i = 0; i < size; i++) {
            array[i] = random.nextInt(size) - size / 2;
        }
        return array;
    }

    public static int[] ofIntSorted(int size) {
        int[] array = ofInt(size);
        return Arrays.stream(array)
                .sorted()
                .toArray();
    }

    public static int[] ofIntUniqueSorted(int size) {
        int[] array = new int[size];
        var random = new Random();
        var val = random.nextInt(size) - size / 2;
        var inc = random.nextInt(size / 4) + 1;
        for (var i = 0; i < size; i++) {
            array[i] = val;
            val += random.nextInt(inc);
        }
        return array;
    }
}
