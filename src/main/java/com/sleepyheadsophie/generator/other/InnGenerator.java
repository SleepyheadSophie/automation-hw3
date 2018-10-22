package com.sleepyheadsophie.generator.other;

import java.util.concurrent.ThreadLocalRandom;

public class InnGenerator {

    private static final int REGION_VALUE = 77;
    private static final int INSPECTION_MIN_VALUE = 10;
    private static final int INSPECTION_MAX_VALUE = 51;

    public static String generateInn() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REGION_VALUE);
        stringBuilder.append(ThreadLocalRandom.current().nextInt(INSPECTION_MIN_VALUE, INSPECTION_MAX_VALUE));
        stringBuilder.append(ThreadLocalRandom.current().nextInt(100000, 999999));

        int[] innNumbers = new int[11];
        String innNumbersString = stringBuilder.toString();

        for (int i = 0; i < 10; i++) {
            innNumbers[i] = innNumbersString.charAt(i);
        }

        int firstKey = (((7 * innNumbers[0]) + (2 * innNumbers[1]) + (4 * innNumbers[2]) + (10 * innNumbers[3]) + (3 * innNumbers[4]) + (5 * innNumbers[5]) + (9 * innNumbers[6]) + (4 * innNumbers[7]) + (6 * innNumbers[8]) + (8 * innNumbers[9])) % 11) % 10;
        innNumbers[10] = firstKey;
        int secondKey = (((3 * innNumbers[0]) + (7 * innNumbers[1]) + (2 * innNumbers[2]) + (4 * innNumbers[3]) + (10 * innNumbers[4]) + (3 * innNumbers[5]) + (5 * innNumbers[6]) + (9 * innNumbers[7]) + (4 * innNumbers[8]) + (6 * innNumbers[9]) + (8 * innNumbers[10])) % 11) % 10;

        stringBuilder.append(firstKey);
        stringBuilder.append(secondKey);

        return stringBuilder.toString();
    }
}
