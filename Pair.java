package com.company;

import java.util.HashMap;
import java.util.Map;

final class Pair {


    static int arr[] = new int[]{6, 6, 3, 9, 5, 1};
    public static void main(String[] args) {

        int sum = 12;
        System.out.println("Count of pairs is " +
                numberOfPairs(arr, sum));
    }


    public static int numberOfPairs(int[] input, long k) {
        Map<Long, Long> frequencies = new HashMap<>();
        int pairsCount = 0;

        for (int i = 0; i < input.length; i++) {
            Long value = Long.parseLong(""+input[i]);
            long complement = k - input[i];

            if (frequencies.containsKey(complement)) {
                Long freq = frequencies.get(complement) - 1;
                pairsCount++;
                //System.out.println(value + ", " + complement);
                if (freq == 0) {
                    frequencies.remove(complement);
                } else {
                    frequencies.put(complement, freq);
                }
            } else {
                if (frequencies.containsKey(value)) {
                    frequencies.put(value, frequencies.get(value) + 1);
                } else {
                    frequencies.put(value, 1l);
                }
            }
        }
        return pairsCount;
    }

}
